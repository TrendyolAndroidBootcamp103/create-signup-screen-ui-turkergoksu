package school.cactus.succulentshop.ui.auth

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivityLoginBinding
import school.cactus.succulentshop.ext.validate
import school.cactus.succulentshop.ui.auth.validators.IdentifierValidator
import school.cactus.succulentshop.ui.auth.validators.PasswordValidator

class LoginActivity : AppCompatActivity() {
    private lateinit var binding: ActivityLoginBinding

    private val identifierValidator = IdentifierValidator()
    private val passwordValidator = PasswordValidator()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.title = getString(R.string.log_in)

        binding.apply {
            logInButton.setOnClickListener {
                identifierInputLayout.validate(identifierValidator) { getString(it) }
                passwordInputLayout.validate(passwordValidator) { getString(it) }
            }

            createAccountButton.setOnClickListener {
                val intent = Intent(this@LoginActivity, SignUpActivity::class.java)
                startActivity(intent)
            }
        }
    }
}
