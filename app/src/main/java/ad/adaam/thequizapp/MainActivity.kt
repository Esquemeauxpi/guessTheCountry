package ad.adaam.thequizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.system.Os.close
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val buttonStart : Button = findViewById(R.id.button_start)
        val etName : EditText =  findViewById(R.id.et_name)

        buttonStart.setOnClickListener {
            if(etName.text.isEmpty()){
                Toast.makeText(this, "Please enter your name jive turkey",
                    Toast.LENGTH_LONG).show()
            }
            else {
                val intent = Intent(this,
                    QuizQuestionsActivity::class.java)
                intent.putExtra(Constants.USER_NAME, etName.text.toString())
                startActivity(intent)
                finish()
            }
        }


    }
}