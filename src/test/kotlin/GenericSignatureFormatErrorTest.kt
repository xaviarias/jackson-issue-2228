import com.fasterxml.jackson.module.kotlin.jacksonObjectMapper
import com.fasterxml.jackson.module.kotlin.readValue
import org.assertj.core.api.Assertions
import org.junit.jupiter.api.Test
import java.lang.reflect.GenericSignatureFormatError

class GenericSignatureFormatErrorTest {

    private val mapper = jacksonObjectMapper()

    @Test
    internal fun `when a Kotlin class name contains spaces Jackson fails to deserialize`() {

        data class LocalDataClass(val prop: String)

        Assertions.assertThatExceptionOfType(GenericSignatureFormatError::class.java).isThrownBy {
            mapper.readValue<LocalDataClass>("{\"prop\" : \"val\"}")
        }
    }

}