//------Generated by the Framework and can be changed-----//
//------Collect Data from Smartphone Battery-----//

package br.ufc.poc2.model.mapek.monitoring

import android.os.BatteryManager
import androidx.appcompat.app.AppCompatActivity
import br.ufc.poc2.ui.CommonActivities.BaseActivity

class CollectEnergy(){
    var energy: Double = 0.0

    fun collectEnergy(context: BaseActivity):Double{
        val bm = context.getSystemService(AppCompatActivity.BATTERY_SERVICE) as BatteryManager
        val energy = bm.getIntProperty(BatteryManager.BATTERY_PROPERTY_CAPACITY).toDouble()
        return energy
    }

}