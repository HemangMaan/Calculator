package com.hemangmaan.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    private var op="*"
    private var oldNumber=""
    private var isNewOp=true
    fun buNumberEvent(view: android.view.View) {

        if(isNewOp){
            findViewById<EditText>(R.id.showCalculations).setText("")
        }
        isNewOp=false
        var buClickValue =findViewById<EditText>(R.id.showCalculations).text.toString()
        val buSelected = view as Button
        when(buSelected.id){
            R.id.bu0->buClickValue+="0"
            R.id.bu1->buClickValue+="1"
            R.id.bu2->buClickValue+="2"
            R.id.bu3->buClickValue+="3"
            R.id.bu4->buClickValue+="4"
            R.id.bu5->buClickValue+="5"
            R.id.bu6->buClickValue+="6"
            R.id.bu7->buClickValue+="7"
            R.id.bu8->buClickValue+="8"
            R.id.bu9->buClickValue+="9"
            R.id.buDecimal->buClickValue+="."
            R.id.buAddSub->buClickValue= "-$buClickValue"
        }
        findViewById<EditText>(R.id.showCalculations).setText(buClickValue)
    }

    fun buOperationEvent(view: android.view.View) {
        val buSelected = view as Button
        var buClickValue =findViewById<EditText>(R.id.showCalculations).text.toString()
        when(buSelected.id){
            R.id.buMultiply->op="*"
            R.id.buAdd->op="+"
            R.id.buDiv->op="/"
            R.id.buSub->op="-"
            R.id.buRem->op="%"
        }
        oldNumber=buClickValue
        buClickValue+=op
        findViewById<EditText>(R.id.showCalculations).setText(buClickValue)
        isNewOp=true
    }

    fun buEqual(view: android.view.View) {
        val newNumber= findViewById<EditText>(R.id.showCalculations).text.toString()
        var finalNumber:Double?=null
        when(op){
            "*"->finalNumber=oldNumber.toDouble()*newNumber.toDouble()
            "/"->finalNumber=oldNumber.toDouble()/newNumber.toDouble()
            "+"->finalNumber=oldNumber.toDouble()+newNumber.toDouble()
            "-"->finalNumber=oldNumber.toDouble()-newNumber.toDouble()
            "%"->finalNumber=oldNumber.toDouble()%newNumber.toDouble()
        }
        findViewById<EditText>(R.id.showCalculations).setText(finalNumber.toString())
        isNewOp=true

    }
}