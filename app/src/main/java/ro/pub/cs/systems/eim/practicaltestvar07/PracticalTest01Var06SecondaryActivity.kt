package ro.pub.cs.systems.eim.practicaltestvar07

import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class PracticalTest01Var06SecondaryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_practical_test01_var06_secondary)

        // Obținem intenția care a lansat această activitate
        val intent = intent

        // Extragem datele din intenție
        val number1 = intent.getStringExtra("NUMBER1")
        val number2 = intent.getStringExtra("NUMBER2")
        val number3 = intent.getStringExtra("NUMBER3")
        val checkedCount = intent.getIntExtra("CHECKED_COUNT", 0)

        // Afișăm numerele primite
        val numbersTextView = findViewById<TextView>(R.id.numbersTextView)
        numbersTextView.text = "Numere primite: $number1, $number2, $number3"

        // Verificăm dacă numerele sunt la fel (inclusiv asteriscul ca joker)
        val isMatched = number1 == number2 && number2 == number3

        // Calculăm câștigul
        val prize = when (checkedCount) {
            0 -> 100
            1 -> 50
            2 -> 10
            else -> 0
        }

        // Afișăm rezultatul
        val resultTextView = findViewById<TextView>(R.id.resultTextView)

        if (isMatched) {
            resultTextView.text = "Gained: $prize"
        } else {
            resultTextView.text = "No match. Gained: $prize"
        }

        // Afișăm un Toast cu câștigul
        Toast.makeText(this, "Câștig: $prize", Toast.LENGTH_SHORT).show()
    }
}
