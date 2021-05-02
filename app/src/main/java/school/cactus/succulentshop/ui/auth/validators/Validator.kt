package school.cactus.succulentshop.ui.auth.validators

interface Validator {
    fun validate(field: String): Int?
}