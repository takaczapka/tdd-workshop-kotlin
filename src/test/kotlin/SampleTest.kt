import com.natpryce.hamkrest.assertion.assertThat
import com.natpryce.hamkrest.equalTo
import io.mockk.every
import io.mockk.mockk
import io.mockk.verify
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import java.lang.RuntimeException

class SampleTest {
    @Test
    fun `I can add two numbers`() {
        assertThat(4, equalTo(Calculator().add(2, 2)))
    }

    @Test
    fun `I can mockk a class and verify it`() {

        val calc = mockk<Calculator>()

        every { calc.add(any(), any()) } returns 15

        assertThat(15, equalTo(calc.add(1, 3)))

        verify { calc.add(1, 3) }
    }

    @Test
    fun `I don't care what value mock returns (RELAXED mode), but I can still verify if it was called`() {

        val calc = mockk<Calculator>(relaxed = true)

        calc.add(1, 3)

        verify { calc.add(1, 3) }
    }

    @Test
    fun `I can use other assertions`() {
        assertThrows<RuntimeException> {
            throw RuntimeException()
        }
    }
}
