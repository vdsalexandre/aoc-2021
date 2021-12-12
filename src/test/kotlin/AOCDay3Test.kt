import org.junit.jupiter.api.Test
import java.io.File

class AOCDay3Test {

    private val path = "src/test/resources/submarinemoves.txt"

    @Test
    internal fun `day 3 part 1`() {
        val lines = listOf(
            "00100",
            "11110",
            "10110",
            "10111",
            "10101",
            "01111",
            "00111",
            "11100",
            "10000",
            "11001",
            "00010",
            "01010"
        )
        val columns = getColumnsFromFile(lines)
        columns.forEach { println(it) }
    }

    @Test
    internal fun name() {
        val columns = getColumnsFromFile(File(path).readLines())

        //    val columns = getColumnsFromFile(lines)
        val gammaRateBinary = getGammaRateInBinary(columns)
        println(gammaRateBinary)
        val gammaRateDecimal = binaryToDecimal(gammaRateBinary)
        val epsilonRateDecimal = binaryInvertedToDecimal(gammaRateBinary)
        val powerConsuption = gammaRateDecimal * epsilonRateDecimal
        println("$gammaRateDecimal * $epsilonRateDecimal = $powerConsuption")
    }

    private fun getColumnsFromFile(lines: List<String>): Array<String> {
        val columns = Array(lines.first().length) { "" }

        lines.map {
            for (i in it.indices) {
                columns[i] = columns[i].plus(it[i])
            }
        }
        return columns
    }

    private fun getGammaRateInBinary(columns: Array<String>): String {
        val size = columns.first().length
        var MCB = ""

        for (i in columns.indices) {
            val one = columns[i].count { it == '1' }

            MCB = if (one > size / 2)
                MCB.plus("1")
            else
                MCB.plus("0")
        }
        return MCB
    }

    private fun binaryToDecimal(binary: String): Int = binary.toInt(2)

    private fun binaryInvertedToDecimal(binary: String): Int {
        return binary.map { it.digitToInt().xor(1) }.joinToString("").toInt(2)
    }

    @Test
    internal fun `part 2 day 3`() {
//        val lines = mutableListOf(
//            "00100",
//            "11110",
//            "10110",
//            "10111",
//            "10101",
//            "01111",
//            "00111",
//            "11100",
//            "10000",
//            "11001",
//            "00010",
//            "01010"
//        )
        val lines = File(path).readLines()
        val mostUsedValue = getOxygenGeneratorRating(lines, 0)
        println(mostUsedValue)
        println(binaryToDecimal(mostUsedValue))
        val co2 = getCO2ScrubberRating(lines, 0)
        println(co2)
        println(binaryToDecimal(co2))
        val lifeSupportRating = binaryToDecimal(mostUsedValue) * binaryToDecimal(co2)
        println("life support rating = $lifeSupportRating")
    }

    private fun getOxygenGeneratorRating(lines: List<String>, index: Int): String {
        val ones = mutableListOf<String>()
        val zeros = mutableListOf<String>()

        if (index < lines.first().length) {
            for (i in lines.indices) {
                val firstCharacter = lines[i][index]

                if (firstCharacter == '1') {
                    ones.add(lines[i])
                } else
                    zeros.add(lines[i])
            }
        }

        if (lines.size > 1) {
            return if (ones.size >= zeros.size)
                getOxygenGeneratorRating(ones, index + 1)
            else
                getOxygenGeneratorRating(zeros, index + 1)
        }
        return lines.first()
    }

    private fun getCO2ScrubberRating(lines: List<String>, index: Int): String {
        val ones = mutableListOf<String>()
        val zeros = mutableListOf<String>()

        if (index < lines.first().length) {
            for (i in lines.indices) {
                val firstCharacter = lines[i][index]

                if (firstCharacter == '1') {
                    ones.add(lines[i])
                } else
                    zeros.add(lines[i])
            }
        }

        if (lines.size > 1) {
            return if (ones.size < zeros.size)
                getCO2ScrubberRating(ones, index + 1)
            else
                getCO2ScrubberRating(zeros, index + 1)
        }
        return lines.first()
    }
}