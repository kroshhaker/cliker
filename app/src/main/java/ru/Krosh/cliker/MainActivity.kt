package ru.Krosh.cliker

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val torch: Button = findViewById(R.id.buttonTorch)
        val scoreView: TextView = findViewById(R.id.Score)
        val icon: ImageView = findViewById(R.id.moneta)
        var score: Int = 0
        torch.setOnClickListener {
            score = score + 1

            scoreView.text = "Баланс: " + score.toString() + "$"
        }
    }
}