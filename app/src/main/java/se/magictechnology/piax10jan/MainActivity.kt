package se.magictechnology.piax10jan

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    var thecounter = 0

    lateinit var thenumber : TextView
    lateinit var resetButton : Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        thenumber = findViewById(R.id.numberTV)
        resetButton = findViewById(R.id.resetBtn)

        resetButton.setOnClickListener {
            thecounter = 0
            updateStuff()
        }

        val minusButton = findViewById<Button>(R.id.minusBtn)

        minusButton.setOnClickListener {
            thecounter = thecounter - 1
            updateStuff()
        }

        val plusButton = findViewById<Button>(R.id.plusBtn)

        plusButton.setOnClickListener {
            thecounter = thecounter + 1
            updateStuff()
        }

        val addnumberButton = findViewById<Button>(R.id.addnumberBtn)

        addnumberButton.setOnClickListener {
            val addnumberEdittext = findViewById<EditText>(R.id.addnumberET)

            val addnumberText = addnumberEdittext.text.toString()

            Log.d("piaxdebug", "Textfältet är " + addnumberText)

            //val addnumber = addnumberText.toIntOrNull()

            /*
            if(addnumber != null)
            {
                thecounter = thecounter + addnumber
            }
            */

            /*
            // Swift:
            if let addnumber = Int(addnumberText) {
                thecounter = thecounter + addnumber
            }
            */

            addnumberText.toIntOrNull()?.let {
                thecounter = thecounter + it
            }

            addnumberEdittext.setText("")
            updateStuff()
        }

    }

    fun updateStuff()
    {
        if(thecounter < 0)
        {
            thecounter = 0
        }

        if(thecounter == 0)
        {
            resetButton.visibility = View.INVISIBLE
        } else {
            resetButton.visibility = View.VISIBLE
        }

        thenumber.text = thecounter.toString()
    }

}