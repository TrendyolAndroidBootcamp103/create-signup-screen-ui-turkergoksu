package school.cactus.succulentshop.ui.auth.validators

import school.cactus.succulentshop.R

class UsernameValidator : Validator {

    private val usernameRule: Regex by lazy { "^[a-z0-9_]+\$".toRegex() }

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.err_username_field_is_required
        field.matches(usernameRule).not() -> R.string.err_username_character_error
        field.length <= 2 -> R.string.err_username_is_too_short
        field.length > 20 -> R.string.err_username_is_too_long
        else -> null
    }
}