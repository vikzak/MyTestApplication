package ru.freedot.mytestapplication

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import ru.freedot.mytestapplication.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val emailValidator = EmailValidator()
    private val textValidator = TextValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        with(binding) {
            emailInput.addTextChangedListener(emailValidator)
            saveButton.setOnClickListener {
                if (emailValidator.isValid) {
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.valid_email),
                        Toast.LENGTH_SHORT
                    ).show()
                } else {

                    val errorEmail =
                        getString(R.string.invalid_email)
                    emailInput.error = errorEmail
                    Toast.makeText(
                        this@MainActivity, errorEmail,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }

            buttonTest.setOnClickListener {
                editTextOne.addTextChangedListener(textValidator)
                if (textValidator.isValid){
                    Toast.makeText(
                        this@MainActivity,
                        getString(R.string.valid_text),
                        Toast.LENGTH_SHORT
                    ).show()
                } else{
                    Toast.makeText(
                        this@MainActivity, R.string.no_valid_text,
                        Toast.LENGTH_SHORT
                    ).show()
                }
            }
        }
    }
}