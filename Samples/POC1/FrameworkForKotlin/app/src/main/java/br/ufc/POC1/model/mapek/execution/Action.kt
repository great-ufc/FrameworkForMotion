//------Generated by the Framework and can be changed-----//
//------Action Sample Class-----//
package br.ufc.POC1.model.mapek.execution

import android.content.Intent
import br.ufc.POC1.ui.AlertActivity
import br.ufc.POC1.ui.CommonActivities.BaseActivity
import task.Task2

class Action: Task2() {

    lateinit var context:BaseActivity

    override fun executar() {
        val intent = Intent(context, AlertActivity::class.java)
        context.startActivity(intent)
    }

    override fun retorno(): Any {
        TODO("Not yet implemented")
    }

    override fun recebeToken(p0: Any?) {
        TODO("Not yet implemented")
    }

    override fun retornaToken(): Any {
        TODO("Not yet implemented")
    }

    override fun evaluate(p0: Any?) {
        val result = p0 as Pair<BaseActivity,String>
        if(p0.second == "alarm"){
            context = p0.first
            executar()
        }



        TODO("Not yet implemented")
    }
}