package br.ufc.POC1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import br.ufc.POC1.R

class HistoricActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_historic)

        val buttonsave = findViewById<Button>(R.id.button_save)
        buttonsave.setOnClickListener(){
            //FirstFragment.CallAlarmFragment()
        }
    }
}