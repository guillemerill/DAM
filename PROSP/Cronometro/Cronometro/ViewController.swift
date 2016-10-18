//
//  ViewController.swift
//  Cronometro
//
//  Created by DAM on 18/10/16.
//  Copyright © 2016 DAM. All rights reserved.
//

import UIKit

class ViewController: UIViewController {
    // UIVariables
    @IBOutlet weak var timeLabel: UILabel!
    
    // Variables
    var timer: NSTimer!
    var inTime: Int = 0
    
    
    override func viewDidLoad() {
        super.viewDidLoad()
        start()
    }

    override func didReceiveMemoryWarning() {
        super.didReceiveMemoryWarning()
        // Dispose of any resources that can be recreated.
    }

    func start() {
        inTime = 0
        timer = NSTimer.scheduledTimerWithTimeInterval (1, target: self, selector: Selector("time") , userInfo: nil, repeats: true)
        
    }
    
    func time() {
        var time: String? = String(inTime)
        if inTime < 10 {
            time = "00:0" + time!
        } else if inTime < 60 {
            time = "00:" + time!
        } else {
            let min: Int = inTime / 60
            let sec: Int = inTime % 60
            let minStr: String = String(inTime / 60)
            let secStr: String = String(inTime % 60)
            
            if min < 10 {
                if sec < 10 {
                    time = "0" + minStr + ":0" + secStr
                } else {
                    time = "0" + minStr + ":" + secStr
                }
            } else {
                time = minStr + ":" + secStr
            }
        }
        
        timeLabel.text = time
        inTime += 1
    }
    
    @IBAction func pause(sender: AnyObject) {
        timer.invalidate()
    }
    @IBAction func startBtn(sender: AnyObject) {
        timer.invalidate()
        timer = NSTimer.scheduledTimerWithTimeInterval (1, target: self, selector: Selector("time") , userInfo: nil, repeats: true)
    }
    @IBAction func stopBtn(sender: AnyObject) {
        timer.invalidate()
        inTime = 0;
    }
    
}

