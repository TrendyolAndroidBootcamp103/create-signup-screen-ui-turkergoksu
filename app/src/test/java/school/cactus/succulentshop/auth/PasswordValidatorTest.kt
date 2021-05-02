package school.cactus.succulentshop.auth

import com.google.common.truth.Truth
import org.junit.Test
import school.cactus.succulentshop.R
import school.cactus.succulentshop.ui.auth.validators.PasswordValidator

class PasswordValidatorTest {
    @Test
    fun `given empty password as input, when validate is called, then validate should return err_password_field_is_required`() {
        // Given
        val givenPassword = ""
        val passwordValidator = PasswordValidator()

        // When
        val actualResult = passwordValidator.validate(givenPassword)

        // Then
        val expectedResult = R.string.err_password_field_is_required
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given short password as input, when validate is called, then validate should return err_password_is_too_short`() {
        // Given
        val givenPassword = "shrt"
        val passwordValidator = PasswordValidator()

        // When
        val actualResult = passwordValidator.validate(givenPassword)

        // Then
        val expectedResult = R.string.err_password_is_too_short
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given long password as input, when validate is called, then validate should return err_password_is_too_long`() {
        // Given
        val givenPassword = "AAAAAbbbbbAAAAAbbbbbAAAAAbbbbbAAAAAbbbbbA"
        val passwordValidator = PasswordValidator()

        // When
        val actualResult = passwordValidator.validate(givenPassword)

        // Then
        val expectedResult = R.string.err_password_is_too_long
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given password without special characters as input, when validate is called, then validate should return err_password_must_provide_conditions`() {
        // Given
        val givenPassword = "myNotSpecialPassword"
        val passwordValidator = PasswordValidator()

        // When
        val actualResult = passwordValidator.validate(givenPassword)

        // Then
        val expectedResult = R.string.err_password_must_provide_conditions
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given valid password as input, when validate is called, then validate should return null`() {
        // Given
        val givenPassword = "validPassword0@"
        val passwordValidator = PasswordValidator()

        // When
        val actualResult = passwordValidator.validate(givenPassword)

        // Then
        val expectedResult = null
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }
}