//
//  ViewController.swift
//  Ciudades
//
//  Created by DAM on 27/10/16.
//  Copyright © 2016 DAM. All rights reserved.
//

import UIKit

class ViewController: UIViewController, UIPickerViewDataSource, UIPickerViewDelegate {

    //IBoutlet para poder escribir la ciudad seleccionada
    @IBOutlet weak var ciudadSeleccionada: UILabel!
    // IBoutlet para hacer referencia al PickerView
    @IBOutlet weak var miPicker: UIPickerView!
    
    // Array de ciudades para cargar en el PickerView
    var ciudades = ["Almería", "Barcelona", "Gerona", "Ibiza", "Toledo", "Zaragoza"]
    override func viewDidLoad() {
        super.viewDidLoad()
        // Inicializamos el texto del label de la ciudad seleccionada
        ciudadSeleccionada.text = ciudades[0]
        // Le decimos que la misma clase es el "delegate" y "datasource" del PickerView
        // añadimos al class UIPickerViewDataSource, UIPickerViewDelegate
        miPicker.dataSource = self
        miPicker.delegate = self
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Selecciona fila del PickerView
    func pickerView(pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        ciudadSeleccionada.text = ciudades[row]
    }
    
    // Rellenar el PickerView
    func pickerView(pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return ciudades[row]
    }
    
    // Métodos que nos obliga a escribir para el UIPickerViewDataSource
    func numberOfComponentsInPickerView(pickerView: UIPickerView) -> Int {
        return 1
    }

    func pickerView(pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return ciudades.count
    }

}

