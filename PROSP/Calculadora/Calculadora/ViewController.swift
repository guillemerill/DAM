//
//  ViewController.swift
//  Calculadora
//
//  Created by DAM on 20/10/16.
//  Copyright © 2016 DAM. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var result: UILabel!
    
    var numActual: Int = 0
    var total: Int = 0
    var operacion: String = ""
    var signoBtn: String = ""
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        result.text = ""
    }
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


    @IBAction func pulsarBtn(sender: UIButton) {
        result.text! += sender.currentTitle!
        operacion += sender.currentTitle!
    }
    @IBAction func operacion(sender: UIButton) {
        if sender.currentTitle != "=" {
            operacion = sender.currentTitle!
            numActual = Int(result.text!)!
            result.text = "0"
        } else {
            switch(operacion) {
            case"+": numActual += Int(result.text!)!
                break
            case"-": numActual -= Int(result.text!)!
                break
            case"*": numActual *= Int(result.text!)!
                break
            case"/": numActual /= Int(result.text!)!
                break
            default: print("error")
            }
            operacion = "="
            result.text = String(numActual)
        }
        
        
    }
    
    @IBAction func clear(sender: UIButton) {
        numActual = 0
        total = 0
        operacion = ""
        result.text = ""
    }
}

