package school.cactus.succulentshop.ui.auth.validators

import school.cactus.succulentshop.R

class PasswordValidator : Validator {

    // Regex from https://stackoverflow.com/a/21456918/6771753
    private val passwordRule: Regex by lazy {
        "^(?=.*[a-z])(?=.*[A-Z])(?=.*\\d)(?=.*[@$!%*?&])[A-Za-z\\d@$!%*?&]{8,}$".toRegex()
    }

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.err_password_field_is_required
        field.length <= 7 -> R.string.err_password_is_too_short
        field.length > 40 -> R.string.err_password_is_too_long
        field.matches(passwordRule).not() -> R.string.err_password_must_provide_conditions
        else -> null
    }
}