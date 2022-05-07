package com.phcdevelop.anyhookdemo

import android.os.Bundle
import android.widget.Toast
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.tooling.preview.PreviewParameter
import androidx.compose.ui.tooling.preview.PreviewParameterProvider
import androidx.fragment.app.FragmentActivity
import com.phcdevelop.anyhook.hook.PreviewHook
import com.phcdevelop.anyhookdemo.ui.theme.AnyHookDemoTheme

class MainActivity : FragmentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        PreviewHook.instance.onActCreate(this)
        Toast.makeText(this,"hook success!!",Toast.LENGTH_LONG).show()
    }
}

@Preview
@Composable
fun Greeting(@PreviewParameter(TestProvider::class) name: String) {
    Text(text = "Hello $name!")
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    AnyHookDemoTheme {
        Greeting("Android")
    }
}

class TestProvider : PreviewParameterProvider<String> {
    override val values: Sequence<String>
        get() = sequenceOf("test","123")

}