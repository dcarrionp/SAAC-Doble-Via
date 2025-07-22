package com.doblevia.saacdoblevia

import android.content.Context
import android.speech.tts.TextToSpeech
import android.util.Log
import java.util.*

class TTSHelper(context: Context) : TextToSpeech.OnInitListener {
    private var tts: TextToSpeech? = null
    private var isInitialized = false

    init {
        tts = TextToSpeech(context, this)
    }

    override fun onInit(status: Int) {
        if (status == TextToSpeech.SUCCESS) {
            tts?.let { textToSpeech ->
                // Configurar idioma español
                val result = textToSpeech.setLanguage(Locale("es", "ES"))

                if (result == TextToSpeech.LANG_MISSING_DATA ||
                    result == TextToSpeech.LANG_NOT_SUPPORTED) {
                    Log.e("TTS", "Idioma español no soportado, usando idioma por defecto")
                    textToSpeech.setLanguage(Locale.getDefault())
                }

                // Configurar velocidad de habla
                textToSpeech.setSpeechRate(0.8f) // Un poco más lento para mejor comprensión
                textToSpeech.setPitch(1.0f) // Tono normal

                isInitialized = true
                Log.d("TTS", "TextToSpeech inicializado correctamente")
            }
        } else {
            Log.e("TTS", "Error al inicializar TextToSpeech")
        }
    }

    fun speak(text: String) {
        if (isInitialized && tts != null) {
            Log.d("TTS", "Reproduciendo: $text")
            tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "TTS_ID")
        } else {
            Log.w("TTS", "TTS no está inicializado aún, reintentando...")
            // Reintentar después de un momento
            android.os.Handler(android.os.Looper.getMainLooper()).postDelayed({
                if (isInitialized && tts != null) {
                    tts?.speak(text, TextToSpeech.QUEUE_FLUSH, null, "TTS_ID")
                }
            }, 500)
        }
    }

    fun stop() {
        tts?.stop()
    }

    fun shutdown() {
        tts?.shutdown()
    }

    fun isReady(): Boolean {
        return isInitialized && tts != null
    }
}
