//
//  ViewController.swift
//  Parejas
//
//  Created by DAM on 3/11/16.
//  Copyright © 2016 silverB. All rights reserved.
//

import UIKit
// Creado por Bilal Hubani y Pol Rodríguez
// Totalmente adaptable a cualquier dispositivo
class ViewController: UIViewController, UIPickerViewDelegate, UIPickerViewDataSource {
    // creamos los arrays con los nombres para los pickerviews
    var personajes = ["Pikachu" , "Lee Sin", "Zoro", "Vayne", "Gengar", "Franky"]
    var serie = ["League of Legends" , "Pokemon", "One Piece"]
    var imagenes1 = [#imageLiteral(resourceName: "pikachu.png"), #imageLiteral(resourceName: "leesin.png"), #imageLiteral(resourceName: "zoro.png"), #imageLiteral(resourceName: "vayne.png"), #imageLiteral(resourceName: "megagengar.png"), #imageLiteral(resourceName: "franky.png")]
    var imagenes2 = [#imageLiteral(resourceName: "lol.png"), #imageLiteral(resourceName: "pokemon.png"), #imageLiteral(resourceName: "onepiece.png")]
    var personaje:String = "Pikachu"
    var juego:String = "League of Legends"
// creamos todos los IBOulets necesarios
    @IBOutlet weak var picker2: UIPickerView!
    @IBOutlet weak var picker1: UIPickerView!
    @IBOutlet weak var frase: UILabel!
    @IBOutlet weak var imagen1: UIImageView!
    @IBOutlet weak var imagen2: UIImageView!
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
        // Le decimos que somos los delagate y datasource del picker view
        picker1.dataSource = self
        picker1.delegate = self
        picker2.dataSource = self
        picker2.delegate = self
        // Iniciamos las imagenes para que muestre la primera de cada columna
        imagen1.image = #imageLiteral(resourceName: "pikachu.png")
        imagen2.image = #imageLiteral(resourceName: "lol.png")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    // Carga el contenido de los picker
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        // Si es el primer picker que devuelva el personaje seleccionado y si es el segundo que devuelva la serie
        if pickerView.tag == 1 {
            return personajes[row]
            
        }else{
            return serie[row]
        }
    }
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView.tag == 1{
            // Cambiamos la frase a mostrar y guardamos en personaje el que esta seleccionado
            frase.text = personajes[row]
            personaje = personajes[row]
            imagen1.image = imagenes1[row]
        }else{
            // Cambiamos la frase a mostrar y guardamos en juego el que esta seleccionado
            frase.text = serie[row]
            juego = serie[row]
            imagen2.image = imagenes2[row]
        }
        // Comparamos y cambiamos la frase si es necesario
        if (personaje=="Pikachu" && juego=="Pokemon"){
            frase.text = "Pikachu es un pokemon"
        }
        if (personaje=="Lee Sin" && juego=="League of Legends"){
            frase.text = "Lee Sin es del Lol"
        }
        if (personaje=="Zoro" && juego=="One Piece"){
            frase.text = "Zoro pertenece a One Piece"
        }
        if (personaje=="Vayne" && juego=="League of Legends"){
            frase.text = "Vayne es del Lol"
        }
        if (personaje=="Gengar" && juego=="Pokemon"){
            frase.text = "Gengar es un pokemon"
        }
        if (personaje=="Franky" && juego=="One Piece"){
            frase.text = "Franky pertenece a One Piece"
        }
    }
    // Numero de columnas del picker
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
    // Numero de filas del picker
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView.tag == 1 {
            return personajes.count
            
        }else{
            return serie.count
        }
    }


}

