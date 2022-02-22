package com.senai.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import java.text.DecimalFormat

private lateinit var pesoEditText: EditText
private lateinit var alturaEditText: EditText

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val calcular = findViewById<Button>(R.id.calcular)
        val decimal = DecimalFormat("##.##")

        calcular.setOnClickListener() {
            pesoEditText = findViewById<EditText>(R.id.peso)
            alturaEditText = findViewById<EditText>(R.id.altura)
//          val resultadoTextView = findViewById<TextView>(R.id.resultado)

            if (validarCampos()) {
                val peso = pesoEditText.text.toString().toDouble()
                val altura = alturaEditText.text.toString().toDouble()

                val imc = calcularImc(peso, altura)

                val intent = Intent(this, ResultadoActivity::class.java)
                intent.putExtra("altura", altura.toString())
                intent.putExtra("peso", peso.toString())
                intent.putExtra("imc", decimal.format(imc).toString())
                intent.putExtra("estado", estadoFisico(imc))

                startActivity(intent)

//                resultadoTextView.text = "Seu imc é ${decimal.format(imc)}. " + estadoFisico(imc)
            }
        }
    }

    private fun validarCampos(): Boolean {
        var erro = true
        if (pesoEditText.text.isBlank()) {
            pesoEditText.setError("Digite seu peso!")
            erro = false
        }
        if (alturaEditText.text.isBlank()) {
            alturaEditText.setError("Digite sua altura!")
            erro = false
        }
        return erro
    }


}