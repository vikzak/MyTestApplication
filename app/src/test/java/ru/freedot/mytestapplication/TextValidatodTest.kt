package ru.freedot.mytestapplication

import android.content.Context
import android.view.View
import junit.framework.TestCase
import org.junit.Test

class TextValidatodTest(context: Context?) : View(context) {

    @Test
    fun textValidator_ReturnsTrue() {
        TestCase.assertEquals(TextValidator.isValidText("qqqq"),TextValidator.isValidText("qqqq"))
    }
}