package com.doblevia.saacdoblevia

import android.content.Intent
import android.os.Bundle
import android.media.MediaPlayer
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class Board : ComponentActivity() {
    private val mediaPlayerMap = HashMap<Int, MediaPlayer>()
    private lateinit var activityMap: Map<Int, Intent>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.comms_board)

        activityMap = mapOf(
            R.id.imgQuieroBtn to Intent(this@Board, Quiero::class.java),
            R.id.imgEstoyBtn to Intent(this@Board, Estoy::class.java),
            R.id.imgMeDueleBtn to Intent(this@Board, Dolor :: class.java),
            R.id.imgSaludosBtn to Intent(this@Board, Saludos :: class.java),
            R.id.imgSobreMiBtn to Intent (this@Board, SobreMi :: class.java),
            R.id.imgSalirBtn to Intent (this@Board, MainActivity :: class.java)
            // Add more button IDs and intents as needed
        )

        val audioMap = mapOf(
            R.id.imgSiBtn to R.raw.si_audio,
            R.id.imgNoBtn to R.raw.no_audio,
            // Add more button IDs and audio files as needed
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


