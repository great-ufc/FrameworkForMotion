//------Generated by the Framework and must be changed-----//
//------Monitoring Module Main Class-----//

package br.ufc.poc2.model.mapek.monitoring

import br.ufc.poc2.model.mapek.monitoring.GoogleFit.Samples.GoogleFitGetAllData
import br.ufc.poc2.model.entities.sensors.ValuesSensor
import br.ufc.poc2.model.entities.sensors.typeSensor
import br.ufc.poc2.model.mapek.observer.*
import br.ufc.poc2.model.utils.Animations
import br.ufc.poc2.model.utils.Constants
import br.ufc.poc2.ui.CommonActivities.BaseActivity

class DataManagement(val context: BaseActivity):IMonitorObservable,IExecutionObserver {
    private var dataCollectTime:Long = 0
    private var googleFitAllData:GoogleFitGetAllData?=null

    override val observers: MutableList<IMonitorObserver> = mutableListOf()

    fun Monitoring(){

        //Remove
        Thread{
            Animations.monitoring()
        }.start()

        //Coletar os dados dos sensores
        if (this.dataCollectTime == (0).toLong())
            this.dataCollectTime = System.currentTimeMillis()

        while (System.currentTimeMillis() < this.dataCollectTime+(Constants.WINDOW*(100).toLong())) {
            //Lista de Sensores
            // coloque aqui os sensores e informe o método de coleta dele
            if (context.sensors.contains(typeSensor.ACC))
                context.datas += ValuesSensor(
                    typeSensor.ACC.name,
                    context.collectAcc.FormatData(context.collectAcc.getValueData())
                )

            //Fim Coleta Sensores

            //coleta de bateria
            context.energy = CollectEnergy().collectEnergy(context)

            //Collect Data from GoogleFit
            context.dataController = br.ufc.poc2.controllers.DataController()
            googleFitAllData =  GoogleFitGetAllData(context.googleFitAPI)
            googleFitAllData!!.checkPermissionAndGetData()

        }
        this.dataCollectTime = 0
        //Observer pattern
        sendUpdateEvent()
    }

    override fun update() {
        Monitoring()
    }

}