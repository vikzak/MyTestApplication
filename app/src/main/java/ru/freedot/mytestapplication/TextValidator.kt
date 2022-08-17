package ru.freedot.mytestapplication

import android.text.Editable
import android.text.TextWatcher
import java.util.regex.Pattern

class TextValidator: TextWatcher {
    internal var isValid = false

    override fun beforeTextChanged(s: CharSequence?, start: Int, count: Int, after: Int) {
        //
    }

    override fun onTextChanged(s: CharSequence?, start: Int, before: Int, count: Int) {
        //
    }

    override fun afterTextChanged(s: Editable?) {
        isValid = isValidText(s)
    }

    companion object {
        /**
         * Паттерн для сравнения. */
        private val TEXT_PATTERN = Pattern.compile(
            "[a-zA-Z]{1,256}"
        )

        fun isValidText(text: CharSequence?): Boolean {
            return text != null && TEXT_PATTERN.matcher(text).matches()
        }
    }


}