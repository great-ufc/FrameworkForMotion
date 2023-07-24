//Animation for Test App

package br.ufc.POC1.model.utils

import br.ufc.POC1.ui.MainActivity

class Animations {
    companion object{
        fun monitoring() {
            var flag = true
            while (!MainActivity.flagMonitoring) {
                if (flag || MainActivity.texto == "Monitoring..."
                ) {
                    MainActivity.texto = "Monitoring"
                    flag = false
                    Thread.sleep(100)
                    continue
                }
                if (MainActivity.texto == "Monitoring")
                {
                    MainActivity.texto = "Monitoring."
                    Thread.sleep(100)
                    continue
                }
                if (MainActivity.texto == "Monitoring.")
                {
                    MainActivity.texto = "Monitoring.."
                    Thread.sleep(100)
                    continue
                }
                if (MainActivity.texto == "Monitoring..")
                {
                    MainActivity.texto = "Monitoring..."
                    Thread.sleep(100)
                    continue
                }

            }
            MainActivity.flagMonitoring = false
        }
    }
}