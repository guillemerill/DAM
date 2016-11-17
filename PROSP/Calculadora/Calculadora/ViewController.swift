//
//  ViewController.swift
//  Calculadora
//
//  Created by Sergi Garcia on 20/10/16.
//  Copyright © 2016 Stucom. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    
    // Variable para guardar el nº actual
    var numeroActual: Int = 0;
    var resultado: Int = 0;
    
    // Variable para guardar la operación actual
    var operacion:String = "";

    @IBOutlet weak var etiquetaResultado: UILabel!
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Inicializo el texto de la etiqueta del resultado
        etiquetaResultado.text = "0";
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    @IBAction func numeros(sender: UIButton) {
        if (etiquetaResultado.text == "0") {
            etiquetaResultado.text = sender.currentTitle
        } else {
            etiquetaResultado.text! += sender.currentTitle!
        }
    }
    
    @IBAction func borrar(sender: AnyObject) {
        numeroActual = 0;
        operacion = "=";
        etiquetaResultado.text = "0";
    }
   
    @IBAction func operaciones(sender: UIButton) {
        if (sender.currentTitle != "=") {
//            print(sender.currentTitle)
            operacion = sender.currentTitle!
            numeroActual = Int(etiquetaResultado.text!)!
            etiquetaResultado.text = "0"
//            etiquetaResultado.textColor = UIColor.blueColor()
//            print(numeroActual)
        } else {
            switch(operacion) {
            case "+": numeroActual += Int(etiquetaResultado.text!)!;
                break
            case "-": numeroActual -= Int(etiquetaResultado.text!)!;
                break
            case "*": numeroActual *= Int(etiquetaResultado.text!)!;
                break
            case "/": numeroActual /= Int(etiquetaResultado.text!)!;
                break;
            default: print("error");
            }
             operacion = "="
            etiquetaResultado.text = String(numeroActual)
        }
       
        
        
        
        /* numeroActual = Int(etiquetaResultado.text!)!
        switch(operacion) {
        case "+": resultado += numeroActual;
                break
        case "-": resultado -= numeroActual;
                break
        case "*": resultado *= numeroActual;
                break
        case "/": resultado /= numeroActual;
                break
        case "=": resultado = numeroActual
                break;
        default: print("error");
        }
        
        // Operacion guarda el botón que ha pulsado usuario (+, -, *, /, =)
        operacion = sender.currentTitle!
        numeroActual = 0 */
        
        
        
    }


}

