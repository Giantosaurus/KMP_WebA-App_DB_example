package org.example.project

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.tooling.preview.Preview

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        enableEdgeToEdge()
        super.onCreate(savedInstanceState)

        val driverFactory = DatabaseDriverFactory(this)
        val repository = NoteRepository(driverFactory)
        setContent {
            val memoizedRepo = remember { repository }
            App(repository = memoizedRepo)
        }
    }
}

@Preview
@Composable
fun AppAndroidPreview() {
    //App()
}