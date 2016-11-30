//
//  Pregunta.swift
//  Preguntas
//
//  Created by DAM on 22/11/16.
//  Copyright © 2016 Guillem. All rights reserved.
//

import UIKit

class Pregunta: NSObject {
    
    var pregunta: String
    var respuestas: [String]
    var correcta: String
    
    init(pregunta: String, respuestas: [String], correcta: String) {
        self.pregunta = pregunta
        self.respuestas = respuestas
        self.correcta = correcta
    }
    
    override init() {
        pregunta = ""
        respuestas = [String]()
        correcta = ""
    }

}
