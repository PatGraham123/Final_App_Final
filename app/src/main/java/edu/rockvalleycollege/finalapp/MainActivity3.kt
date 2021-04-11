package edu.rockvalleycollege.finalapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import edu.rockvalleycollege.finalapp.R

class MainActivity3 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main3)

        val txtName = findViewById<TextView>(R.id.txtName)
        val txtUserRecords = findViewById<TextView>(R.id.txtUserRecords)


        var strShow: String = intent.getStringExtra("Intent Data One").toString()

        var strShow2: String = intent.getStringExtra("Intent Data Two").toString()

        var strShow3: String = intent.getStringExtra("Intent Data Three").toString()

        txtUserRecords.text = " Name: $strShow3 \n Current weight: $strShow \n Goal weight : $strShow2"


    }
}