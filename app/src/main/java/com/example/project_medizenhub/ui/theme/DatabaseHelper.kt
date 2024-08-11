package com.example.project_medizenhub.ui.theme

import android.content.ContentValues
import android.content.Context
import android.database.Cursor
import android.database.sqlite.SQLiteDatabase
import android.database.sqlite.SQLiteOpenHelper

class DatabaseHelper(context: Context) : SQLiteOpenHelper(context, DATABASE_NAME, null, DATABASE_VERSION) {

    companion object {
        private const val DATABASE_VERSION = 1
        private const val DATABASE_NAME = "medizenhub.db"
        private const val TABLE_NAME = "User"
        private const val COLUMN_ID = "id"
        private const val COLUMN_NAME = "name"
        private const val COLUMN_EMAIL = "email"
        private const val COLUMN_PASSWORD = "password"
        private const val TABLE_ORDERS = "Orders"
        private const val COLUMN_USERNAME = "username"
        private const val COLUMN_MEDICINE_NAME = "medicine_name"
        private const val COLUMN_QUANTITY = "quantity"
    }

    override fun onCreate(db: SQLiteDatabase) {
        val createUsersTable = """
            CREATE TABLE $TABLE_NAME (
                $COLUMN_ID INTEGER PRIMARY KEY AUTOINCREMENT,
                $COLUMN_NAME TEXT,
                $COLUMN_EMAIL TEXT,
                $COLUMN_PASSWORD TEXT
            )
        """.trimIndent()
        db.execSQL(createUsersTable)
    }

    override fun onUpgrade(db: SQLiteDatabase, oldVersion: Int, newVersion: Int) {
        db.execSQL("DROP TABLE IF EXISTS $TABLE_NAME")
        onCreate(db)
    }

    fun insertUser(name: String, email: String, password: String): Long {
        val values = ContentValues().apply {
            put(COLUMN_NAME, name)
            put(COLUMN_EMAIL, email)
            put(COLUMN_PASSWORD, password)
        }
        val db = writableDatabase
        val id = db.insert(TABLE_NAME, null, values)
        db.close()
        return id
    }

    fun getUserByEmailAndPassword(email: String, password: String): User? {
        val db = readableDatabase
        val cursor: Cursor = db.query(
            TABLE_NAME,
            arrayOf(COLUMN_ID, COLUMN_NAME, COLUMN_EMAIL, COLUMN_PASSWORD),
            "$COLUMN_EMAIL = ? AND $COLUMN_PASSWORD = ?",
            arrayOf(email, password),
            null,
            null,
            null
        )

        var user: User? = null
        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex(COLUMN_ID)
            val id = cursor.getLong(idIndex)
            val nameIndex = cursor.getColumnIndex(COLUMN_NAME)
            val name = cursor.getString(nameIndex)
            val emailIndex = cursor.getColumnIndex(COLUMN_EMAIL)
            val userEmail = cursor.getString(emailIndex)
            val passwordIndex = cursor.getColumnIndex(COLUMN_PASSWORD)
            val userPassword = cursor.getString(passwordIndex)
            user = User(id, name, userEmail, userPassword)
        }
        cursor.close()
        db.close()
        return user
    }

    fun getUserByEmail(email: String): User? {
        val db = readableDatabase
        val cursor: Cursor = db.query(
            TABLE_NAME,
            arrayOf(COLUMN_ID, COLUMN_NAME, COLUMN_EMAIL, COLUMN_PASSWORD),
            "$COLUMN_EMAIL = ?",
            arrayOf(email),
            null,
            null,
            null
        )

        var user: User? = null
        if (cursor.moveToFirst()) {
            val idIndex = cursor.getColumnIndex(COLUMN_ID)
            val id = cursor.getLong(idIndex)
            val nameIndex = cursor.getColumnIndex(COLUMN_NAME)
            val name = cursor.getString(nameIndex)
            val emailIndex = cursor.getColumnIndex(COLUMN_EMAIL)
            val userEmail = cursor.getString(emailIndex)
            val passwordIndex = cursor.getColumnIndex(COLUMN_PASSWORD)
            val userPassword = cursor.getString(passwordIndex)
            user = User(id, name, userEmail, userPassword)
        }
        cursor.close()
        db.close()
        return user
    }

    fun saveOrder(order: Order) {
        val values = ContentValues().apply {
            put(COLUMN_USERNAME, order.userName)
            put(COLUMN_MEDICINE_NAME, order.medicationName)
            put(COLUMN_QUANTITY, order.quantity)
        }
        val db = writableDatabase
        db.insert(TABLE_ORDERS, null, values)
        db.close()
    }
}
