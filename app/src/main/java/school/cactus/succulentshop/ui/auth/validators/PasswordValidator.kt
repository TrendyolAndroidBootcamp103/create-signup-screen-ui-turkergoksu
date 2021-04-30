package school.cactus.succulentshop.ui.auth.validators

import school.cactus.succulentshop.R

class PasswordValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        else -> null
    }
}