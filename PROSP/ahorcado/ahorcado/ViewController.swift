//
//  ViewController.swift
//  ahorcado
//
//  Created by DAM on 17/1/17.
//  Copyright © 2017 Guillem. All rights reserved.
//

import UIKit

class ViewController: UIViewController {

    @IBOutlet weak var label_palabra: UILabel!
    @IBOutlet weak var tf_letra: UITextField!
    @IBOutlet weak var image_fallos: UIImageView!
    let palabras = [ "NETBEANS", "ORACLE", "MULTIPLATAFORMA" ]
    var fallos = 0
    var current = ""
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        
        let pal = Int(arc4random_uniform(UInt32(palabras.count)))
        current = palabras[pal]
        let desgl = [Character](current.characters)
        var cubierta: [Int] = []
        var label = ""
        for _ in desgl {
            label += "_ "
            cubierta.append(0)
        }
        label_palabra.text = label
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    func hola(desgl, letra) {
        var label = ""
        var acierto: Bool = false
        for a in desgl {
            if (letra == desgl[a]) {
                cubierta[a] = 1
                acierto = true
            }
        }
        for b in desgl {
            if (cubierta[b] == 1) {
                label += desgl[b]+" "
            } else {
                label += "_ "
            }
        }
        
        if (!acierto) {
            fallos += 1
        }
        
        label_palabra.text = label
    }
    
    func gestionFallos() {
        var img: String = "fallo"+String(fallos)+".png"
        let image: UIImage = UIImage(named: img)!
        image_fallos.image = UIImageView(image: image)
    }

}

