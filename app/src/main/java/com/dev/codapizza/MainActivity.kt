package com.dev.codapizza

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import com.dev.codapizza.ui.AppTheme
import com.dev.codapizza.ui.PizzaBuilderScreen
import com.microsoft.appcenter.AppCenter
import com.microsoft.appcenter.analytics.Analytics
import com.microsoft.appcenter.crashes.Crashes

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AppTheme {
                PizzaBuilderScreen()
            }
        }
        AppCenter.start(
            application,
            "329e5f90-e64d-4c88-906d-8edb75cc20c9",
            Analytics::class.java,
            Crashes::class.java
        )

    }
}