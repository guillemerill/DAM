//
//  ViewController.swift
//  TablasMultiplicar
//
//  Created by DAM on 13/12/16.
//  Copyright © 2016 Guillem. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    @IBOutlet weak var slider: UISlider!
    @IBOutlet weak var table: UITableView!
    @IBOutlet weak var tabla: UILabel!
    
    var selected = 0

    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // UITableViewDataSource obliga a sobreescribir estos dos métodos
    internal func tableView(tableView: UITableView, numberOfRowsInSection section: Int) -> Int {
        // Cuantas filas tiene nuestra tabla
        return 10
    }
    
    internal func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let micelda = UITableViewCell(style: UITableViewCellStyle.Default, reuseIdentifier: "celda")
        var mult = (indexPath.row+1) * selected
        micelda.textLabel?.text = String(selected) + " x " + String(indexPath.row+1) + " = " + String(mult)
        return micelda
    }

    @IBAction func SliderMove(sender: UISlider) {
        selected = Int(sender.value)
        tabla.text = "Tabla de multiplicar del " + String(selected)
        table.reloadData()
    }

}

