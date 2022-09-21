package ru.nsu.shiftlab_test

import android.app.Dialog
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main_screen.*

class MainScreen : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main_screen)

        greetings.setOnClickListener {
            val dialog = Dialog(this)
            dialog.setContentView(R.layout.dialog_view)
            val textView: TextView = dialog.findViewById(R.id.textView)

            val name = intent.getStringExtra("name")
            val surname = intent.getStringExtra("surname")

            textView.text = "Greetings, my dear $name $surname!"

            dialog.show()
        }

    }

}