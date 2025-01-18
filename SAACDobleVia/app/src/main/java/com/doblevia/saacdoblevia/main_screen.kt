package com.doblevia.saacdoblevia

import android.content.Intent
import android.os.Bundle
import android.widget.ImageButton
import androidx.activity.ComponentActivity

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.main_screen)

        val myButton = findViewById<ImageButton>(R.id.comms_btn)
        myButton.setOnClickListener {
            // Launch MainActivity when the button is clicked
            val intent = Intent(this@MainActivity, Board::class.java)
            startActivity(intent)
        }
    }
}


