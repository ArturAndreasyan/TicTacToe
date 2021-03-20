package com.example.tic_tac_toe

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val start = findViewById<Button>(R.id.startButton)
        val editTextPlayer1 = findViewById<EditText>(R.id.editTextPlayer1)
        val editTextPlayer2 = findViewById<EditText>(R.id.editTextTextPlayer2)
        val textPlayer1 = findViewById<TextView>(R.id.textPlayer1)
        val textPlayer2 = findViewById<TextView>(R.id.textPlayer2)
        val textResult = findViewById<TextView>(R.id.textResult)
        textPlayer1.text = editTextPlayer1.text
        textPlayer2.text = editTextPlayer2.text
        start.setOnClickListener {
            val intent = Intent(this,SecondActivity::class.java)


        }
    }

    fun playerTap(view: View) {}
}