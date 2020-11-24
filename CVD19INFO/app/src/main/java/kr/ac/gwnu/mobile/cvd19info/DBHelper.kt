package kr.ac.gwnu.mobile.cvd19info

import android.content.ContentValues
import android.content.Context
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DBHelper (context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VER) {
    companion object {
        private val DATABASE_VER = 1
        private val DATABASE_NAME = "CLOCKRONA"

        //Table
        private val TABLE_NAME = "AfterEffectTBL"
        private val EFF_ID = "Id"
        private val EFF_NAME = "Name"
        private val EFF_INCIDENCE = "Incidence"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY = ("CREATE TABLE $TABLE_NAME ($EFF_ID INTEGER PRIMARYKEY, $EFF_NAME TEXT, $EFF_INCIDENCE INTEGER)")
        db!!.execSQL(CREATE_TABLE_QUERY)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db!!)
    }

    fun addAfterEffect(id: Int, name: String, incidence: Int) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(EFF_ID, id)
        values.put(EFF_NAME, name)
        values.put(EFF_INCIDENCE, incidence)

        db.insert(TABLE_NAME, null, values)
        db.close()
    }
}