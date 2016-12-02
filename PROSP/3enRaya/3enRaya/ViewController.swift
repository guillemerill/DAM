//
//  ViewController.swift
//  3enRaya
//
//  Created by DAM on 29/11/16.
//  Copyright © 2016 Guillem. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    // Buttons
    /*
     T: Top
     C: Center
     B: Bottom
     R: Right
     L: Left
     */
    // Fila superior
    @IBOutlet weak var TL: UIButton!
    @IBOutlet weak var TC: UIButton!
    @IBOutlet weak var TR: UIButton!
    
    // Fila central
    @IBOutlet weak var CL: UIButton!
    @IBOutlet weak var CC: UIButton!
    @IBOutlet weak var CR: UIButton!
    
    // Fila inferior
    @IBOutlet weak var BL: UIButton!
    @IBOutlet weak var BC: UIButton!
    @IBOutlet weak var BR: UIButton!
    
    @IBOutlet weak var fin: UILabel!
    
    var arr_button:[UIButton] = [ ]
    
    // Variables
    var turno:Int = 0
    var j1:[Int] = []
    var j2:[Int] = []
    var usadas:[Int] = []
    var victorias:[[Int]] = []
    
    override func viewDidLoad() {
        super.viewDidLoad()
        fin.hidden = true;
        arr_button = [ TL, TC, TR, CL, CC, CR, BL, BC, BR ]
        victorias = [ [1, 2, 3], [4, 5, 6], [7, 8, 9], [1, 4, 7], [2, 5, 8], [3, 6, 9], [1, 5, 9], [3, 5, 7] ]
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    @IBAction func clickPosition(sender: UIButton) {
        // Si es par Jugador 1: O
        // Si es impar Jugador 2: X
        if (!usadas.contains(sender.tag)) {
            if (turno % 2 == 0) {
                sender.setBackgroundImage(UIImage(named: "o_ficha"), forState: UIControlState.Normal)
            
                j1.append(sender.tag)
                
            } else {
                sender.setBackgroundImage(UIImage(named: "x_ficha"), forState: UIControlState.Normal)
                j2.append(sender.tag)
            }
            usadas.append(sender.tag)
            endGame()
            //sender.enabled = false
            turno += 1
        }
    }
    
    @IBAction func startGame(sender: UIButton) {
        for btn in arr_button {
            btn.setBackgroundImage(UIImage(named: ""), forState: UIControlState.Normal)
        }
        fin.hidden = true
        j1.removeAll()
        j2.removeAll()
        usadas.removeAll()
        turno = 0
    }
    
    func endGame() {
        var acabado:Bool = false
        for vic in victorias {
            if (Set(vic).isSubsetOf(Set(j1))) {
                fin.text = "Los círculos han ganado!"
                acabado = true
            }
            if (Set(vic).isSubsetOf(Set(j2))) {
                fin.text = "Las cruces han ganado!"
                acabado = true
            }
        }
        
        if (turno >= 8) {
            acabado = true
            fin.text = "Habéis empatado!"
        }
        
        if (acabado) {
            for btn in arr_button {
                usadas.append(btn.tag)
            }
            
            fin.hidden = false
        }

    }

}

