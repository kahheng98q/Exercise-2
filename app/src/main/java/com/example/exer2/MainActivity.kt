package com.example.exer2

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val weight=findViewById<EditText>(R.id.editTextWeight)
        val height=findViewById<EditText>(R.id.editTextHeight)
        val cal=findViewById<Button>(R.id.buttonCalculate)
        val reset=findViewById<Button>(R.id.buttonReset)
        val bmi=findViewById<TextView>(R.id.textViewBMI)
        val image=findViewById<ImageView>(R.id.imageViewProfile)

        cal.setOnClickListener {
            try {
                var stringW = weight.text.toString()
                var stringH = height.text.toString()

                bmi.setText(String.format("%.2f", (stringW.toDouble() / (stringH.toDouble() * stringH.toDouble() / 10000))))
                if(bmi.text.toString().toDouble()<18.5){
                    image.setBackgroundResource(R.drawable.under)
                }else if(bmi.text.toString().toDouble()>=18.5&&bmi.text.toString().toDouble()<25){
                    image.setBackgroundResource(R.drawable.normal)
                }else{
                    image.setBackgroundResource(R.drawable.over)
                }
            }catch (ex:Exception){

            }
        }
        reset.setOnClickListener {
            bmi.setText("BMI:")
            weight.setText("")
            height.setText("")
            image.setBackgroundResource(R.drawable.empty)
        }
    }
}
