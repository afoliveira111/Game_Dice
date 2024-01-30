package com.example.game_dice

import android.animation.Animator
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.isVisible
import com.airbnb.lottie.LottieAnimationView

class MainActivity : AppCompatActivity() {

    private var ultimoValor = -1
    private lateinit var animationView: LottieAnimationView
    private lateinit var imagem: ImageView
    private lateinit var textview: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val botao = findViewById<Button>(R.id.botao)
        textview = findViewById(R.id.textview)
        imagem = findViewById(R.id.imagem)
        animationView = findViewById(R.id.animationView)

        botao.setOnClickListener {
            // Torna a imagem invisível antes de iniciar a animação
            imagem.isVisible = false
            // Inicia a animação quando o botão é clicado
            animationView.isVisible = true
            animationView.playAnimation()
        }

        animationView.addAnimatorListener(object : Animator.AnimatorListener {
            override fun onAnimationStart(p0: Animator) {}

            override fun onAnimationEnd(p0: Animator) {
                // A animação terminou, pode ser utilizado para alguma lógica se necessário
                animationView.isVisible = false
                // Exibe a imagem após a animação
                exibirImagemDado()
            }

            override fun onAnimationCancel(p0: Animator) {}

            override fun onAnimationRepeat(p0: Animator) {}
        })
    }

    private fun exibirImagemDado() {
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
        // Torna a imagem visível após o término da animação
        imagem.isVisible = true
        ultimoValor = valor
    }
}