package edu.rockvalleycollege.finalapp

import android.content.Context
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity

import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager

import android.widget.Button
import android.widget.EditText
import androidx.constraintlayout.widget.ConstraintLayout
import edu.rockvalleycollege.finalapp.MainActivity2.Main2Activity


class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val txtCurrentWeight = findViewById<EditText>(R.id.txtCurrentWeight)
        val txtGoalWeight = findViewById<EditText>(R.id.txtGoalWeight)
        val txtName = findViewById<EditText>(R.id.txtName)
        val btnSubmit = findViewById<Button>(R.id.btnSubmit)
        val preferences = getSharedPreferences ("data", Context.MODE_PRIVATE)
        val layoutPage1 = findViewById<ConstraintLayout>(R.id.LayoutPage1)

        //Get name and send it to shared preferences.
        txtName.requestFocus()
        txtName.setText (preferences.getString ("name", ""))


        layoutPage1.setOnClickListener()
        {
            hideKeyboard()
        }


        btnSubmit.setOnClickListener(View.OnClickListener {

            btnSubmit.setText("Loading")
            val editor = preferences.edit ()
            editor.putString ("mail", txtName.text.toString ())
            editor.commit ()
            val intent = Intent(this, Main2Activity::class.java)

            intent.putExtra("Intent Data One", txtCurrentWeight.text.toString())
            intent.putExtra("Intent Data Two", txtGoalWeight.text.toString())
            intent.putExtra("Intent Data Three", txtName.text.toString())
            startActivity(intent)



        })


    }
    fun hideKeyboard() {
        try {
            val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            imm.hideSoftInputFromWindow(currentFocus!!.windowToken, 0)
        } catch (e: Exception) {
            // TODO: handle exception
        }

    }
}
