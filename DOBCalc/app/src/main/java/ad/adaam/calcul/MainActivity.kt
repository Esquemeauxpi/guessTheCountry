package ad.adaam.calcul

import android.app.DatePickerDialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.DatePicker
import android.widget.TextView
import android.widget.Toast
import org.w3c.dom.Text
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {

    private var tvSelectedDate: TextView? = null
    private var therightthing: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonDatePicker : Button = findViewById(R.id.buttonDatePicker)
        tvSelectedDate = findViewById(R.id.tvSelectedDate)
        therightthing = findViewById(R.id.therightthing)

        buttonDatePicker.setOnClickListener {

            clickDatePicker()

        }
    }

   private fun clickDatePicker() {

        val theCalendar = Calendar.getInstance()
        val year = theCalendar.get(Calendar.YEAR)
        val month = theCalendar.get(Calendar.MONTH)
        val day = theCalendar.get(Calendar.DAY_OF_MONTH)
        val dpd = DatePickerDialog(
            this,
            DatePickerDialog.OnDateSetListener { _ , year, month, dayOfMonth ->

                Toast.makeText(
                    this,
                    "year was actually $year, and the month was ${month + 1}, day is $dayOfMonth",
                    Toast.LENGTH_LONG
                ).show()

                val selectedDate = "$dayOfMonth/${month + 1}/$year"

                tvSelectedDate?.text = selectedDate

                val sdf = SimpleDateFormat("dd/MM/yyyy", Locale.ENGLISH)

                val theDate = sdf.parse(selectedDate)

                theDate?.let {

                    val selectedDateInMinutes = theDate.time / 60000

                    val currentDate = sdf.parse(sdf.format(System.currentTimeMillis()))

                    currentDate?.let {

                        val currentDateInMinutes = currentDate.time / 60000

                        val diffInMinutes = currentDateInMinutes - selectedDateInMinutes

                        therightthing?.text = diffInMinutes.toString()

                    }
                }

            },
            year,
            month,
            day,
        )

        dpd.datePicker.maxDate = System.currentTimeMillis() - 86400000
        dpd.show()


    }
}