//
//  SecondViewController.swift
//  ListaDeTareas
//
//  Created by DAM on 15/12/16.
//  Copyright © 2016 Guillem. All rights reserved.
//

import UIKit

class SecondViewController: UIViewController {

    @IBOutlet weak var titulo: UITextField!
    @IBOutlet weak var descripcion: UITextField!
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    @IBAction func add(sender: UIButton) {
        let tarea = Tarea(titulo: titulo.text!, descripcion: descripcion.text!)
        tareas.append(tarea)
        self.tabBarController?.selectedIndex = 0
    }


}

