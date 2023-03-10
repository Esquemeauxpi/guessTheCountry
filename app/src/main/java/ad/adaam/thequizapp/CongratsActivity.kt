package ad.adaam.thequizapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView

class CongratsActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_congrats)

        val tvScore: TextView = findViewById(R.id.tv_score)
        val tvName: TextView = findViewById(R.id.tv_name)
        val buttonFinish: Button = findViewById(R.id.button_finish)

        tvName.text = intent.getStringExtra(Constants.USER_NAME)

        val totalQuestions  = intent.getIntExtra(Constants.TOTAL_QUESTIONS, 0)
        val correctAnswers = intent.getIntExtra(Constants.CORRECT_ANSWERS, 0)

        tvScore.text = "Your Score is $correctAnswers out of $totalQuestions"

        buttonFinish.setOnClickListener{
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}