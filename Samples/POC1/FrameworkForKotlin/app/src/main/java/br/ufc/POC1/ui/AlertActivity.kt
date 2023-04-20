package br.ufc.POC1.ui

import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.hardware.camera2.CameraManager
import android.os.Bundle
import android.os.VibrationEffect
import android.os.Vibrator
import android.text.Html
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import br.ufc.POC1.R
import br.ufc.POC1.ui.CommonActivities.BaseActivity
import kotlin.concurrent.thread


class AlertActivity : AppCompatActivity() {

    private lateinit var txtRiskSituation:TextView
    private lateinit var cameraM: CameraManager
    private lateinit var vibratorM: Vibrator

    companion object{
        var actions: MutableList<String> = mutableListOf<String>()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alert)

        val btnStop = findViewById<Button>(R.id.button_stop)
        val btnHelp = findViewById<Button>(R.id.button_help)
        txtRiskSituation = findViewById<TextView>(R.id.textView_riskSituation) as TextView



        //Execute Actions
        if (actions.contains("luz")){
            if(hasCamera())
                Thread{LightAct()}.start()
        }
        if (actions.contains("vibracao")){Thread{VibrationAct()}.start()}
        if (actions.contains("texto")){TextAct()}

        btnStop.setOnClickListener(){
            actions.clear()
            val it = Intent()
            it.putExtra("ActivityResult", 0)
            setResult(RESULT_OK, it)
            finish()
            //startActivity(it)
        }

        btnHelp.setOnClickListener(){
            Toast.makeText(this, "Send Message Function not Implemented already",Toast.LENGTH_LONG).show()
        }

        //stop monitoring text animation
        MainActivity.flagMonitoring = true

    }

    fun AudioAct(){}

    fun LightAct(){
        cameraM = getSystemService(Context.CAMERA_SERVICE) as CameraManager
        val cameraListId = cameraM.cameraIdList[0]
        var isFlash = true

        while (MainActivity.alarm){
            cameraM.setTorchMode(cameraListId,isFlash)
            isFlash = false
            cameraM.setTorchMode(cameraListId,isFlash)
            isFlash = true
        }
    }

    fun VibrationAct(){
        vibratorM = getSystemService(Context.VIBRATOR_SERVICE) as Vibrator
        while (MainActivity.alarm){
            vibratorM.vibrate(VibrationEffect.createOneShot(1000, VibrationEffect.DEFAULT_AMPLITUDE))
        }
    }

    fun TextAct(){
        Runnable( {
            runOnUiThread{
                txtRiskSituation.setText(Html.fromHtml("<font color=\"red\";><b>"+BaseActivity.finalStatus+"</b></font> Detected"))
            }
        }).run()
    }

    //verify if device has camera for activate flash light
    fun hasCamera():Boolean{
            if (this.packageManager.hasSystemFeature(PackageManager.FEATURE_CAMERA)) {
                // this device has a camera
                return true
            } else {
                // no camera on this device
                return false
            }
    }
}