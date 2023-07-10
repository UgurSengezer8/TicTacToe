package com.example.viewbinding

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.service.controls.Control
import android.view.View
import android.widget.Button
import android.widget.Toast
import com.example.viewbinding.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    var scoreX=0
    var scoreO=0
    var sira = true
    var tablo = arrayOf(0,0,0,0,0,0,0,0,0)
    var gameOver = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

    }
    fun Click(id: Int){
        //Boşmu diye kontrol et
        val butons = arrayOf(
            binding.button2
            ,binding.button3
            ,binding.button4
            ,binding.button5
            ,binding.button6
            ,binding.button7
            ,binding.button8
            ,binding.button9,binding.button10)
        if (!gameOver)
        {
            if (tablo[id]==0){
                //Tıkladığı Kutu Boş
                //doldur
                if (sira){
                    //Sıra X in
                    sira=!sira;
                    butons[id].text="X"
                    tablo[id]=1
                }else{
                    sira=!sira;
                    butons[id].text="O"
                    tablo[id]=2
                }
                for (i in 0..8){
                    println("${i}. hücre verisi ${tablo[i]}")
                }
                Control()
                //El bitimi kontrol
            }
        }

        //boşsa
        println(id)
    }
    fun Control (){
        println("çağrıldı")
        if ((tablo[0]==1&&tablo[3]==1&&tablo[6]==1)||(tablo[1]==1&&tablo[4]==1&&tablo[7]==1)||(tablo[2]==1&&tablo[5]==1&&tablo[8]==1)||(tablo[0]==1&&tablo[1]==1&&tablo[2]==1)||(tablo[3]==1&&tablo[4]==1&&tablo[5]==1)||(tablo[6]==1&&tablo[7]==1&&tablo[8]==1)||(tablo[0]==1&&tablo[4]==1&&tablo[8]==1)||(tablo[2]==1&&tablo[4]==1&&tablo[6]==1)){
            //x olasılıklar
            gameOver=true
            scoreX++;
            Toast.makeText(this, "X Win", Toast.LENGTH_SHORT).show()
        }
        if ((tablo[0]==2&&tablo[3]==2&&tablo[6]==2)||(tablo[1]==2&&tablo[4]==2&&tablo[7]==2)||(tablo[2]==2&&tablo[5]==2&&tablo[8]==2)||(tablo[0]==2&&tablo[1]==2&&tablo[2]==2)||(tablo[3]==2&&tablo[4]==2&&tablo[5]==2)||(tablo[6]==2&&tablo[7]==2&&tablo[8]==2)||(tablo[0]==2&&tablo[4]==2&&tablo[8]==2)||(tablo[2]==2&&tablo[4]==2&&tablo[6]==2)){
            //x olasılıklar
            gameOver=true
            scoreO++;
            Toast.makeText(this, "O Win", Toast.LENGTH_SHORT).show()
        }
        binding.textView2.text= "X = ${scoreX}"
        binding.textView3.text= "O = ${scoreO}"

        println(gameOver)
    }
    fun reset(view: View){
        val butons = arrayOf(
            binding.button2
            ,binding.button3
            ,binding.button4
            ,binding.button5
            ,binding.button6
            ,binding.button7
            ,binding.button8
            ,binding.button9
            ,binding.button10)
        butons.forEach { buton-> buton.text=""}
        for (i in 0..8){
            tablo[i]=0;
        }
        gameOver=false

    }
    fun btnClick(view:View){ Click(0)}
    fun btnClick1(view:View){ Click(1) }
    fun btnClick2(view:View){ Click(2)}
    fun btnClick3(view:View){ Click(3)}
    fun btnClick4(view:View){ Click(4)}
    fun btnClick5(view:View){ Click(5)}
    fun btnClick6(view:View){ Click(6)}
    fun btnClick7(view:View){ Click(7)}
    fun btnClick8(view:View){ Click(8)}

}