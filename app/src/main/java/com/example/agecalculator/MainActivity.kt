package com.example.agecalculator

import android.annotation.SuppressLint
import android.app.DatePickerDialog
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import androidx.annotation.RequiresApi
import com.google.android.material.button.MaterialButton
import java.text.DateFormat
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val button = findViewById<Button>(R.id.btnDatePicker)
        button.setOnClickListener { view ->
            clickDatePicker(view)
        }
    }


    fun clickDatePicker(view: View) {
        var calemdar = Calendar.getInstance()
        val year = calemdar.get(Calendar.YEAR)
        val month = calemdar.get(Calendar.MONTH)
        val day = calemdar.get(Calendar.DAY_OF_MONTH)


        DatePickerDialog(
            this, DatePickerDialog.OnDateSetListener { view, SelectedYear, SelectedMonth, SelectedDayOfMonth ->

               val selectedDate="$SelectedYear/${SelectedMonth+1}/$SelectedDayOfMonth"
                var textView = findViewById<TextView>(R.id.tvSelectedDate)
                textView.text=selectedDate

                val sdf=SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)
                val theDate=sdf.parse(selectedDate)

                val selectedDateInMinutes=theDate!!.time/60000
                 val currentDate=sdf.parse(sdf.format(System.currentTimeMillis()))

                val currentDateInMinutes=currentDate!!.time/60000
                val differenceInMinutes=currentDateInMinutes-selectedDateInMinutes


                val tvSelectedDateInMinutes=findViewById<TextView>(R.id.tvSelectedDateInMinutes)
                tvSelectedDateInMinutes.text = differenceInMinutes.toString()








            },
            year, month, day


        ).show()
    }
}


