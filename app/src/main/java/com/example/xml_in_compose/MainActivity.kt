package com.example.xml_in_compose

import android.os.Bundle
import android.view.View
import android.widget.TextView
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.viewinterop.AndroidView
import com.example.xml_in_compose.ui.theme.XML_in_ComposeTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            XML_in_ComposeTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colorScheme.background
                ) {
                    AppContent()
                }
            }
        }
    }
}

@Composable
fun AppContent() {

    AndroidView(
        factory = {
            View.inflate(it, R.layout.layout_xml, null)
        },
        modifier = Modifier.fillMaxSize(),
        update = {
            val textView = it.findViewById<TextView>(R.id.txt)
            textView.setOnClickListener {
                textView.text = "View Text updated"
            }
        },
    )
}


@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    XML_in_ComposeTheme {
        AppContent()
    }
}