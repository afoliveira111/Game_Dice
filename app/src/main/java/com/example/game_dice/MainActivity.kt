package com.example.game_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao = findViewById<Button>(R.id.botao)
        val textview = findViewById<TextView>(R.id.textview)
        val imagem = findViewById<ImageView>(R.id.imagem)

            botao.setOnClickListener {
                val valor = (1..6).random()
                textview.text = "Valor do dado = $valor"
            }

    }

}