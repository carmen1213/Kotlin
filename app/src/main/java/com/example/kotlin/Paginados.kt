package com.example.kotlin

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageButton
import android.widget.TextView
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import org.json.JSONArray
import org.json.JSONObject

class Paginados : AppCompatActivity() {
    lateinit var info : TextView
    lateinit var info2 : TextView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_paginados)
        val url = "http://192.168.25.85/kotlin/mostrarproductos.php"
        info = findViewById<TextView>(R.id.textView2)
        info2 = findViewById<TextView>(R.id.textView4)

        val paginados = findViewById<ImageButton>(R.id.imageButton)

        paginados.setOnClickListener {

            val cambiando = Intent(this, MainActivity ::class.java)

            startActivity(cambiando)

        }
        val mostrar = findViewById<Button>(R.id.button3)


        mostrar.setOnClickListener {

            verproductos(url)

        }
    }
    private fun verproductos(url2:String){
        val queue = Volley.newRequestQueue(this)
        val stringRequest = StringRequest(Request.Method.GET,url2, Response.Listener { response ->
            val jsonArray = JSONArray(response)
            val jsonObject = JSONObject(jsonArray.getString(0))
            var auxnombre = jsonObject.get("nombre")
            info.text=jsonObject.toString()
            info2.text=auxnombre.toString()
        },Response.ErrorListener { error ->
            info.text="No conectado"
        })
        queue.add(stringRequest)
    }
}