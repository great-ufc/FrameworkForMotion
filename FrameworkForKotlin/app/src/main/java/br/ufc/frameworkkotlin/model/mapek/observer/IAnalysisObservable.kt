//------Generated by the Framework and must not be changed-----/
//------From Observer Pattern Interface-----//

package br.ufc.frameworkkotlin.model.mapek.observer

interface IAnalysisObservable {
    val observers: MutableList<IAnalysisObserver>

    fun add(observer: IAnalysisObserver){
        observers.add(observer)
    }

    fun sendUpdateEvent(){
        observers.forEach{ it.update() }
    }
}