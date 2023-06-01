package com.azimzada.spinnerkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Adapter
import android.widget.AdapterView
import android.widget.ArrayAdapter
import android.widget.Toast
import com.azimzada.spinnerkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    lateinit var binding: ActivityMainBinding
    private val ulkeler = ArrayList<String>()
    private lateinit var veriAdapteri: ArrayAdapter<String>
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        ulkeler.add("Azərbaycan")
        ulkeler.add("Turkiye")
        ulkeler.add("İsrail")
        ulkeler.add("İspaniya")
        ulkeler.add("Hollanda  ")


        veriAdapteri =
            ArrayAdapter(this, android.R.layout.simple_list_item_1, android.R.id.text1, ulkeler)
        binding.spinner2.adapter = veriAdapteri

        binding.spinner2.onItemSelectedListener = object : AdapterView.OnItemSelectedListener {
            override fun onItemSelected(
                parent: AdapterView<*>?,
                view: View?,
                position: Int,
                id: Long
            ) {
                Toast.makeText(
                    applicationContext,
                    "Secilen Ulke ${ulkeler[position]}",
                    Toast.LENGTH_SHORT
                ).show()
            }


            //hesne Secilmezse
            override fun onNothingSelected(parent: AdapterView<*>?) {
                TODO("Not yet implemented")
            }

        }



        binding.button2.setOnClickListener() {
            Toast.makeText(
                applicationContext,
                "Ulke ${ulkeler[binding.spinner2.selectedItemPosition]}  ///////////////----------",
                Toast.LENGTH_SHORT
            ).show()

        }


    }
}