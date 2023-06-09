//------Generated by the Framework and must not be changed-----/
//------From Observer Pattern Interface-----//

package br.ufc.POC1.model.mapek.observer

interface IExecutionObservable {
    val observers: MutableList<IExecutionObserver>

    fun add(observer: IExecutionObserver){
        observers.add(observer)
    }

    fun sendUpdateEvent(){
        observers.forEach{ it.update() }
    }
}