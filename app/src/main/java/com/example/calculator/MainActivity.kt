package com.example.calculator

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    private var isNewOperator = true
    private var oldNumber = ""
    private var op =""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }


    fun numberEvent(view: View) {
        if(isNewOperator){
            editText.setText("")
            isNewOperator = false
        }
        var clickBtn = editText.text.toString()
        var selectBtn = view as Button
        when(selectBtn.id){
            one_btn.id -> {clickBtn += "1"}
            two_btn.id -> {clickBtn += "2"}
            three_btn.id -> {clickBtn += "3"}
            four_btn.id -> {clickBtn += "4"}
            five_btn.id -> {clickBtn += "5"}
            six_btn.id -> {clickBtn += "6"}
            seven_btn.id -> {clickBtn += "7"}
            eight_btn.id -> {clickBtn += "8"}
            nine_btn.id -> {clickBtn += "9"}
            zero_btn.id -> {clickBtn += "0"}
            dot_btn.id ->{clickBtn+="."}
            
        }
        editText.setText(clickBtn)
    }

    fun clearEvent(view: View) {
        editText.setText("0")
        isNewOperator = true
    }

    fun operatorEvent(view: View) {
        isNewOperator = true
        oldNumber = editText.text.toString()
        var clickBtn = editOp.text.toString()
        var btnSelect = view as Button
        when(btnSelect.id){
            mult_btn.id ->{op = "*"; clickBtn ="*"}
            divide_btn.id ->{op = "/";clickBtn ="/"}
            plus_btn.id ->{op = "+";clickBtn ="+"}
            minus_btn.id ->{op = "-";clickBtn ="-"}
            pow_btn.id ->{op ="^";clickBtn ="^"}
            percent_btn.id ->{op = "%";clickBtn ="%"}
        }
        editOp.setText(clickBtn)

    }

    fun equalEvent(view: View) {
        var newNumber = editText.text.toString()
        var result = 0.0
        if(op == ""){
            Toast.makeText(this,"Use operator", Toast.LENGTH_SHORT).show()
            editText.setText("0")
            isNewOperator = true
        }else when(op){
            "+"->{result = oldNumber.toDouble()+newNumber.toDouble()}
            "-"->{result = oldNumber.toDouble()-newNumber.toDouble()}
            "*"->{result = oldNumber.toDouble()*newNumber.toDouble()}
            "/"->{result = oldNumber.toDouble()/newNumber.toDouble()}
            "^"->{result = Math.pow(oldNumber.toDouble(),newNumber.toDouble()) }
            "%" ->{result = (oldNumber.toDouble() /newNumber.toDouble()) * 100}

        }
        editOp.setText(" ")
        editText.setText(result.toString())
    }

    fun plusMinus(view: View) {
        var number = editText.text.toString()
        var result = -1*number.toInt()
        editText.setText(result.toString())
    }
}