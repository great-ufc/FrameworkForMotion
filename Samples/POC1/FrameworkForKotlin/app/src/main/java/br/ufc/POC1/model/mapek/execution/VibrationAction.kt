//------Generated by the Framework and can be changed-----//
//------Action Sample Class-----//
package br.ufc.POC1.model.mapek.execution

import android.util.Log
import br.ufc.POC1.ui.AlertActivity
import br.ufc.POC1.ui.CommonActivities.BaseActivity
import br.ufc.POC1.ui.MainActivity
import task.Task2

class VibrationAction: Task2() {

    lateinit var context:BaseActivity

    override fun recebeToken(o: Any?) {}

    override fun retornaToken(): Any? {
        return null
    }

    override fun executar() {
        //MainActivity.flagMonitoring = true
        //MainActivity.texto = "Danger"
        Log.i("Vibration status",BaseActivity.finalStatus !! )
        AlertActivity.actions.add("vibracao")
    }

    override fun retorno(): Any? {
        return null
    }

    override fun evaluate(o: Any) {
        val result = o as Pair<String,BaseActivity>
        BaseActivity.finalStatus  = o.first

        ///Begin verification of special Status
        if (BaseActivity.finalStatus !!.contains("Clapping Standing") || BaseActivity.finalStatus !!.contains("Fall") ||
        BaseActivity.finalStatus !!.contains("Hitting a wall"))
            executar()
        ///End verification of special Status

    }

    override fun run() {
        executar()
    }
}