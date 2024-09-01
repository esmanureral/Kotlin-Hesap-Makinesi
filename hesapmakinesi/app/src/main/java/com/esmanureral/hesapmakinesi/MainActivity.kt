package com.esmanureral.hesapmakinesi

import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.esmanureral.hesapmakinesi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
       // setContentView(R.layout.activity_main)
        binding=ActivityMainBinding.inflate(layoutInflater)
        val view=binding.root
        setContentView(view)
    }

    fun btnSayiTik(view: View) {

        if(yeniOperator){
            binding.sayigoster.setText("")
        }
        yeniOperator=false


        var btnSec= view as Button
        var btnTikDeger:String=binding.sayigoster.text.toString()



        //hangi butonlara bastığımızı tespit ediyoruz.
        when(btnSec.id){
            binding.btn0.id->{
                btnTikDeger+="0"
            }
            binding.btn1.id->{
                btnTikDeger+="1"
            }
            binding.btn2.id->{
                btnTikDeger+="2"
            }
            binding.btn3.id->{
                btnTikDeger+="3"
            }
            binding.btn4.id->{
                btnTikDeger+="4"
            }
            binding.btn5.id->{
                btnTikDeger+="5"
            }
            binding.btn6.id->{
                btnTikDeger+="6"
            }
            binding.btn7.id->{
                btnTikDeger+="7"
            }
            binding.btn8.id->{
                btnTikDeger+="8"
            }
            binding.btn9.id->{
                btnTikDeger+="9"
            }
            binding.btnartEksi.id->{
                btnTikDeger="-"+btnTikDeger
            }
        }

        binding.sayigoster.setText(btnTikDeger)
    }

    var operator="*"
    var eskiSayi="" //hesap makinesinde daha önceden girilmiş değer olabilir diye.
    var yeniOperator=true

    fun btnOpTik(view: View) {
        var btnSec=view as Button
        when(btnSec.id){
            binding.btnbolme.id->{
                operator="/"
            }
            binding.btncarpma.id->{
                operator="x"
            }
            binding.btneksi.id->{
                operator="-"
            }
            binding.btnarti.id->{
                operator="+"
            }

        }
        eskiSayi=binding.sayigoster.text.toString()
        yeniOperator=true
    }
    fun btnEsittirTik(view: View) {
        var yeniSayi=binding.sayigoster.text.toString()
        var sonucSayisi: Double? =null

        when(operator){
            "/"->{
                sonucSayisi=eskiSayi.toDouble()/yeniSayi.toDouble()
            }
            "x"->{
                sonucSayisi=eskiSayi.toDouble()*yeniSayi.toDouble()
            }
            "-"->{
                sonucSayisi=eskiSayi.toDouble()-yeniSayi.toDouble()
            }
            "+"->{
                sonucSayisi=eskiSayi.toDouble()+yeniSayi.toDouble()
            }
        }

        binding.sayigoster.setText(sonucSayisi.toString())
        yeniOperator=true
    }

    fun btnSilTik (view: View)
    {
        //AC butonuna basıldığında sıfırlansın diye yapıyoruz
        binding.sayigoster.setText("0")
        yeniOperator=true
        

    }


}