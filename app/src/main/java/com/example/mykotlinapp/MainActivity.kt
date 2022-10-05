package com.example.mykotlinapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import kotlin.random.Random

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        // get references of widgets
        val newgame = findViewById(R.id.newgame) as Button
        val valider = findViewById(R.id.check) as Button
        val inputtext = findViewById(R.id.inputtext) as EditText
        val result = findViewById(R.id.result) as TextView
        val gamehistory = findViewById(R.id.gamehistory) as TextView
        val inputerror = findViewById(R.id.inputerror) as TextView

        var randomValue=0;

        // set on-click listener
        newgame.setOnClickListener {
            //Choosing a random number between 0 and 1000
            randomValue = Random.nextInt(0, 1000)
            println("randomValue "+randomValue)

            //Notifying the user of a new party's start
            Toast.makeText(applicationContext,"Une Nouvelle Partie Est Lancée",Toast.LENGTH_SHORT).show()

            //Resetting values and enabling the validation button
            valider.setEnabled(true)
            result.text="";
            inputtext.text.clear();
            gamehistory.text="";
            inputerror.text="";
        }

        valider.setOnClickListener{

            //setting the error message to empty
            inputerror.text="";

            if(inputtext.text.isNotEmpty()){
                if(inputtext.text.toString().toInt()>randomValue){
                    result.text = inputtext.text.toString()+" Est Supérieur Au Nombre"
                    println(inputtext.text.toString()+" is more than "+randomValue)

                }else if(inputtext.text.toString().toInt()<randomValue){
                    result.text = inputtext.text.toString()+" Est Inférieur Au Nombre"
                    println(inputtext.text.toString()+" is less than "+randomValue)

                }else{
                    result.text = "Bingo! Vous Avez Gagné!"
                    valider.setEnabled(false)
                }
                if(gamehistory.text.isEmpty()) gamehistory.text = "${inputtext.text.toString()} | "
                else gamehistory.text = "${gamehistory.text}${inputtext.text.toString()} | "
            }else{
                inputerror.text="Veuillez Donner Un Nombre"
            }
        }
    }
}