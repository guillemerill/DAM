//
//  ViewController.swift
//  PickerView
//
//  Created by Mateo Bistuer on 8/11/16.
//  Copyright © 2016 Mateo Bistuer,Guillem erill. All rights reserved.
//

import UIKit

class ViewController: UIViewController,UIPickerViewDelegate,UIPickerViewDataSource {


    @IBOutlet weak var imagen1: UIImageView!
    @IBOutlet weak var imagen2: UIImageView!
    
    @IBOutlet weak var pickView1: UIPickerView!
    
    @IBOutlet weak var pickView2: UIPickerView!
    @IBOutlet weak var titulo: UILabel!
    var series=["the walking dead","game of the thrones","breaking bad"]
    var personajes=["Rick","jhon nieve","Walter White", "Rob Stark", "Daryl", "jessy pickman"]
    var seriesrow = ""
    var personajesrow = 0
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Do any additional setup after loading the view, typically from a nib.
        
    titulo.text="el "+personajes[0]+" es de la serie "+series[0]
        pickView1.dataSource=self
        pickView2.dataSource=self
        pickView1.delegate=self
        pickView2.delegate=self
        imagen1.image = UIImage(named:"rick.jpg")
        imagen2.image = UIImage(named:"thewalkingdead.jpg")
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    func pickerView(_ pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        if pickerView == pickView1 {
                return personajes[row]
        }
        
                    return  series[row]
        
        
    }
    func pickerView(_ pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        if pickerView == pickView1 {
            personajesrow = row
            
        
            switch row {
            case 0:
                if seriesrow == series[0] {
                    titulo.text="el "+personajes[row]+" es de la serie "+series[0]
                } else {
                    titulo.text = ""
                }
                imagen1.image = UIImage(named:"rick.jpg")
                break
            case 1:
                if seriesrow == series[1] {
                    titulo.text="el "+personajes[row]+" es de la serie "+series[1]
                } else {
                    titulo.text = ""
                }
                imagen1.image = UIImage(named:"jonnieve.jpg")
                break
            case 2:
                if seriesrow == series[2] {
                    titulo.text="el "+personajes[row]+" es de la serie "+series[2]
                } else {
                    titulo.text = ""
                }
                imagen1.image = UIImage(named:"bb2.jpg")
                break
            case 3:
                if seriesrow == series[1] {
                    titulo.text="el "+personajes[row]+" es de la serie "+series[1]
                } else {
                    titulo.text = ""
                }
                imagen1.image = UIImage(named:"rob.jpg")
                break
            case 4:
                if seriesrow == series[0] {
                    titulo.text="el "+personajes[row]+" es de la serie "+series[0]
                } else {
                    titulo.text = ""
                }
                imagen1.image = UIImage(named:"daryl.jpg")
                break
            case 5:
                if seriesrow == series[2] {
                    titulo.text="el "+personajes[row]+" es de la serie "+series[2]
                } else {
                    titulo.text = ""
                }
                imagen1.image = UIImage(named:"jessy.jpg")
                break
            default:
                imagen1.image = nil
            }
        } else if pickerView == pickView2{
            seriesrow = series[row]
         
            
            switch row {
            case 0:
                if personajesrow == 0 || personajesrow == 4 {
                    titulo.text="el "+personajes[personajesrow]+" es de la serie "+series[row]
                } else {
                    titulo.text = ""
                }
                imagen2.image = UIImage(named:"thewalkingdead.jpg")
                break
            case 1:
                if personajesrow == 1 || personajesrow == 3 {
                    titulo.text="el "+personajes[personajesrow]+" es de la serie "+series[row]
                } else {
                    titulo.text = ""
                }
                imagen2.image = UIImage(named:"juegodetronos.jpg")
                break
            case 2:
                if personajesrow == 2 || personajesrow == 5 {
                    titulo.text="el "+personajes[personajesrow]+" es de la serie "+series[row]
                } else {
                    titulo.text = ""
                }
                imagen2.image = UIImage(named:"breakingbad.png")
                break
        
            default:
                imagen2.image = nil
            }
        }
    }
    //funcion que sobreescribimos para indicar la serie y personaje seleccionada
    func pickerView(_ pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        if pickerView == pickView1 {
            return personajes.count
        }
          
        
      return series.count
    }
    //metodos que nos obliga a escribir por ser de tipo uipickerviewdataSource
    func numberOfComponents(in pickerView: UIPickerView) -> Int {
        return 1
    }
   


}

