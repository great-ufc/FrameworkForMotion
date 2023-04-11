//------Generated by the Framework and must be changed-----//
//------Planning Module Main Class-----//

package br.ufc.poc2.model.mapek.planning

import br.ufc.poc2.model.entities.AdaptationRules
import br.ufc.poc2.model.entities.Context
import br.ufc.poc2.model.entities.ResultEntry
import br.ufc.poc2.model.mapek.execution.ExecuteActions
import br.ufc.poc2.model.mapek.observer.IAnalysisObserver
import br.ufc.poc2.model.mapek.observer.IPlanningObservable
import br.ufc.poc2.model.mapek.observer.IPlanningObserver
import br.ufc.poc2.ui.CommonActivities.BaseActivity

class PlanningRolesManagement(val context:BaseActivity): IAnalysisObserver,IPlanningObservable {

    private var adaptationActions = mutableListOf<String>()
    override val observers: MutableList<IPlanningObserver> = mutableListOf()
    var resultEntry:ResultEntry? = null
    var changeContext:Boolean = false

    fun Plan(){
        if(changeContext)
            adaptationActions = ChoiceActions(resultEntry!!.context)
        resultEntry = resultEntry

        for(observer in observers){
            (observer as ExecuteActions).dynamicActions = adaptationActions
            (observer as ExecuteActions).resultEntry = resultEntry
        }

        sendUpdateEvent()
    }

    fun  ChoiceActions(contexts:MutableList<Context>):MutableList<String>{
        val actions:MutableList<String> = mutableListOf<String>()

        //Ler Arquivo com Regras de Adaptação
        val adaptationRules:AdaptationRules = ReadAdaptationXML.readXML(context)


        //Verifica ações com base nos contextos
        for (adaptation:AdaptationRules.Adaptation in  adaptationRules.adaptationList) {
            var count:Int = adaptation.contextList.size // Identifica o número de contextos associados a ação
            for (c:AdaptationRules.context  in adaptation.contextList) {
                for (context:Context in contexts) {
                    if(context.name == c.name) { //verifica contexto

                        when(c.signal) {
                            "greaterthan" -> {if( context.value as Double>= c.value.toDouble()) count-=1}
                            "lessthan" ->  {if((context.value as Double) < c.value.toDouble()) count-=1}
                            "equals" -> {if((context.value as Double) == c.value.toDouble()) count-=1}
                            "containValue"-> {
                                val valuesc = c.value.split(",")
                                for (value: String in valuesc) {
                                    if (value == context.value as String) count--
                                }
                            }
                            "notContainValue" -> {
                                val valuesc = c.value.split(",")
                                var contains = true
                                for(value:String in valuesc){
                                    if( value == context.value as String)  contains = false
                                }
                                if(contains)
                                    count--
                            }
                        }
                    }
                }
                if(count == 0)
                    break
            }
            if(count == 0)
                actions.add(adaptation.action)
        }

        return actions
    }

    override fun update() {
        Plan()
    }

}