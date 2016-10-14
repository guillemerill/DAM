//
//  ViewController.swift
//  OrdenaNumeros
//
//  Created by DAM on 4/10/16.
//  Copyright © 2016 DAM. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    
    @IBOutlet weak var b1: UIButton!
    @IBOutlet weak var b2: UIButton!
    @IBOutlet weak var b3: UIButton!
    @IBOutlet weak var b4: UIButton!
    @IBOutlet weak var b5: UIButton!
    @IBOutlet weak var b6: UIButton!
    var clicked: [Int] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        createButtons()
        
        
        
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    func createButtons() {
        // Creamos números aleatorios
        var num: [Int] = []
        for _ in 0...5 {
            let n = Int(arc4random_uniform(200)) - 100
            num.append(n)
        }
        
        var buttons: [UIButton] = [b1, b2, b3, b4, b5, b6]
        for m in 0...5 {
            buttons[m].setTitle(String(num[m]), forState: .Normal)
        }
    }
    
    
    @IBAction func clickButton(sender: UIButton) {
        var checked: Bool = false
        
        let activeButton = Int(sender.titleLabel!.text!)
        var butValues: [Int!] = [Int(b1.titleLabel!.text!), Int(b2.titleLabel!.text!), Int(b3.titleLabel!.text!), Int(b4.titleLabel!.text!), Int(b5.titleLabel!.text!), Int(b6.titleLabel!.text!)]
        
        var cont = 0
        for m in butValues {
            for n in clicked {
                if m == n  {
                    butValues.removeAtIndex(cont)
                    cont--
                }
            }
            cont++
        }
        
        var min : Int = 100
        for i in butValues {
            if i < min {
                min = i
            }
        }
        if min == activeButton {
            clicked.append(min)
            sender.hidden = true
        }
        
        
    }
}

