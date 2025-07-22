package com.doblevia.saacdoblevia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Board : ComponentActivity() {
    private lateinit var ttsHelper: TTSHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comms_board)

        // Inicializar TTS
        ttsHelper = TTSHelper(this)

        // Mapeo de actividades
        val activityMap = mapOf(
            R.id.imgQuieroBtn to Intent(this@Board, Quiero::class.java),
            R.id.imgEstoyBtn to Intent(this@Board, Estoy::class.java),
            R.id.imgMeDueleBtn to Intent(this@Board, Dolor::class.java),
            R.id.imgSaludosBtn to Intent(this@Board, Saludos::class.java),
            R.id.imgSobreMiBtn to Intent(this@Board, SobreMi::class.java),
            R.id.imgSalirBtn to Intent(this@Board, MainActivity::class.java)
        )

        // Mapeo de textos para TTS
        val textMap = mapOf(
            R.id.imgSiBtn to "Sí",
            R.id.imgNoBtn to "No"
        )

        // Configurar listeners para botones de navegación
        activityMap.forEach { (buttonId, intent) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                startActivity(intent)
            }
        }

        // Configurar listeners para botones con TTS
        textMap.forEach { (buttonId, text) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                ttsHelper.speak(text)
            }
        }
    }

    override fun onDestroy() {
        ttsHelper.shutdown()
        super.onDestroy()
    }
}
