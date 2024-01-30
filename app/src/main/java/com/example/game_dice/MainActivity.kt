package com.example.game_dice

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    private var ultimoValor = -1

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao = findViewById<Button>(R.id.botao)
        val textview = findViewById<TextView>(R.id.textview)
        val imagem = findViewById<ImageView>(R.id.imagem)

        botao.setOnClickListener {
            val valor = (1..6).random()
            textview.text = getString(R.string.valor_do_dado, valor)
            when (valor) {
                1 -> imagem.setImageResource(R.drawable.dice1)
                2 -> imagem.setImageResource(R.drawable.dice2)
                3 -> imagem.setImageResource(R.drawable.dice3)
                4 -> imagem.setImageResource(R.drawable.dice4)
                5 -> imagem.setImageResource(R.drawable.dice5)
                6 -> imagem.setImageResource(R.drawable.dice6)
            }
            if (valor == ultimoValor) {
                val intent = Intent(this, RepeatedNumberActivity::class.java)
                intent.putExtra("number", valor)
                startActivity(intent)
            }

            ultimoValor = valor
        }
    }
}