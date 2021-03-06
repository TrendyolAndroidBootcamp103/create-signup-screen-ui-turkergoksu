package school.cactus.succulentshop.ui.auth.validators

import school.cactus.succulentshop.R

class EmailValidator : Validator {

    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.err_email_field_is_required
        field.any { it == '@' }.not() || field.any { it == '.' }
            .not() -> R.string.err_email_is_invalid
        field.substringBefore('@').length < 5 -> R.string.err_email_is_invalid
        field.substringBefore('@').length >= 50 -> R.string.err_email_is_invalid
        else -> null
    }
}