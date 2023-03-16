//------Generated by the Framework and must not be changed-----//

package br.ufc.frameworkkotlin.model.dao.interfaces

import android.content.ContentValues
import android.database.Cursor

interface IRepository {
    fun Add(cValues:ContentValues):Int
    fun GetById(id:Int): Cursor
    fun GetAll(): Cursor
    fun Update(id:Int, info:String, valor:Boolean):Boolean
    fun Update(id:Int, info:String, valor:Byte):Boolean
    fun Update(id:Int, info:String, valor:ByteArray):Boolean
    fun Update(id:Int, info:String, valor:Double):Boolean
    fun Update(id:Int, info:String, valor:Float):Boolean
    fun Update(id:Int, info:String, valor:Int):Boolean
    fun Update(id:Int, info:String, valor:Short):Boolean
    fun Update(id:Int, info:String, valor:String):Boolean
    fun Remove(id:Int): Boolean
    fun RemoveAll(): Boolean
    fun SaveChanges()
}