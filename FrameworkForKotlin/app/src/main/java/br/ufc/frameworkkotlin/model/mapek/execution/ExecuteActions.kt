//------Generated by the Framework and must be changed-----//
//------Execution Module Main Class-----//
package br.ufc.frameworkkotlin.model.mapek.execution

import android.util.Log
import br.ufc.frameworkkotlin.model.entities.ResultEntry
import br.ufc.frameworkkotlin.model.mapek.observer.IExecutionObservable
import br.ufc.frameworkkotlin.model.mapek.observer.IExecutionObserver
import br.ufc.frameworkkotlin.model.mapek.observer.IPlanningObserver
import br.ufc.frameworkkotlin.ui.CommonActivities.BaseActivity
import task.Task2

class ExecuteActions(val context:BaseActivity) :IExecutionObservable,IPlanningObserver {

    override val observers: MutableList<IExecutionObserver> = mutableListOf()
    var dynamicActions = mutableListOf<String>()
    var resultEntry:ResultEntry? = null

    fun activitiesExecute(){
        val currentActions: MutableList<Task2>
        var lastActions = ""

        if(dynamicActions == null)   {
            currentActions = getActions(context.actions, context.actions)
            //Log
            for (action in context.actions) {
                lastActions = "$lastActions, $action."
            }
            Log.i("Result", resultEntry!!.finalStatus + " - actions: "+ lastActions)
        }
        else {
            currentActions = getActions(dynamicActions, context.actions)

            //Log
            for (action in dynamicActions) {
                lastActions = "$lastActions, $action"
            }
            Log.i("Result", resultEntry!!.finalStatus + " - actions: "+ lastActions)
        }
        ///Execute actions
        for(action in  currentActions) {
            action.evaluate(resultEntry!!.finalStatus)
        }

        //final wait time for a new MAPE-K loop to restart
        Thread.sleep(5000)
        sendUpdateEvent()

    }

    private fun  getActions(actions:MutableList<String>, currentActions:MutableList<String>):MutableList<Task2>{
        currentActions.clear() //Renew list of current actions
        val currentTaskActions = mutableListOf<Task2>()

        //Instance of actions what can be executed

        if(actions.contains("Text")){
            val textAdaptation = TextAction()
            currentTaskActions.add(textAdaptation)
            currentActions.add("Text")
        }

        if(actions.contains("Vibration")){
            val vibrationAdaptation = VibrationAction()
            currentTaskActions.add(vibrationAdaptation)
            currentActions.add("Vibration")
        }
        if(actions.contains("Audio")){
            val audioAdaptation = AudioAction()
            currentTaskActions.add(audioAdaptation)
            currentActions.add("Audio")
        }
        if(actions.contains("Light")){
            val lightAdaptation =  LightAction()
            currentTaskActions.add(lightAdaptation)
            currentActions.add("Light")
        }

        //End Instance of actions what can be executed

        return currentTaskActions
    }

    override fun update() {
        activitiesExecute()
    }
}