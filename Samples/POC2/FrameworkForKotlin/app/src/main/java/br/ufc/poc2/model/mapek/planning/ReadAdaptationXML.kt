//------Generated by the Framework and must be changed-----//
//------Read Adaptation Template Rules-----//

package br.ufc.poc2.model.mapek.planning

import android.os.StrictMode
import android.util.Log
import br.ufc.poc2.model.entities.AdaptationRules
import br.ufc.poc2.model.utils.Constants
import br.ufc.poc2.ui.CommonActivities.BaseActivity
import okhttp3.OkHttpClient
import okhttp3.Request
import java.io.*
import java.lang.Exception

class ReadAdaptationXML {

    companion object {
        fun readXML(context:BaseActivity) : AdaptationRules{
            var adaptationRules:AdaptationRules? = null
            //baixa o template
            var adaptationsXML:List<String>? = null
            try {
                val xml = downloadXML(Constants.BACKEND_IP_PORT_ADAPTATION_RULES)
                var  fileW = BufferedWriter(FileWriter(File(context.baseDirectory+"/AdaptationRules.xml")))
                fileW.write(xml)
                fileW.close()
                adaptationsXML = xml.replace(
                        "\r",
                        ""
                    ).replace("\t", "").split("\n")
            }catch (e:Exception){
                e.printStackTrace()
                Log.i("Download Error","Não foi possível baixar a lista de regras de adaptação")
            }

            //Caso não baixe a lista, ler a mais recente
            if(adaptationsXML == null){
                try {
                    adaptationsXML = BufferedReader(FileReader(File(context.baseDirectory+"/AdaptationRules.xml"))).readText().replace(
                        "\r",
                        ""
                    ).replace("\t", "").split("\n")
                }catch (e:Exception){
                    e.printStackTrace()
                }
            }

            //preenche base de conhecimento

            var adaptations:MutableList<AdaptationRules.Adaptation> = mutableListOf()
            var adaptation:AdaptationRules.Adaptation? = null
            var contextos:MutableList<AdaptationRules.context>? = null
            var contexto:AdaptationRules.context? = null
            for(line in adaptationsXML!!){
                if(line.contains("<adaptation>"))
                    adaptation = AdaptationRules.Adaptation("", mutableListOf())
                if(line.contains("</adaptation>"))
                    adaptations.add(adaptation!!)

                if(line.contains("<contextList>"))
                    contextos = mutableListOf()

                if(line.contains("</contextList>"))
                    adaptation!!.contextList = contextos!!

                if(line.contains("<context>"))
                    contexto = AdaptationRules.context("","","")
                if(line.contains("</context>"))
                    contextos!!.add(contexto!!)

                if(line.contains("<action>"))
                    adaptation!!.action = line.replace("<action>","").replace("</action>","")

                if(line.contains("<name>"))
                    contexto!!.name = line.replace("<name>","").replace("</name>","")

                if(line.contains("<signal>"))
                    contexto!!.signal = line.replace("<signal>","").replace("</signal>","")

                if(line.contains("<value>"))
                    contexto!!.value = line.replace("<value>","").replace("</value>","")
            }
            adaptationRules = AdaptationRules(adaptations)


            return adaptationRules!!
        }

        //Download
        fun downloadXML(url:String):String {
            val client = OkHttpClient()
            val policy = StrictMode.ThreadPolicy.Builder().permitAll().build()
            StrictMode.setThreadPolicy(policy)
            val request = Request.Builder()
                .url(url)
                .build()

            client.newCall(request).execute().use { response ->
                if (!response.isSuccessful) throw IOException("Unexpected code $response")

                for ((name, value) in response.headers) {
                    println("$name: $value")
                }
                return response.body!!.string()
            }
            return ""
        }


    }

}