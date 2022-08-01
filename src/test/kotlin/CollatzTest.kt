import org.junit.jupiter.api.Test
import org.junit.jupiter.api.Assertions.assertEquals

internal class CollatzTest {

    @Test
    fun `intIsEven returns true if number is even`() {
        val testRange = 1..100
        val evenNumbers = testRange.map {
            it * 2
        }

        evenNumbers.forEach {
            assertEquals(it.isEven(), true)
        }
    }

    @Test
    fun `intIsEven returns false if number is odd`() {
        val testRange = 1..100
        val oddNumbers = testRange.map {
            (it * 2) - 1
        }. filterNot { it == 0 }

        oddNumbers.forEach {
            assertEquals(it.isEven(), false)
        }
    }

    @Test
    fun `works as expected`() {
        assertEquals(13.collatz(), listOf(13, 40, 20, 10, 5, 16, 8, 4, 2, 1))

        assertEquals(8.collatz(), listOf(8, 4, 2, 1))
    }

}