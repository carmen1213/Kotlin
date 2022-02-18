package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley

class MainActivity : AppCompatActivity() {
    lateinit var info : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        info = findViewById<TextView>(R.id.textView)
        val url = "https://www.google.com"

        val paginados = findViewById<Button>(R.id.button2)


        paginados.setOnClickListener {

            val cambiando = Intent(this, Paginados::class.java)

            startActivity(cambiando)

        }
        val paginado = findViewById<Button>(R.id.button)

        paginado.setOnClickListener{
            verweb(url)
        }

    }
        private fun verweb(url2: String) {
            val queue = Volley.newRequestQueue(this)
            val stringRequest =
                StringRequest(Request.Method.GET, url2, Response.Listener { response ->
                    info.text = "Lectura del sitio: ${response}"
                }, Response.ErrorListener {
                    info.text = "No conectado"
                })
            queue.add(stringRequest)
        }

}