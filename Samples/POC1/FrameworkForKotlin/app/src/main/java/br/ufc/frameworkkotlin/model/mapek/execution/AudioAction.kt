//------Generated by the Framework and can be changed-----//
//------Action Sample Class-----//
package br.ufc.frameworkkotlin.model.mapek.execution

import br.ufc.frameworkkotlin.ui.CommonActivities.BaseActivity
import task.Task2

class AudioAction:Task2() {
    override fun recebeToken(o: Any?) {}

    override fun retornaToken(): Any? {
        return null
    }

    override fun executar() {
        ///Choice what it should executed if a specific action triggered

        /*AlarmActivity.finalStatus = MainActivity.finalStatus
        while (!AlarmActivity.stopAction) {
            try {
                sleep(1000)
            } catch (e: InterruptedException) {
                e.printStackTrace()
            }
        }
        AlarmActivity.finalStatus = ""*/
    }

    override fun retorno(): Any? {
        return null
    }

    override fun evaluate(o: Any) {
        BaseActivity.finalStatus = o as String

        ///Begin verification of special Status
        if (BaseActivity.finalStatus !!.contains("Fall") || BaseActivity.finalStatus !!.contains("ESBARRAR")) Thread(
            this
        ).start()
        ///End verification of special Status

    }

    override fun run() {
        executar()
    }
}