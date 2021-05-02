package school.cactus.succulentshop.ui.auth.validators

import school.cactus.succulentshop.R

class PasswordValidator : Validator {

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.err_password_field_is_required
        field.length < 8 -> R.string.err_password_is_too_short
        field.length > 40 -> R.string.err_password_is_too_long
        field.isContainsRequiredCharacters().not() -> R.string.err_password_must_provide_conditions
        else -> null
    }

    private fun String.isContainsRequiredCharacters() =
                any { it.isDigit() } &&
                any { it.isLowerCase() } &&
                any { it.isUpperCase() } &&
                any { (it.isDigit().not() && it.isLetter().not()) }
}