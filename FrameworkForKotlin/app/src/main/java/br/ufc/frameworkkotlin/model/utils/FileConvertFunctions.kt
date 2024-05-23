package br.ufc.frameworkkotlin.model.utils

import android.app.Activity
import java.io.File
import java.io.FileWriter
import java.io.InputStream

class FileConvertFunctions {
    companion object{
        fun inputStreamToFile(inputStream: InputStream,path:String):File{
            var file = File(path)
            file.writeText(inputStream.bufferedReader().readText())
            //val writer = FileWriter(file)
            //val content = inputStream.bufferedReader().readText()
            //writer.write(content)
            //writer.close()
            return file
        }


    }
}