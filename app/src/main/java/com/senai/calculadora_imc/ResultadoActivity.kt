package com.senai.calculadora_imc

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class ResultadoActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_resultado)

        val alturaTextView = findViewById<TextView>(R.id.altura)
        val pesoTextView = findViewById<TextView>(R.id.peso)
        val imcTextView = findViewById<TextView>(R.id.imc)
        val estadoTextView = findViewById<TextView>(R.id.estado)

        val intent: Intent = getIntent()

        val actionBar = supportActionBar
        actionBar!!.setDefaultDisplayHomeAsUpEnabled(true)

        alturaTextView.text = intent.getStringExtra("altura")
        pesoTextView.text = intent.getStringExtra("peso")
        imcTextView.text = intent.getStringExtra("imc")
        estadoTextView.text = intent.getStringExtra("estado")
    }
}