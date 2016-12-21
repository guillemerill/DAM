
import UIKit
var tareas: [Tarea] = []
class FirstViewController: UIViewController, UITableViewDataSource, UITableViewDelegate {

    @IBOutlet weak var tabla: UITableView!
    
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
        let celdas = CeldaPersonalizada(style: UITableViewCellStyle.Default, reuseIdentifier: "celda")
        var mult = (indexPath.row+1) * selected
        celdas.textLabel?.text = String(selected) + " x " + String(indexPath.row+1) + " = " + String(mult)
        celdas.img_izq
        return celdas
    }


}

