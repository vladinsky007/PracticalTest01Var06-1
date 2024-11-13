package ro.pub.cs.systems.eim.practicaltestvar07

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.CheckBox
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import kotlin.random.Random

class PracticalTest01Var06 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_practical_test01_var06_main)

        // Setarea padding-ului pentru vizibilitatea barelor de sistem
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // Referințele la widget-uri
        val number1EditText = findViewById<EditText>(R.id.number1)
        val number2EditText = findViewById<EditText>(R.id.number2)
        val number3EditText = findViewById<EditText>(R.id.number3)
        val checkbox1 = findViewById<CheckBox>(R.id.checkbox1)
        val checkbox2 = findViewById<CheckBox>(R.id.checkbox2)
        val checkbox3 = findViewById<CheckBox>(R.id.checkbox3)
        val playButton = findViewById<Button>(R.id.playButton)

        // Setăm ascultător pentru butonul "Play"
        playButton.setOnClickListener {
            // Generăm numere aleatoare
            val randomNumbers = arrayOf(generateRandomNumber(), generateRandomNumber(), generateRandomNumber())

            // Verificăm starea checkbox-urilor și actualizăm câmpurile de text
            if (!checkbox1.isChecked) {
                number1EditText.setText(randomNumbers[0])
            }
            if (!checkbox2.isChecked) {
                number2EditText.setText(randomNumbers[1])
            }
            if (!checkbox3.isChecked) {
                number3EditText.setText(randomNumbers[2])
            }

            // Afișăm un Toast cu numerele generate
            Toast.makeText(this, "Numere generate: ${randomNumbers.joinToString(", ")}", Toast.LENGTH_SHORT).show()
        }
    }

    // Functie care generează un număr aleatoriu din setul {1, 2, 3, *}
    private fun generateRandomNumber(): String {
        val values = listOf("1", "2", "3", "*")
        return values[Random.nextInt(values.size)]
    }
}
