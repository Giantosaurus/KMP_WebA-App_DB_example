package org.example.project

import app.cash.sqldelight.db.SqlDriver
import app.cash.sqldelight.driver.worker.WebWorkerDriver

actual class DatabaseDriverFactory {
    actual fun createDriver(): SqlDriver {
        return WebWorkerDriver(
            js("new Worker(new URL('./sqldelight-worker.js', import.meta.url))")
        )
    }
}