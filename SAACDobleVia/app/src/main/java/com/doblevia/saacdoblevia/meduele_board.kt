package com.doblevia.saacdoblevia

import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Dolor : ComponentActivity() {
    private lateinit var ttsHelper: TTSHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meduele_screen)

        // Inicializar TTS
        ttsHelper = TTSHelper(this)

        // Mapeo de botones con sus textos correspondientes
        val textMap: Map<Int, String> = mapOf(
            R.id.imgcabeza to "Me duele la cabeza",
            R.id.imgBoca to "Me duelen los dientes",
            R.id.imgEstomago to "Me duele el estómago",
            R.id.imgEspalda to "Me duele la espalda",
            R.id.imgGarganta to "Me duele la garganta",
            R.id.imgHuesos to "Me duelen los huesos",
            R.id.imgmusculos to "Me duelen los músculos"
        )

        // Configurar listeners para todos los botones
        textMap.forEach { (buttonId: Int, text: String) ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                ttsHelper.speak(text)
            }
        }

        // Botón de regreso (si necesitas uno, agrégalo al layout)
    }

    override fun onDestroy() {
        ttsHelper.shutdown()
        super.onDestroy()
    }
}
