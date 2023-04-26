package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnCalcular: Button = findViewById<Button>(R.id.btnCalcular)
        val edtPeso : EditText = findViewById<EditText>(R.id.edittextpeso)
        val edtAltura : EditText = findViewById<EditText>(R.id.edittextaltura)


        btnCalcular.setOnClickListener {
            val alturaStr = edtAltura.text.toString()
            val pesoStr = edtPeso.text.toString()

            if (alturaStr.isNotEmpty()&& pesoStr.isNotEmpty()){


            val altura : Float = alturaStr.toFloat()
            val peso: Float = pesoStr.toFloat()

            val alturaFinal: Float = altura * altura
            val result: Float = peso / alturaFinal

            val intentResult = Intent (this, ResultActivity::class.java )
                .apply {
                    putExtra ( "EXTRA_RESULT", result)
                }
            startActivity(intentResult)
                }else{
                    Toast.makeText(this, "Preencher todos os campos", Toast.LENGTH_LONG).show()
            }
            }

        }
    }