package com.doblevia.saacdoblevia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Quiero : ComponentActivity() {
    private lateinit var ttsHelper: TTSHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.quiero_screen)

        // Inicializar TTS
        ttsHelper = TTSHelper(this)

        // Mapeo de botones con sus textos correspondientes (usando los TextViews como referencia)
        val buttonTextMap: Map<Int, String> = mapOf(
            R.id.imgComer to "Quiero comer",
            R.id.imgBeber to "Quiero beber",
            R.id.imgJugar to "Quiero jugar",
            R.id.imgDormir to "Quiero dormir",
            R.id.imgBano to "Quiero ir al baño",
            R.id.imgAyuda to "Quiero ayuda"
        )

        // Configurar listeners para todos los botones
        buttonTextMap.forEach { (buttonId: Int, text: String) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                ttsHelper.speak(text)
            }
        }

        // Botón de regreso al tablero principal
        findViewById<ImageButton>(R.id.imgSalirBtn)?.setOnClickListener {
            val intent = Intent(this@Quiero, Board::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        ttsHelper.shutdown()
        super.onDestroy()
    }

    // Método para navegar de regreso (alternativo)
    @Deprecated("Deprecated in Java")
    override fun onBackPressed() {
        val intent = Intent(this@Quiero, Board::class.java)
        startActivity(intent)
        finish()
    }
}