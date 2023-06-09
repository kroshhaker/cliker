@file:Suppress("NAME_SHADOWING")

package ru.Krosh.cliker

import android.annotation.SuppressLint
import android.content.SharedPreferences
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val torch: Button = findViewById(R.id.buttonTorch)
        val balView: TextView = findViewById(R.id.Score)
        val shop: Button = findViewById(R.id.shop)
        var bal: Int
        var cost = 500
        var u = 0
        val myPrefs: SharedPreferences = application.applicationContext.getSharedPreferences("data", MODE_PRIVATE)
        bal = myPrefs.getInt("bal", 0)
        u = myPrefs.getInt("u", 0)
        cost = myPrefs.getInt("cost", 500)
        shop.text = "Купить улучшение (+${u+1})\nСтоимость: $cost$"
        balView.text = "Баланс: $bal$"
        torch.setOnClickListener{
            bal += (1 + u)

            balView.text = "Баланс: $bal$"
            val myPrefs: SharedPreferences = application.applicationContext.getSharedPreferences("data", MODE_PRIVATE)
            val prefsEditor = myPrefs.edit()
            prefsEditor.putInt("bal", bal)
            prefsEditor.apply()

        }
        shop.setOnClickListener{
            if(bal >= cost){
                bal -= cost
                u++
                cost *= 2
                shop.text = "Купить улучшение (+${u+1})\nСтоимость: $cost$"
                val myPrefs: SharedPreferences = application.applicationContext.getSharedPreferences("data", MODE_PRIVATE)
                val prefsEditor = myPrefs.edit()
                prefsEditor.putInt("u", u)
                prefsEditor.putInt("cost", cost)
                prefsEditor.apply()
                Toast.makeText(applicationContext, "Вы купили улучшение.", Toast.LENGTH_SHORT).show()
            }else{
                Toast.makeText(applicationContext, "Недостаточно средст.", Toast.LENGTH_SHORT).show()
            }
        }

    }
}