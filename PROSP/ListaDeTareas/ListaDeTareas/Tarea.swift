//
//  Tarea.swift
//  ListaDeTareas
//
//  Created by DAM on 15/12/16.
//  Copyright © 2016 Guillem. All rights reserved.
//

import UIKit

class Tarea: NSObject {
    // Atributos
    var titulo: String
    var descripcion: String
    var realizada: Bool = false
    var imagen: UIImage = UIImage(named: "9gag.png")!
    
    // Métodos
    init(titulo: String, descripcion: String) {
        self.titulo = titulo
        self.descripcion = descripcion
    }

    
}
