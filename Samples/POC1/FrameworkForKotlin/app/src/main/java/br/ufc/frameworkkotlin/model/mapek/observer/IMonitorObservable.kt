//------Generated by the Framework and must not be changed-----/
//------From Observer Pattern Interface-----//

package br.ufc.frameworkkotlin.model.mapek.observer

interface IMonitorObservable {
    val observers: MutableList<IMonitorObserver>

    fun add(observer: IMonitorObserver){
        observers.add(observer)
    }

    fun sendUpdateEvent(){
        observers.forEach{ it.update() }
    }
}