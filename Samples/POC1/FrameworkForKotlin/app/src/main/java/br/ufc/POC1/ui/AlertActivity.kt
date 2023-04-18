package br.ufc.POC1.ui

import android.content.Intent
import android.os.Bundle
import android.text.Html
import android.util.Log
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import br.ufc.POC1.R
import br.ufc.POC1.ui.CommonActivities.BaseActivity


class AlertActivity : AppCompatActivity() {

    lateinit var txtRiskSituation:TextView

    companion object{
        var actions: MutableList<String> = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        MainActivity.alarm = true

        val btnStop = findViewById<Button>(R.id.button_stop)
        val btnHelp = findViewById<Button>(R.id.button_help)
        txtRiskSituation = findViewById<TextView>(R.id.textView_riskSituation) as TextView

        //Execute Actions
        if (actions.contains("audio")){AudioAct()}
        if (actions.contains("luz")){LightAct()}
        if (actions.contains("vibracao")){VibrationAct()}
        if (actions.contains("texto")){TextAct()}

        btnStop.setOnClickListener(){
            val it = Intent(this, MainActivity::class.java)
            startActivity(it)
        }

    }

    fun AudioAct(){}
    fun LightAct(){}
    fun VibrationAct(){}
    fun TextAct(){
        Runnable( {
            runOnUiThread{
                txtRiskSituation.setText(Html.fromHtml("<font color=\"red\";><b>"+BaseActivity.finalStatus+"</b></font> Detected"))
            }
        }).run()
    }
}