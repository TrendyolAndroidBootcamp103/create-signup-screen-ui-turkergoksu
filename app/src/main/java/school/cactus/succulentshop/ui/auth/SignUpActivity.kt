package school.cactus.succulentshop.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivitySignUpBinding
import school.cactus.succulentshop.ui.auth.validators.EmailValidator
import school.cactus.succulentshop.ui.auth.validators.PasswordValidator
import school.cactus.succulentshop.ui.auth.validators.UsernameValidator

class SignUpActivity : AppCompatActivity() {
    private var binding: ActivitySignUpBinding? = null

    private val emailValidator by lazy { EmailValidator() }
    private val usernameValidator by lazy { UsernameValidator() }
    private val passwordValidator by lazy { PasswordValidator() }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding?.apply {
            signUpButton.setOnClickListener {
                emailTextInputLayout.validate()
                usernameTextInputLayout.validate()
                passwordTextInputLayout.validate()
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
        binding?.usernameTextInputLayout -> usernameValidator
        binding?.passwordTextInputLayout -> passwordValidator
        else -> throw IllegalArgumentException("Cannot find any validator for the given TextInputLayout")
    }
}