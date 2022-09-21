package ru.nsu.shiftlab_test

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button.setOnClickListener {
            if( editPersonName.text.toString().length > 1 &&
                editPersonSurname.text.toString().length > 1 &&
                editTextDate.text.toString().split(".").size == 3 &&
                editPassword.text.toString().length >= 6 &&
                editTextConfirmPassword.text.toString() == editPassword.text.toString()
            ) {
                val intent = Intent(this, MainScreen::class.java)
                intent.putExtra("name", editPersonName.text.toString())
                intent.putExtra("surname", editPersonSurname.text.toString())
                startActivity(intent)
            }
            else {
                Toast.makeText(this, "Invalid inputs. Please try field all the fields correctly.", Toast.LENGTH_LONG).show()
            }
        }

        editPersonName.setOnFocusChangeListener { _, t ->
            if (!t && editPersonName.text.toString().length < 2)
                Toast.makeText(this, "You should fill the Name field!", Toast.LENGTH_LONG).show()
        }

        editPersonSurname.setOnFocusChangeListener { _, t ->
            if (!t && editPersonSurname.text.toString().length < 2)
                Toast.makeText(this, "You should fill the Surname field!", Toast.LENGTH_LONG).show()
        }

        editTextDate.setOnFocusChangeListener {_, t ->
            if(!t && editTextDate.text.toString().split(".").size != 3)
                Toast.makeText(this, "You should fill the Birth date field in DD.MM.YYYY format!", Toast.LENGTH_LONG).show()
        }

        editPassword.setOnFocusChangeListener { _, t ->
            if (!t && editPassword.text.toString().length < 6)
                Toast.makeText(this, "You should fill the Password field with at least 6 symbols!", Toast.LENGTH_LONG).show()
        }

        editTextConfirmPassword.setOnFocusChangeListener { _, t ->
            if (!t && editPassword.text.toString() != editTextConfirmPassword.text.toString())
                Toast.makeText(this, "Passwords don't match!", Toast.LENGTH_LONG).show()
        }

    }


}