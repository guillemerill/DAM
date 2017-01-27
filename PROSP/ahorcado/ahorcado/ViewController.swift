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
        var label = ""
        for _ in desgl {
            label += "_ "
        }
        label_palabra.text = label
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }


}

