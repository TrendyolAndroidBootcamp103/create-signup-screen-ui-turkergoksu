package school.cactus.succulentshop.auth

import com.google.common.truth.Truth
import org.junit.Test
import school.cactus.succulentshop.R
import school.cactus.succulentshop.ui.auth.validators.UsernameValidator

class UsernameValidatorTest {
    @Test
    fun `given empty username as input, when validate is called, then validate should return err_username_field_is_required`() {
        // Given
        val givenUsername = ""
        val usernameValidator = UsernameValidator()

        // When
        val actualResult = usernameValidator.validate(givenUsername)

        // Then
        val expectedResult = R.string.err_username_field_is_required
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given username with special characters as input, when validate is called, then validate should return err_username_character_error`() {
        // Given
        val givenUsername = "turkergoksu0@!"
        val usernameValidator = UsernameValidator()

        // When
        val actualResult = usernameValidator.validate(givenUsername)

        // Then
        val expectedResult = R.string.err_username_character_error
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given short username as input, when validate is called, then validate should return err_username_is_too_short`() {
        // Given
        val givenUsername = "tg"
        val usernameValidator = UsernameValidator()

        // When
        val actualResult = usernameValidator.validate(givenUsername)

        // Then
        val expectedResult = R.string.err_username_is_too_short
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given long username as input, when validate is called, then validate should return err_username_is_too_long`() {
        // Given
        val givenUsername = "aaaaabbbbbaaaaabbbbba"
        val usernameValidator = UsernameValidator()

        // When
        val actualResult = usernameValidator.validate(givenUsername)

        // Then
        val expectedResult = R.string.err_username_is_too_long
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }

    @Test
    fun `given valid username as input, when validate is called, then validate should return null`() {
        // Given
        val givenUsername = "turkergoksu97_"
        val usernameValidator = UsernameValidator()

        // When
        val actualResult = usernameValidator.validate(givenUsername)

        // Then
        val expectedResult = null
        Truth.assertThat(actualResult).isEqualTo(expectedResult)
    }
}