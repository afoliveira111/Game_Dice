package com.example.game_dice

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView

class RepeatedNumberActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_repeated_number)
        val number = findViewById<TextView>(R.id.repeated_number)
        val argumnet = intent.getIntExtra("number", -1)
        number.text = getString(R.string.o_valor_repetido_foi_d, argumnet)

    }
}