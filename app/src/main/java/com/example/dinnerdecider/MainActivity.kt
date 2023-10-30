package com.example.dinnerdecider

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.core.content.ContextCompat
import org.w3c.dom.Text
import java.util.Objects

class MainActivity : AppCompatActivity() {

    val foodItemList: MutableList<String> = mutableListOf("Hamburger", "Pizza", "Mexican", "American", "Chinese");

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val decideBtn = findViewById<Button>(R.id.decideBtn)
        val foodTextView = findViewById<TextView>(R.id.foodNameTxt)
        val addFoodBtn = findViewById<Button>(R.id.addFoodBtn)
        val addFoodText  = findViewById<EditText>(R.id.addFoodText)

        decideBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.appColor))
        addFoodBtn.setBackgroundColor(ContextCompat.getColor(this, R.color.appColor))

        val context: Context = this

        decideBtn.setOnClickListener {
            var randomFood = getARandomFood(foodItemList)
            foodTextView.setText(randomFood)
        }

        addFoodBtn.setOnClickListener {
            val newFoodStr = addFoodText.text;
            val toast = Toast.makeText(context, "New Food added successfully", Toast.LENGTH_SHORT)
            if(newFoodStr.toString().equals("")){
                toast.setText("New food name cannot be empty")
            } else {
                foodItemList.add(newFoodStr.toString())
                addFoodText.setText("")
            }
            toast.show()
        }
    }

    fun getARandomFood(strings: List<String>): String {
        val randomIndex = (foodItemList.indices).random()
        return strings[randomIndex]
    }



}