//
//  ViewController.swift
//  OrdenaNumeros
//
//  Created by DAM on 4/10/16.
//  Copyright © 2016 DAM. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    // UIVariables
    @IBOutlet weak var b1: UIButton!
    @IBOutlet weak var b2: UIButton!
    @IBOutlet weak var b3: UIButton!
    @IBOutlet weak var b4: UIButton!
    @IBOutlet weak var b5: UIButton!
    @IBOutlet weak var b6: UIButton!
    @IBOutlet weak var timerLabel: UILabel!
    @IBOutlet weak var retryBut: UIButton!
    @IBOutlet weak var noTime: UILabel!
    @IBOutlet weak var pFinal: UILabel!
    @IBOutlet weak var puntos: UILabel!
   
    // Variables
    var inTime: Int = 30
    var timer: NSTimer!
    var num: [Int] = []
    var points: Int = 0
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        start()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }
    
    func start() {
        num = []
        noTime.hidden = true
        inTime = 30
        pFinal.hidden = true
        puntos.hidden = false
        retryBut.hidden = true
        createButtons()
        
        timer = NSTimer.scheduledTimerWithTimeInterval (1, target: self, selector: Selector("time") , userInfo: nil, repeats: true)

    }
    
    func createButtons() {
        // Creamos números aleatorios
        for _ in 0...5 {
            let n = Int(arc4random_uniform(200)) - 100
            num.append(n)
        }
        
        var buttons: [UIButton] = [b1, b2, b3, b4, b5, b6]
        for m in 0...5 {
            buttons[m].setTitle(String(num[m]), forState: .Normal)
        }
    }
    
    func time() {
        if inTime <= 0 {
            timer.invalidate()
            b1.hidden = true
            b2.hidden = true
            b3.hidden = true
            b4.hidden = true
            b5.hidden = true
            b6.hidden = true
            puntos.hidden = true
            noTime.text = "Se te ha acabado el tiempo :("
            noTime.hidden = false
            pFinal.text = "Puntuacion final: " + String(points)
            pFinal.hidden = false
            retryBut.hidden = false
        }
        var time: String? = String(inTime)
        if inTime >= 10 {
            time = "00:" + time!
        } else {
            time = "00:0" + time!
        }
        timerLabel.text = time
        inTime -= 1
        
    }
    
    @IBAction func clickButton(sender: UIButton) {
        num.sortInPlace()
        
        let activeButton = Int((sender.titleLabel!.text!))
     
        if num[0] == activeButton {
            num.removeAtIndex(0)
            sender.hidden = true
            points += 10
        } else {
            if points > 0 {
                points -= 5
            }
        }
        puntos.text = "Puntos: " + String(points)
        if num.isEmpty {
            haGanado()
        }
    }
    
    func haGanado() {
        timer.invalidate()
        noTime.text = "Has ganado!"
        noTime.hidden = false
        retryBut.hidden = false
        puntos.text = "Puntos: " + String(points)
    }
    
    @IBAction func retry(sender: UIButton) {
        retryBut.hidden = true
        b1.hidden = false
        b2.hidden = false
        b3.hidden = false
        b4.hidden = false
        b5.hidden = false
        b6.hidden = false
        start()
    }
    
    
}

