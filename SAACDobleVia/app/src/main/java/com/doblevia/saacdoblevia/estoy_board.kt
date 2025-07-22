package com.doblevia.saacdoblevia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Estoy : ComponentActivity() {
    private lateinit var ttsHelper: TTSHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.estoy_screen)

        // Inicializar TTS
        ttsHelper = TTSHelper(this)

        // Mapeo de botones con sus textos correspondientes
        val textMap: Map<Int, String> = mapOf(
            R.id.imgFeliz to "Estoy feliz",
            R.id.imgTriste to "Estoy triste",
            R.id.imgEnojado to "Estoy enojado",
            R.id.imgAsustado to "Estoy asustado",
            R.id.imgCansado to "Estoy cansado",
            R.id.imgEnfermo to "Estoy enfermo"
        )

        // Configurar listeners para todos los botones
        textMap.forEach { (buttonId: Int, text: String) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                ttsHelper.speak(text)
            }
        }

        // Botón de regreso al tablero principal (verificar que existe)
        findViewById<ImageButton>(R.id.imgSalirBtn)?.setOnClickListener {
            val intent = Intent(this@Estoy, Board::class.java)
            startActivity(intent)
            finish()
        }
    }

    override fun onDestroy() {
        ttsHelper.shutdown()
        super.onDestroy()
    }

    // Método para navegar de regreso (alternativo)
    override fun onBackPressed() {
        val intent = Intent(this@Estoy, Board::class.java)
        startActivity(intent)
        finish()
    }
}