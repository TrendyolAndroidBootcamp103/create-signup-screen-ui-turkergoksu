package school.cactus.succulentshop.ui.auth

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import school.cactus.succulentshop.R
import school.cactus.succulentshop.databinding.ActivitySignUpBinding

class SignUpActivity : AppCompatActivity() {
    private var binding: ActivitySignUpBinding? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        setContentView(binding?.root)
        supportActionBar?.title = getString(R.string.sign_up)

        binding?.apply {
            signUpButton.setOnClickListener {
                // TODO: 30-Apr-21
            }

            alreadyHaveAnAccountButton.setOnClickListener {
                finish()
            }
        }
    }
}