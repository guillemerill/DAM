//
//  CeldaPersonalizadaTableViewCell.swift
//  ListaDeTareas
//
//  Created by DAM on 20/12/16.
//  Copyright © 2016 Guillem. All rights reserved.
//

import UIKit

class CeldaPersonalizada: UITableViewCell {

    @IBOutlet weak var img_izq: UIImageView!
    @IBOutlet weak var img_der: UIImageView!
    @IBOutlet weak var label_sup: UILabel!
    @IBOutlet weak var label_inf: UILabel!
    
    override func awakeFromNib() {
        super.awakeFromNib()
        // Initialization code
    }

    override func setSelected(selected: Bool, animated: Bool) {
        super.setSelected(selected, animated: animated)

        // Configure the view for the selected state
    }
    
    override init(style: UITableViewCellStyle, reuseIdentifier: String?){
        super.init(style: style, reuseIdentifier: reuseIdentifier)
    }
    
    required init(coder aDecoder: NSCoder) {
        super.init(coder: aDecoder)!
    }

}
