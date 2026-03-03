package org.example.project

actual class DatabaseDriverFactory(private val context: android.content.Context) {
    actual fun createDriver(): app.cash.sqldelight.db.SqlDriver {
        return app.cash.sqldelight.driver.android.AndroidSqliteDriver(
            com.isa.project.db.AppDatabase.Schema,
            context,
            "notes.db"
        )
    }
}