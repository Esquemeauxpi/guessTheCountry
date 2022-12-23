package ad.adaam.thequizapp

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
    }
}