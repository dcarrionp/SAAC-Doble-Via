package com.doblevia.saacdoblevia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Saludos : ComponentActivity() {
    private lateinit var ttsHelper: TTSHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.saludos_screen)

        // Inicializar TTS
        ttsHelper = TTSHelper(this)

        // Mapeo de botones con sus textos correspondientes
        val textMap: Map<Int, String> = mapOf(
            R.id.imgHola to "Hola",
            R.id.imgAdios to "Adiós",
            R.id.imgBuenosDias to "Buenos días",
            R.id.imgBuenasNoches to "Buenas noches",
            R.id.imgGracias to "Gracias",
            R.id.imgPerdon to "Perdón"
        )

        // Configurar listeners para todos los botones
        textMap.forEach { (buttonId: Int, text: String) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                ttsHelper.speak(text)
            }
        }

        // Botón de regreso al tablero principal
        findViewById<ImageButton>(R.id.imgSalirBtn)?.setOnClickListener {
            val intent = Intent(this@Saludos, Board::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        ttsHelper.shutdown()
        super.onDestroy()
    }
}