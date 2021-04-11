package edu.rockvalleycollege.finalapp.MainActivity2

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.view.View
import android.view.inputmethod.InputMethodManager
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
import edu.rockvalleycollege.finalapp.MainActivity3
import edu.rockvalleycollege.finalapp.R

class Main2Activity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)

        //Not used yet
        val layoutPage2 = findViewById<ConstraintLayout>(R.id.LayoutPage2)
        val txtShow = findViewById<TextView>(R.id.txtShow)
        val txtResults = findViewById<TextView>(R.id.txtResults)
        val btnSubmit2 = findViewById<Button>(R.id.btnSubmit2)
        val txtRec = findViewById<TextView>(R.id.txtRec)
        val btn30 = findViewById<Button>(R.id.btn30)
        val btn60 = findViewById<Button>(R.id.btn60)
        val btn90 = findViewById<Button>(R.id.btn90)


        //loads intent string from MainActivity.kt

        var strShow: String = intent.getStringExtra("Intent Data One").toString()

        var strShow2: String = intent.getStringExtra("Intent Data Two").toString()

        var strShow3: String = intent.getStringExtra("Intent Data Three").toString()
        txtShow.setText("Current Weight: $strShow \n Goal weight: $strShow2")

        var strShowDouble  = strShow.toDouble()
        var strShowDouble2= strShow2.toDouble()

        txtRec.setText("What is your timeframe (in days) to achieve your goal weight?")


        btn30.setOnClickListener {
            if (strShowDouble < strShowDouble2)
            {   var total = (((strShowDouble2-strShowDouble)*3500)/30).toInt()
                txtResults.setText("Based on a 2000 calorie diet, to gain ${strShowDouble2-strShowDouble} lbs in 30 days, you must eat an average of ${total + 2000} calories per day! ")

            }
            if (strShowDouble > strShowDouble2)
            {   var total = (((strShowDouble-strShowDouble2)*3500)/30).toInt()
                txtResults.setText("Based on a 2000 calorie diet, to lose ${strShowDouble-strShowDouble2} lbs in 30 days, you must eat an average of ${2000-total} calories per day! ")
                if (2000-total < 1200)
                {
                    txtResults.setText("Based on a 2000 calorie diet, to lose ${strShowDouble-strShowDouble2} lbs in 30 days, you must eat an average of ${2000-total} calories per day! \n\n" +
                    "NOTE: Eating less than 1200 calories per day is potentially unhealthy. \n\n" +
                            " Please consult with a doctor before dramatic changes to your diet.")
                }

            }



        }
        btn60.setOnClickListener {
            if (strShowDouble < strShowDouble2)
            {   var total = (((strShowDouble2-strShowDouble)*3500)/60).toInt()
                txtResults.setText("Based on a 2000 calorie diet, to gain ${strShowDouble2-strShowDouble} lbs in 60 days, you must eat an average of ${total + 2000} calories per day! ")

            }
            if (strShowDouble > strShowDouble2)
            {   var total = (((strShowDouble-strShowDouble2)*3500)/60).toInt()
                txtResults.setText("Based on a 2000 calorie diet, to lose ${strShowDouble-strShowDouble2} lbs in 60 days, you must eat an average of ${2000-total} calories per day! ")
                if (2000-total < 1200)
                {
                    txtResults.setText("Based on a 2000 calorie diet, to lose ${strShowDouble-strShowDouble2} lbs in 60 days, you must eat an average of ${2000-total} calories per day! \n\n" +
                            "NOTE: Eating less than 1200 calories per day is potentially unhealthy. \n\n" +
                            " Please consult with a doctor before dramatic changes to your diet.")
                }

            }

        }
        btn90.setOnClickListener {
            if (strShowDouble < strShowDouble2)
            {   var total = (((strShowDouble2-strShowDouble)*3500)/90).toInt()
                txtResults.setText("Based on a 2000 calorie diet, to gain ${strShowDouble2-strShowDouble} lbs in 90 days, you must eat an average of ${total + 2000} calories per day! ")

            }
            if (strShowDouble > strShowDouble2)
            {   var total = (((strShowDouble-strShowDouble2)*3500)/90).toInt()
                txtResults.setText("Based on a 2000 calorie diet, to lose ${strShowDouble-strShowDouble2} lbs in 90 days, you must eat an average of ${2000-total} calories per day! ")
                if (2000-total < 1200)
                {
                    txtResults.setText("Based on a 2000 calorie diet, to lose ${strShowDouble-strShowDouble2} lbs in 90 days, you must eat an average of ${2000-total} calories per day! \n\n" +
                            "NOTE: Eating less than 1200 calories per day is potentially unhealthy. \n\n" +
                            " Please consult with a doctor before dramatic changes to your diet.")
                }

            }



        }

        btnSubmit2.setOnClickListener()
        {
            val intent2 = Intent(this, MainActivity3::class.java)

            intent2.putExtra("Intent Data One", strShow)
            intent2.putExtra("Intent Data Two", strShow2)
            intent2.putExtra("Intent Data Three",strShow3)
            startActivity(intent2)
        }















        findViewById<View>(android.R.id.content).setOnTouchListener { _, _ ->
            hideKeyboard()
            false
        }

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