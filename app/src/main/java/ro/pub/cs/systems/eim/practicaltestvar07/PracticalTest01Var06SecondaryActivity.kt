package ro.pub.cs.systems.eim.practicaltestvar07

import android.os.Bundle
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        // Obținem datele din intenție
        val numbers = intent.getStringArrayExtra("numbers") ?: arrayOf("?", "?", "?")
        val checkedBoxes = intent.getIntExtra("checkedBoxes", 0)

        // Verificăm dacă toate numerele sunt la fel (ignorând asteriscul)
        val isMatch = numbers[0] == numbers[1] && numbers[1] == numbers[2] &&
                (numbers[0] != "*" || numbers[1] != "*" || numbers[2] != "*")

        // Calculăm câștigul pe baza numărului de checkbox-uri bifate
        val cash = when (checkedBoxes) {
            0 -> 100
            1 -> 50
            2 -> 10
            else -> 0
        }

        // Afișăm rezultatul
        val resultTextView = findViewById<TextView>(R.id.resultTextView)
        val cashTextView = findViewById<TextView>(R.id.cashTextView)

        if (isMatch) {
            resultTextView.text = "Gained"
        } else {
            resultTextView.text = "Not Gained"
        }

        cashTextView.text = "Cash: $cash"
    }
}
