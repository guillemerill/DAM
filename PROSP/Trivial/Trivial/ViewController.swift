/*
 * Guillem Erill
 * DAM2
 * Trivial
 */

import UIKit

class ViewController: UIViewController,UIPickerViewDelegate, UIPickerViewDataSource {
    
    // Array con los temas
    var temas=["JQuery","PHP","Java","MySQL"]
    // Arrays con las preguntas
    var pr_JQuery=["Cómo se hace referencia a un elemento?", "Cómo se recarga la página?"]
    var pr_PHP=["Cómo se crea una variable?", "Cómo se para la ejecución?"]
    var pr_Java=["A qué se refiere el símbolo '->'  detrás de una variable?", "Cómo se mustran cosas por el terminal?"]
    var pr_MySQL=["Cómo se borra una 'row'?", "Cómo empieza un select?"]
    // Arrays con las posibles respuestas
    var res_JQuery=["#('name')", "$('name')", "name", "#name", "document.reload()", "document.refresh()", "location.refresh()", "location.reload()"]
    var res_PHP=["var name", "int name", "name", "$name", "die()", "stop()", "var_dump()", "echo"]
    var res_Java=["A un objeto", "Al atributo de un objeto", "A una función", "A una variable", "out()", "system.out()", "system.show()", "system.out.print()"]
    var res_MySQL=["DELETE", "REMOVE", "SUPRIME", "EMPTY", "SELECT WHERE", "SELECT WHEN", "SELECT FROM", "SELECT IF"]
    // Arrays con las preguntas
    var res_correctas=["$('name')", "$name", "Al atributo de un objeto", "DELETE", "location.reload()", "system.out.print()", "die()", "SELECT FROM"]
    
    
    // IBOutlets
    @IBOutlet weak var lbl_title: UILabel!
    @IBOutlet weak var picker: UIPickerView!
    @IBOutlet weak var lbl_pregunta: UILabel!
    @IBOutlet weak var btn_escoger: UIButton!
    @IBOutlet weak var btn_res1: UIButton!
    @IBOutlet weak var btn_res2: UIButton!
    @IBOutlet weak var btn_res3: UIButton!
    @IBOutlet weak var btn_res4: UIButton!
    @IBOutlet weak var lbl_fin: UILabel!
    @IBOutlet weak var lbl_punt: UILabel!
    @IBOutlet weak var lbl_puntfinal: UILabel!
    @IBOutlet weak var puntactual: UILabel!
    
    // Variables
    var tema_esc_row = 0
    var puntuacion = 0
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        // Definimos el pickerView como self
        picker.dataSource = self
        picker.delegate = self
        lbl_pregunta.text=""
        btn_res1.hidden = true
        btn_res2.hidden = true
        btn_res3.hidden = true
        btn_res4.hidden = true
        lbl_fin.hidden = true
        lbl_punt.hidden = true
        lbl_puntfinal.hidden = true
        puntactual.text = "Puntuación: "+String(puntuacion)
    }
    
    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }
    
    // Métodos
    @IBAction func esc_tema(sender: UIButton) {
        var complete=false
        switch tema_esc_row {
        case 0:
            if !pr_JQuery.isEmpty {
                let jq = Int(arc4random_uniform(UInt32(pr_JQuery.count)))
                lbl_pregunta.text = pr_JQuery[0]
                btn_res1.setTitle(res_JQuery[0], forState: .Normal)
                btn_res2.setTitle(res_JQuery[1], forState: .Normal)
                btn_res3.setTitle(res_JQuery[2], forState: .Normal)
                btn_res4.setTitle(res_JQuery[3], forState: .Normal)
                pr_JQuery.removeAtIndex(0)
                res_JQuery.removeAtIndex(3)
                res_JQuery.removeAtIndex(2)
                res_JQuery.removeAtIndex(1)
                res_JQuery.removeAtIndex(0)
            } else {
                complete = true
            }
            break
        case 1:
            if !pr_PHP.isEmpty {
                let p = Int(arc4random_uniform(UInt32(pr_PHP.count)))
                lbl_pregunta.text = pr_PHP[0]
                btn_res1.setTitle(res_PHP[0], forState: .Normal)
                btn_res2.setTitle(res_PHP[1], forState: .Normal)
                btn_res3.setTitle(res_PHP[2], forState: .Normal)
                btn_res4.setTitle(res_PHP[3], forState: .Normal)
                pr_PHP.removeAtIndex(0)
                res_PHP.removeAtIndex(3)
                res_PHP.removeAtIndex(2)
                res_PHP.removeAtIndex(1)
                res_PHP.removeAtIndex(0)
            } else {
                complete = true
            }
            break
        case 2:
            if !pr_Java.isEmpty {
                let j = Int(arc4random_uniform(UInt32(pr_Java.count)))
                lbl_pregunta.text = pr_Java[0]
                btn_res1.setTitle(res_Java[0], forState: .Normal)
                btn_res2.setTitle(res_Java[1], forState: .Normal)
                btn_res3.setTitle(res_Java[2], forState: .Normal)
                btn_res4.setTitle(res_Java[3], forState: .Normal)
                pr_Java.removeAtIndex(0)
                res_Java.removeAtIndex(3)
                res_Java.removeAtIndex(2)
                res_Java.removeAtIndex(1)
                res_Java.removeAtIndex(0)
            } else {
                complete = true
            }
            break
        case 3:
            if !pr_MySQL.isEmpty {
                let m = Int(arc4random_uniform(UInt32(pr_MySQL.count)))
                lbl_pregunta.text = pr_MySQL[0]
                btn_res1.setTitle(res_MySQL[0], forState: .Normal)
                btn_res2.setTitle(res_MySQL[1], forState: .Normal)
                btn_res3.setTitle(res_MySQL[2], forState: .Normal)
                btn_res4.setTitle(res_MySQL[3], forState: .Normal)
                pr_MySQL.removeAtIndex(0)
                res_MySQL.removeAtIndex(3)
                res_MySQL.removeAtIndex(2)
                res_MySQL.removeAtIndex(1)
                res_MySQL.removeAtIndex(0)
            } else {
                complete = true
            }
            break
        default:
            print("Error")
        }
        if complete {
            lbl_pregunta.text = String("No tienes más preguntas de este tema por responder . Escoge otro  tema")
        } else {
            btn_res1.backgroundColor = UIColor.whiteColor()
            btn_res2.backgroundColor = UIColor.whiteColor()
            btn_res3.backgroundColor = UIColor.whiteColor()
            btn_res4.backgroundColor = UIColor.whiteColor()
            btn_res1.enabled=true
            btn_res2.enabled=true
            btn_res3.enabled=true
            btn_res4.enabled=true
            
            btn_escoger.enabled=false
            
            btn_res1.hidden=false
            btn_res2.hidden=false
            btn_res3.hidden=false
            btn_res4.hidden=false
        }
    }
    
    @IBAction func respuesta(sender: UIButton) {
        var bien = false
        for correc in res_correctas {
            if sender.currentTitle == correc {
                bien = true
            }
        }
        
        if bien {
            sender.backgroundColor = UIColor.greenColor()
            btn_res1.enabled=false
            btn_res2.enabled=false
            btn_res3.enabled=false
            btn_res4.enabled=false
            btn_escoger.enabled=true
            puntuacion += 1
            puntactual.text = "Puntuación: "+String(puntuacion)
        } else {
            sender.backgroundColor = UIColor.redColor()
            btn_res1.enabled=false
            btn_res2.enabled=false
            btn_res3.enabled=false
            btn_res4.enabled=false
            btn_escoger.enabled=true
        }
        
        if (pr_MySQL.isEmpty && pr_JQuery.isEmpty && pr_Java.isEmpty && pr_PHP.isEmpty) {
            lbl_title.hidden=true
            picker.hidden=true
            lbl_pregunta.hidden=true
            btn_escoger.hidden=true
            btn_res1.hidden=true
            btn_res2.hidden=true
            btn_res3.hidden=true
            btn_res4.hidden=true
            puntactual.hidden=true
            
            lbl_fin.hidden = false
            lbl_punt.hidden = false
            lbl_puntfinal.hidden = false
            lbl_puntfinal.text = String(puntuacion)
        }
        
    }
    
    
    
    // Métodos para generar, introducir datos y gestionar el pickerView
    func pickerView(pickerView: UIPickerView, titleForRow row: Int, forComponent component: Int) -> String? {
        return temas[row]
    }
    
    func pickerView(pickerView: UIPickerView, didSelectRow row: Int, inComponent component: Int) {
        tema_esc_row = row
    }
    
    func pickerView(pickerView: UIPickerView, numberOfRowsInComponent component: Int) -> Int {
        return temas.count
    }
    
    func numberOfComponentsInPickerView(pickerView: UIPickerView) -> Int {
        return 1
    }
    
    
    
    
}

