package com.doblevia.saacdoblevia

import android.content.Intent
import android.media.MediaPlayer
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Dolor : ComponentActivity() {
    private val mediaPlayerMap = HashMap<Int, MediaPlayer>()
    private lateinit var activityMap: Map<Int, Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.meduele_screen)

        // Initialize activityMap with Intents for other activities
        activityMap = mapOf(

        )

        val audioMap = mapOf(
            R.id.imgcabeza to R.raw.meduelecabeza,
            R.id.imgEstomago to R.raw.medueleestomago,
            R.id.imgGarganta to R.raw.meduelegarganta,
            R.id.imgEspalda to R.raw.medueleespalda,
            R.id.imgBoca to R.raw.medueledientes,
            R.id.imgmusculos to R.raw.meduelemusculos,
            R.id.imgHuesos to R.raw.meduelehuesos
        )

        audioMap.forEach { (buttonId, audioResId) ->
            val mediaPlayer = MediaPlayer.create(this, audioResId)
            mediaPlayerMap[buttonId] = mediaPlayer
        }

        // Set onClickListeners for buttons
        val allButtonIds = (activityMap.keys + audioMap.keys).toSet()
        allButtonIds.forEach { buttonId ->
            findViewById<ImageButton>(buttonId).setOnClickListener {
                handleButtonClick(buttonId)
            }
        }
    }

    private fun handleButtonClick(buttonId: Int) {
        mediaPlayerMap[buttonId]?.apply {
            if (isPlaying) {
                stop()
                prepare()
            }
            start()
        }
        activityMap[buttonId]?.let {
            startActivity(it)
        }
    }

    override fun onDestroy() {
        // Release all MediaPlayers when the activity is destroyed
        mediaPlayerMap.values.forEach { it.release() }
        super.onDestroy()
    }
}
