package com.example.prueba

import android.annotation.SuppressLint
import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.text.TextWatcher
import android.view.View
import androidx.core.widget.addTextChangedListener
import com.example.prueba.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        mostrarEditText(binding)
        ocultarTexto(binding)
        mostrarImagen(binding)
    }

    fun mostrarEditText(binding: ActivityMainBinding){
        var flag=false
        binding.button.setOnClickListener{
            if (flag){
                binding.editTextTextPersonName.visibility=View.INVISIBLE
                binding.button.text = "Comenzar"
                flag=false
            }else{
                binding.editTextTextPersonName.visibility= View.VISIBLE
                binding.button.text = "Finalizar"
                flag=true
            }
        }
    }

    fun ocultarTexto(binding: ActivityMainBinding){
        binding.editTextTextPersonName.setOnFocusChangeListener{_, hasFocus->
            if (hasFocus){
                binding.editTextTextPersonName.text.clear()
            }else if (binding.editTextTextPersonName.text.isEmpty())
                    binding.editTextTextPersonName.setText("Introduce tu nombre")
        }
    }

    fun mostrarImagen(binding: ActivityMainBinding){
        binding.editTextTextPersonName.addTextChangedListener(object : TextWatcher{
            override fun beforeTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {

            }

            override fun onTextChanged(p0: CharSequence?, p1: Int, p2: Int, p3: Int) {
                if (binding.editTextTextPersonName.text.contains("Wayne", true)){
                    binding.imageView3.setImageResource(R.drawable.batman)
                    binding.imageView3.visibility=View.VISIBLE
                } else if (binding.editTextTextPersonName.text.contains("Joker", true)){
                    binding.imageView3.setImageResource(R.drawable.joker)
                    binding.imageView3.visibility=View.VISIBLE
                    binding.editTextTextPersonName.setTextColor(Color.WHITE)
                    binding.root.setBackgroundColor(Color.rgb(83, 35, 100))
                    binding.button.setBackgroundColor(Color.BLACK)
                }else{
                    binding.imageView3.visibility=View.INVISIBLE
                }

            }

            override fun afterTextChanged(p0: Editable?) {

            }

        })
    }
}