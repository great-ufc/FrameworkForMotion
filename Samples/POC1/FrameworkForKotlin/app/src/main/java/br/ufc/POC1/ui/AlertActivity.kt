package br.ufc.POC1.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import br.ufc.POC1.R



class AlertActivity : AppCompatActivity() {

    lateinit var txtRiskSituation:TextView

    companion object{
        var actions: MutableList<String> = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        val btnStop = findViewById<Button>(R.id.button_stop)
        val btnHelp = findViewById<Button>(R.id.button_help)
        txtRiskSituation = findViewById<TextView>(R.id.textView_riskSituation)


        //Execute Actions
        if (actions.contains("audio")){AudioAct()}
        if (actions.contains("luz")){LightAct()}
        if (actions.contains("vibracao")){VibrationAct()}
        if (actions.contains("texto")){TextAct()}

    }

    fun AudioAct(){}
    fun LightAct(){}
    fun VibrationAct(){}
    fun TextAct(){
        Runnable {
            txtRiskSituation.setText("Risk Situation"+MainActivity.texto+"Detected")
        }
    }
}