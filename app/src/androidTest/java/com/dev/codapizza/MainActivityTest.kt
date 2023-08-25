package com.dev.codapizza

import androidx.compose.ui.test.hasText
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.test.onFirst
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.dev.codapizza.ui.AppTheme
import com.dev.codapizza.ui.PizzaBuilderScreen
import com.microsoft.appcenter.espresso.Factory
import com.microsoft.appcenter.espresso.ReportHelper
import org.junit.After
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class MainActivityTest {

    @get:Rule
    val composeTestRule = createAndroidComposeRule<MainActivity>()

    @JvmField
    @Rule
    val reportHelper: ReportHelper = Factory.getReportHelper()

    @Before
    fun setUp() {
        reportHelper.label("Starting App")
    }

    @After
    fun tearDown() {
        reportHelper.label("Stopping App")
    }

    @Test
    fun initTest() {
        composeTestRule.setContent {
            AppTheme {
                PizzaBuilderScreen()
            }
        }
        val basilText = "Basil"
        val mushroomsText = "Mushrooms"
        val olivesText = "Olives"
        val peppers = "Peppers"
        val pepperoniText = "Pepperoni"

//        composeTestRule.onRoot(useUnmergedTree = true).printToLog("composeTestRule")
        composeTestRule.onAllNodes(hasText(basilText)).onFirst().assertExists()
        composeTestRule.onAllNodes(hasText(mushroomsText)).onFirst().assertExists()
        composeTestRule.onAllNodes(hasText(olivesText)).onFirst().assertExists()
        composeTestRule.onAllNodes(hasText(peppers)).onFirst().assertExists()
        composeTestRule.onAllNodes(hasText(pepperoniText)).onFirst().assertExists()
    }
}