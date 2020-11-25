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
        private val TABLE_NAME1 = "SymptomTBL"
        private val SYM_ID = "Id"
        private val SYM_NAME = "Name"
        private val SYM_INCIDENCE = "Incidence"

        private val TABLE_NAME2 = "AfterEffectTBL"
        private val EFF_ID = "Id"
        private val EFF_NAME = "Name"
        private val EFF_INCIDENCE = "Incidence"
    }

    override fun onCreate(db: SQLiteDatabase?) {
        val CREATE_TABLE_QUERY1 = ("CREATE TABLE $TABLE_NAME1 ($SYM_ID INTEGER PRIMARYKEY, $SYM_NAME TEXT, $SYM_INCIDENCE INTEGER)")
        db!!.execSQL(CREATE_TABLE_QUERY1)

        val CREATE_TABLE_QUERY2 = ("CREATE TABLE $TABLE_NAME2 ($EFF_ID INTEGER PRIMARYKEY, $EFF_NAME TEXT, $EFF_INCIDENCE INTEGER)")
        db!!.execSQL(CREATE_TABLE_QUERY2)
    }

    override fun onUpgrade(db: SQLiteDatabase?, oldVersion: Int, newVersion: Int) {
        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME1")
        onCreate(db!!)

        db!!.execSQL("DROP TABLE IF EXISTS $TABLE_NAME2")
        onCreate(db!!)
    }

    fun addSymptom(id: Int, name: String, incidence: Int) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(SYM_ID, id)
        values.put(SYM_NAME, name)
        values.put(SYM_INCIDENCE, incidence)

        db.insert(TABLE_NAME1, null, values)
        db.close()
    }

    fun addAfterEffect(id: Int, name: String, incidence: Int) {
        val db = this.writableDatabase
        val values = ContentValues()
        values.put(EFF_ID, id)
        values.put(EFF_NAME, name)
        values.put(EFF_INCIDENCE, incidence)

        db.insert(TABLE_NAME2, null, values)
        db.close()
    }
}
