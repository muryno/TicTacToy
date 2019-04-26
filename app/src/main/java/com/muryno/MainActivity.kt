package com.muryno

import android.graphics.Color
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.TypedValue
import android.view.View
import android.widget.Button
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        reset.setOnClickListener {
            reset()
        }
    }
 var winReset:Int=0
   protected fun buClick(view: View){

       if(winReset==0){
           val btn=view as Button

           val btnSelected= btn.id
           var cellId=0
           when( btnSelected){
               R.id.bu1->cellId=1
               R.id.bu2->cellId=2
               R.id.bu3->cellId=3
               R.id.bu4->cellId=4
               R.id.bu5->cellId=5
               R.id.bu6->cellId=6
               R.id.bu7->cellId=7
               R.id.bu8->cellId=8
               R.id.bu9->cellId=9
           }

           selectedBtn(cellId,btn)
       }else{
           Toast.makeText(this,"There is a winner already !! Reset",Toast.LENGTH_SHORT).show()
       }


    }

    var activePlayer=1
    var player1=ArrayList<Int>()
    var player2=ArrayList<Int>()
    var winner:Int=0
    fun reset(){

            winReset=0
            player1.clear()
            player2.clear()
            bu1.isEnabled=true
            bu1.setBackgroundColor(Color.WHITE)
            bu1.text=""
            bu2.isEnabled=true
            bu2.setBackgroundColor(Color.WHITE)
            bu2.text=""
            bu3.isEnabled=true
            bu3.setBackgroundColor(Color.WHITE)
            bu3.text=""
            bu4.isEnabled=true
            bu4.setBackgroundColor(Color.WHITE)
            bu4.text=""
            bu5.isEnabled=true
            bu5.setBackgroundColor(Color.WHITE)
            bu5.text=""
            bu6.isEnabled=true
            bu6.setBackgroundColor(Color.WHITE)
            bu6.text=""
            bu7.isEnabled=true
            bu7.setBackgroundColor(Color.WHITE)
            bu7.text=""
            bu8.isEnabled=true
            bu8.setBackgroundColor(Color.WHITE)
            bu8.text=""
            bu9.isEnabled=true
            bu9.setBackgroundColor(Color.WHITE)
            bu9.text=""



    }

    fun selectedBtn(cellId:Int,btnSelected:Button){

        if(activePlayer==1){
            btnSelected.text="X"
            btnSelected.setBackgroundColor(Color.GREEN)
            btnSelected.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0F)
            player1.add(cellId)
            activePlayer=2
        }else{
            btnSelected.text="O"
            btnSelected.setBackgroundColor(Color.BLUE)
            btnSelected.setTextSize(TypedValue.COMPLEX_UNIT_SP, 25.0F)
            player2.add(cellId)
            activePlayer=1
        }
        btnSelected.isEnabled=false

        checkWiner()
    }
    fun checkWiner(){
        if(player1.contains(1) && player1.contains(2) && player1.contains(3) ){
            winner=1
        }else   if(player2.contains(1) && player2.contains(2) && player2.contains(3) ){
            winner=2
        }

        if(player1.contains(4) && player1.contains(5) && player1.contains(6) ){
            winner=1
        }else   if(player2.contains(4) && player2.contains(5) && player2.contains(6) ){
            winner=2
        }

        if(player1.contains(7) && player1.contains(8) && player1.contains(9) ){
            winner=1
        }else   if(player1.contains(7) && player1.contains(8) && player1.contains(9) ){
            winner=2
        }

        //column 1
        if(player1.contains(1) && player1.contains(4) && player1.contains(7) ){
            winner=1
        }else   if(player2.contains(1) && player2.contains(4) && player2.contains(7) ){
            winner=2
        }
        //column 2
        if(player1.contains(2) && player1.contains(5) && player1.contains(8) ){
            winner=1
        }else   if(player2.contains(2) && player2.contains(5) && player2.contains(8) ){
            winner=2
        }
        //column 3
        if(player1.contains(3) && player1.contains(6) && player1.contains(9) ){
            winner=1
        }else   if(player2.contains(3) && player2.contains(6) && player2.contains(9) ){
            winner=2
        }

        //cross
        if(player1.contains(1) && player1.contains(5) && player1.contains(9) ){
            winner=1
        }else   if(player2.contains(1) && player2.contains(5) && player2.contains(9) ){
            winner=2
        }
        //cross
        if(player1.contains(7) && player1.contains(5) && player1.contains(3) ){
            winner=1
        }else   if(player2.contains(7) && player2.contains(5) && player2.contains(3) ){
            winner=2
        }


        when(winner){
            1-> { Toast.makeText(this,"Player 1 is a winner",Toast.LENGTH_SHORT).show()
                winner=1
                }
            2-> {
                Toast.makeText(this, "Player 2 is a winner", Toast.LENGTH_SHORT).show()
                winReset=1
            }

        }
    }
}
