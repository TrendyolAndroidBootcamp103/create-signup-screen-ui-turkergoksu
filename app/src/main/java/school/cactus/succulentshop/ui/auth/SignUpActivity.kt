package school.cactus.succulentshop.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivitySignUpBinding
import school.cactus.succulentshop.ext.validate
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
                emailTextInputLayout.validate(emailValidator) { getString(it) }
                usernameTextInputLayout.validate(usernameValidator) { getString(it) }
                passwordTextInputLayout.validate(passwordValidator) { getString(it) }
            }

            alreadyHaveAnAccountButton.setOnClickListener {
                finish()
            }
        }
    }
}