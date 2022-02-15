package com.senai.calculadora_imc

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val decimal = DecimalFormat("#.##")

        calcular.setOnClickListener() {
            val peso = findViewById<EditText>(R.id.peso).text.toString().toDouble()
            val altura = findViewById<EditText>(R.id.altura).text.toString().toDouble()
            val imc = peso / (altura * altura)
            val resultado = findViewById<TextView>(R.id.resultado)

            if (imc < 18.5) {
                resultado.text = "Seu imc é ${decimal.format(imc)} e você está abaixo do peso"
            } else if (imc > 18.5 && imc < 24.9) {
                resultado.text = "Seu imc é ${decimal.format(imc)} e você está no peso ideal"
            } else if (imc > 25 && imc < 29.9) {
                resultado.text = "Seu imc é ${decimal.format(imc)} e você está acima do peso"
            } else if (imc > 30 && imc < 34.9) {
                resultado.text = "Seu imc é ${decimal.format(imc)} e você está obeso"
            } else if (imc > 35 && imc < 39.9) {
                resultado.text = "Seu imc é ${decimal.format(imc)} e você está obeso grau II"
            } else {
                resultado.text = "Seu imc é ${decimal.format(imc)} e você está com obesidade mórbida"
            }

        }
    }
}