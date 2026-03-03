package org.example.project

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.safeContentPadding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Divider
import androidx.compose.material3.DividerDefaults
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.isa.project.db.Note

import org.jetbrains.compose.resources.painterResource

import simplekmpdb.composeapp.generated.resources.Res
import simplekmpdb.composeapp.generated.resources.compose_multiplatform
import kotlin.random.Random

@Composable
@Preview
fun App(repository: NoteRepository) {

    // State: Beobachtbare Liste
//    val notes = remember { mutableStateListOf<Note>() }

    // State für TextField
    var text by remember { mutableStateOf("") }



    Column(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {

        // Eingabefeld
        TextField(
            value = text,
            onValueChange = { text = it },
            modifier = Modifier.fillMaxWidth(),
            label = { Text("Neue Notiz eingeben") }
        )

        Spacer(modifier = Modifier.height(8.dp))

        // Speicher-Button
        Button(
            onClick = {
                if (text.isNotBlank()) {
//                    notes.add(Note(3000, text))
                    repository.saveNote(text)
                    text = "" // Eingabe leeren
                }
            },
            modifier = Modifier.fillMaxWidth()
        ) {
            Text("Speichern")
        }

        Spacer(modifier = Modifier.height(16.dp))

//        LaunchedEffect(Unit) {
//            notes.clear()
//            notes.addAll(repository.getNotes())
//        }

        // Liste anzeigen
        val notes = repository.getNotes()
        LazyColumn {
            items(notes) { note ->
                Text(
                    text = note.text,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                )
                HorizontalDivider()
            }
        }

        //debug
        Button(onClick = { println("Meine Notizen: ${repository.getNotes().toString()}") }) {
            Text("println the notes!")
        }
    }



//    MaterialTheme {
//        var showContent by remember { mutableStateOf(false) }
//        Column(
//            modifier = Modifier
//                .background(MaterialTheme.colorScheme.primaryContainer)
//                .safeContentPadding()
//                .fillMaxSize(),
//            horizontalAlignment = Alignment.CenterHorizontally,
//        ) {
//            Button(onClick = { showContent = !showContent }) {
//                Text("Click me!")
//            }
//            Button(onClick = { repository.saveNote("hellooo") }) {
//                Text("save note!")
//            }
//
//            Button(onClick = { println("Meine Notizen: ${repository.getNotes().toString()}") }) {
//                Text("println!")
//            }
//
//            AnimatedVisibility(showContent) {
//                val greeting = remember { Greeting().greet() }
//                Column(
//                    modifier = Modifier.fillMaxWidth(),
//                    horizontalAlignment = Alignment.CenterHorizontally,
//                ) {
//                    Image(painterResource(Res.drawable.compose_multiplatform), null)
//                    Text("Compose: $greeting")
//                }
//            }
//        }
//    }
}