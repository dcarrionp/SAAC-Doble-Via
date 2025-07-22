package com.doblevia.saacdoblevia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class SobreMi : ComponentActivity() {
    private lateinit var ttsHelper: TTSHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.sobremi_screen)

        // Inicializar TTS
        ttsHelper = TTSHelper(this)

        // Mapeo de botones con sus textos correspondientes
        val textMap: Map<Int, String> = mapOf(
            R.id.imgMiNombre to "Mi nombre es Juan", // Personalizable
            R.id.imgMiEdad to "Tengo 10 años", // Personalizable
            R.id.imgMiFamilia to "Esta es mi familia",
            R.id.imgMiCasa to "Esta es mi casa",
            R.id.imgMiEscuela to "Esta es mi escuela",
            R.id.imgMisGustos to "Estos son mis gustos"
        )

        // Configurar listeners para todos los botones
        textMap.forEach { (buttonId: Int, text: String) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                ttsHelper.speak(text)
            }
        }

        // Botón de regreso al tablero principal (verificar que existe)
        findViewById<ImageButton>(R.id.imgSalirBtn)?.setOnClickListener {
            val intent = Intent(this@SobreMi, Board::class.java)
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
        val intent = Intent(this@SobreMi, Board::class.java)
        startActivity(intent)
        finish()
    }
}