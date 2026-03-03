package org.example.project

import com.isa.project.db.AppDatabase
import com.isa.project.db.Note

class NoteRepository(driverFactory: DatabaseDriverFactory) {
    private val database = AppDatabase(driverFactory.createDriver())
    private val queries = database.appDatabaseQueries

    fun saveNote(text: String) {
        queries.insertNote(text)
    }

    fun getNotes(): List<Note> {
        return queries.selectAll().executeAsList()
    }
}