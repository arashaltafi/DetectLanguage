package com.arash.altafi.detectlanguage

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.view.inputmethod.InputMethodManager
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.arash.altafi.detectlanguage.databinding.ActivityMainBinding
import java.text.Bidi
import java.util.*

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        checkLanguageKeyboard()
        checkLanguageOfString()
    }

    private fun checkLanguageKeyboard() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.N) {
            val inputMethodManager =
                getSystemService(Context.INPUT_METHOD_SERVICE) as InputMethodManager
            val inputMethodSubtype = inputMethodManager.currentInputMethodSubtype
            val languageTag = inputMethodSubtype?.languageTag ?: Locale.getDefault().toLanguageTag()
            val languageCode = Locale.forLanguageTag(languageTag).language
            Toast.makeText(this, "current languageTag: $languageTag", Toast.LENGTH_SHORT).show()
            Toast.makeText(this, "current languageCode: $languageCode", Toast.LENGTH_SHORT).show()
        }
    }

    private fun checkLanguageOfString() = binding.apply {
        btnCheck.setOnClickListener {
            val string = binding.etTest.editText?.text?.trim().toString()
            val bidi = Bidi(string, Bidi.DIRECTION_DEFAULT_LEFT_TO_RIGHT)
            if (bidi.baseLevel == 0)
                Toast.makeText(this@MainActivity, "left to right (English)", Toast.LENGTH_SHORT)
                    .show()
            else
                Toast.makeText(this@MainActivity, "right to left (Persian)", Toast.LENGTH_SHORT)
                    .show()
        }
    }

}