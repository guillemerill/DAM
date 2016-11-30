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
    
    // Variables
    var turno:Int = 0
    var j1:[Int] = []
    var j2:[Int] = []
    
    // Victorias
    // Horizontal
    var v1 = [1, 2, 3]
    var v2:[Int] = [4, 5, 6]
    var v3:[Int] = [7, 8, 9]
    // Vertical
    var v4:[Int] = [1, 4, 7]
    var v5:[Int] = [2, 5, 8]
    var v6:[Int] = [3, 6, 9]
    // Diagonal
    var v7:[Int] = [1, 5, 9]
    var v8:[Int] = [3, 5, 7]
    
    
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        fin.hidden = true;
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
    }

    @IBAction func clickPosition(sender: UIButton) {
        // Si es par Jugador 1: O
        // Si es impar Jugador 2: X
        if (turno % 2 == 0) {
            sender.setBackgroundImage(UIImage(named: "o_ficha.png"), forState: UIControlState.Normal)
            
            j1.append(sender.tag)
        
            if (Set(v1).isSubsetOf(Set(j1)) || Set(v2).isSubsetOf(Set(j1)) || Set(v3).isSubsetOf(Set(j1)) || Set(v4).isSubsetOf(Set(j1)) || Set(v5).isSubsetOf(Set(j1)) || Set(v6).isSubsetOf(Set(j1)) || Set(v7).isSubsetOf(Set(j1)) || Set(v8).isSubsetOf(Set(j1))) {
                fin.text = "Ha ganado el Jugador 1"
                fin.hidden = false
                
                TL.enabled = false
                TC.enabled = false
                TR.enabled = false
                CL.enabled = false
                CC.enabled = false
                CR.enabled = false
                BL.enabled = false
                BC.enabled = false
                BR.enabled = false
            }
        } else {
            sender.setBackgroundImage(UIImage(named: "x_ficha.png"), forState: UIControlState.Normal)
            j2.append(sender.tag)
            
            if (Set(v1).isSubsetOf(Set(j2)) || Set(v2).isSubsetOf(Set(j2)) || Set(v3).isSubsetOf(Set(j2)) || Set(v4).isSubsetOf(Set(j2)) || Set(v5).isSubsetOf(Set(j2)) || Set(v6).isSubsetOf(Set(j2)) || Set(v7).isSubsetOf(Set(j2)) || Set(v8).isSubsetOf(Set(j2))) {
                fin.text = "Ha ganado el Jugador 2"
                fin.hidden = false
                
                TL.enabled = false
                TC.enabled = false
                TR.enabled = false
                CL.enabled = false
                CC.enabled = false
                CR.enabled = false
                BL.enabled = false
                BC.enabled = false
                BR.enabled = false
            }
        }
        
        if (turno == 8) {
            fin.hidden = false
        }
        
        
        sender.enabled = false
        turno += 1
    }

}

