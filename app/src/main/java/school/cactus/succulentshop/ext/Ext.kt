package school.cactus.succulentshop.ext

import com.google.android.material.textfield.TextInputLayout
import school.cactus.succulentshop.ui.auth.validators.Validator

fun TextInputLayout.validate(validator: Validator, getStringFromResourceId: (Int) -> String) {
    val errorMessage = validator.validate(editText!!.text.toString())
    error = errorMessage?.let { getStringFromResourceId(it) }
    isErrorEnabled = errorMessage != null
}