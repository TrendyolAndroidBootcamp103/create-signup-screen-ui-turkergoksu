package school.cactus.succulentshop.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivitySignUpBinding
import school.cactus.succulentshop.ui.auth.validators.EmailValidator

class SignUpActivity : AppCompatActivity() {
    private var binding: ActivitySignUpBinding? = null

    private val emailValidator by lazy {
        EmailValidator()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding?.apply {
            signUpButton.setOnClickListener {
                emailTextInputLayout.validate()
            }

            alreadyHaveAnAccountButton.setOnClickListener {
                finish()
            }
        }
    }

    private fun TextInputLayout.validate() {
        val errorMessage = validator().validate(editText!!.text.toString())
        error = errorMessage?.resolveAsString()
        isErrorEnabled = errorMessage != null
    }

    private fun Int.resolveAsString() = getString(this)

    private fun TextInputLayout.validator() = when (this) {
        binding?.emailTextInputLayout -> emailValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
}