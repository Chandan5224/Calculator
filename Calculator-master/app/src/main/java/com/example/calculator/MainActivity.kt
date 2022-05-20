package com.example.calculator

import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.calculator.*
import kotlinx.android.synthetic.main.calculator.view.*
import org.w3c.dom.Text

class MainActivity : AppCompatActivity() {

    private var firstClick: Boolean = true
    private var opClick: Boolean = true
    private var doubleClick: Boolean = true
    private var clearTrue: Boolean = true

    private var ope: String = ""
    private var result = Array(2) { 0f }
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.calculator)

        textView1.text = "0"
        textView.text = "0"

        one.setOnClickListener {
            biswajit("1")
        }
        two.setOnClickListener {
            biswajit("2")
        }
        Three.setOnClickListener {
            biswajit("3")
        }
        Four.setOnClickListener {
            biswajit("4")
        }
        Five.setOnClickListener {
            biswajit("5")
        }
        Six.setOnClickListener {
            biswajit("6")
        }
        Seven.setOnClickListener {
            biswajit("7")
        }
        Eight.setOnClickListener {
            biswajit("8")
        }
        Nine.setOnClickListener {
            biswajit("9")
        }
        zero.setOnClickListener {
            biswajit("0")
        }

        addtion.setOnClickListener {
            opClick("+")
        }
        Subtraction.setOnClickListener {
            opClick("-")
        }
        devide.setOnClickListener {
            opClick("/")
        }
        modulo.setOnClickListener {
            opClick("%")
        }

        Multiplication.setOnClickListener {
            opClick("X")
        }
        dott.setOnClickListener {
            biswajit(".")
        }
        clear.setOnClickListener {
            textView1.text = "0"
            textView.text = "0"
            firstClick = true
            opClick = true
            doubleClick = true
            result[0] = 0f
            result[1] = 0f
            clearTrue=true
        }
        Equal.setOnClickListener {
            solve()
        }
    }


    fun biswajit(str: String) {
        if (firstClick) {
            textView1.text = str
            this.firstClick = false
        } else {
            textView1.text = textView1.text.toString() + str
        }

        if (opClick)
            result[0] = result[0] * 10 + str.toFloat()
        else {
            result[1] = result[1] * 10 + str.toFloat()
            clearTrue=false
        }
    }

    fun opClick(str: String) {
        if(clearTrue) {
            if (result[0] == 0f) {
                textView1.text = "0"
            } else if (doubleClick && opClick) {
                textView1.text = textView1.text.toString() + str
                ope = str
                doubleClick = false
                opClick = false
            } else {
                var s: String = textView1.text.toString()
                s = s.substring(0, s.length - 1)
                textView1.text = s + str
                ope = str
            }
        }

    }

    fun solve() {
        var res = 0f
        when (ope) {
            "+" -> res = (result[0] + result[1])
            "-" -> res = (result[0] - result[1])
            "/" -> res = (result[0] / result[1])
            "X" -> res = (result[0] * result[1])
            "%" -> res = (result[0] % result[1])
        }
        if (res % 2 == 0f || res % 2 == 1.0f || res % 2 == -1.0f) {
            textView.text = res.toInt().toString()
        } else
            textView.text = res.toString()
    }

}

