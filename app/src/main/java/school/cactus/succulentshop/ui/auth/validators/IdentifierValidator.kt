package school.cactus.succulentshop.ui.auth.validators

import school.cactus.succulentshop.R


class IdentifierValidator : Validator {
    override fun validate(field: String) = when {
        field.isEmpty() -> R.string.this_field_is_required
        field.length < 5 -> R.string.identifier_is_too_short
        else -> null
    }
}