//
//  ViewController.swift
//  PrimerasTablas
//
//  Created by DAM on 13/12/16.
//  Copyright © 2016 Guillem. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UITableViewDelegate, UITableViewDataSource {
    
    var lenguajes = ["Java", "PHP", "JavaScript", "C++", "Swift"]

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
        return lenguajes.count
    }

    internal func tableView(tableView: UITableView, cellForRowAtIndexPath indexPath: NSIndexPath) -> UITableViewCell {
        let micelda = UITableViewCell(style: UITableViewCellStyle.Default, reuseIdentifier: "celda")
        micelda.textLabel?.text = lenguajes[indexPath.row]
        return micelda
    }
    
}