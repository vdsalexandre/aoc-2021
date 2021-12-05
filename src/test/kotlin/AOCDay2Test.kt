import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AOCDay2Test {
    private val path: String = "src/test/resources/submarinemoves.txt"

    @Test
    internal fun `part 1 and 2`() {
        val expectedResult = 2044620088
        val moves = readMovesFromFile()
//        val moves = listOf(
//            Move("forward", 5),
//            Move("down", 5),
//            Move("forward", 8),
//            Move("up", 3),
//            Move("down", 8),
//            Move("forward", 2)
//        )

        val submarine = Submarine()
        val newPosition = submarine.move(moves)

        val result = multiplyValues(newPosition.horizontalPosition, newPosition.depth)

        assertThat(result).isEqualTo(expectedResult)
    }

    private fun multiplyValues(first: Int, second: Int): Int {
        return first * second
    }

    private fun readMovesFromFile(): List<Move> = File(path).readLines().map {
        val line = it.split(" ")
        Move(line[0], line[1].toInt())
    }

}