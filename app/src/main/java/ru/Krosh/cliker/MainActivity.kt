package ru.Krosh.cliker

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId", "SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val torch: Button = findViewById(R.id.buttonTorch)
        val balView: TextView = findViewById(R.id.Score)
        val shop: Button = findViewById(R.id.shop)
        var bal: Int = 0
        var cost: Int = 500
        var u: Int = 0
        torch.setOnClickListener{
            bal += (1 + u)

            balView.text = "Баланс: $bal$"
        }
        shop.setOnClickListener{
            if(bal >= cost){
                bal -= cost
                u++
                cost *= 2
                shop.text = "Купить улучшение (+${u+1})\nСтоимость: $cost$"
                Toast.makeText(applicationContext, "Вы купили улучшение.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Недостаточно средст.", Toast.LENGTH_SHORT).show()
            }
        }
    }
}