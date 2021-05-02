package school.cactus.succulentshop.auth

import com.google.common.truth.Truth
import org.junit.Test
import school.cactus.succulentshop.R
import school.cactus.succulentshop.ui.auth.validators.EmailValidator

class EmailValidatorTest {
    @Test
    fun `given empty e-mail as input, when validate is called, then validate should return err_email_field_is_required`() {
        // Given
        val givenEmail = ""
        val emailValidator = EmailValidator()

        // When
        val actualResult = emailValidator.validate(givenEmail)

        // Then
        val expectedResult = R.string.err_email_field_is_required
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given invalid e-mail as input, when validate is called, then validate should return err_email_is_invalid`() {
        // Given
        val givenEmail = "turkergoksugmail.com"
        val emailValidator = EmailValidator()

        // When
        val actualResult = emailValidator.validate(givenEmail)

        // Then
        val expectedResult = R.string.err_email_is_invalid
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given short e-mail as input, when validate is called, then validate should return err_email_is_invalid`() {
        // Given
        val givenEmail = "goks@gmail.com"
        val emailValidator = EmailValidator()

        // When
        val actualResult = emailValidator.validate(givenEmail)

        // Then
        val expectedResult = R.string.err_email_is_invalid
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given long e-mail as input, when validate is called, then validate should return err_email_is_invalid`() {
        // Given
        val givenEmail = "AAAAAbbbbbAAAAAbbbbbAAAAAbbbbbAAAAAbbbbbAAAAAbbbbb@gmail.com"
        val emailValidator = EmailValidator()

        // When
        val actualResult = emailValidator.validate(givenEmail)

        // Then
        val expectedResult = R.string.err_email_is_invalid
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given valid e-mail as input, when validate is called, then validate should return null`() {
        // Given
        val givenEmail = "turkergoksu@gmail.com"
        val emailValidator = EmailValidator()

        // When
        val actualResult = emailValidator.validate(givenEmail)

        // Then
        val expectedResult = null
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }
}