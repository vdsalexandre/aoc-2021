import org.junit.jupiter.api.Test
import java.io.File

class AOCDay4Test {
    private val path = "src/test/resources/day4_test.txt"

    @Test
    internal fun `day 4 - part 1`() {
        val lines = readLinesFromFile()
        val bingoNumbersOrder = getBingoNumbersOrder(lines)
        println(bingoNumbersOrder)
        val playerGrids = getPlayersGrid(lines)
   //     playBingo(bingoNumbersOrder, playerGrids)
    }

//    private fun playBingo(bingoNumbersOrder: List<String>, grids: MutableList<PlayerGrid>) {
//        for (i in bingoNumbersOrder.indices) {
//            for (j in grids[0].indices) {
//                if (grids[0][j].contains(bingoNumbersOrder[i]))
//                    grids[0][j].replace(bingoNumbersOrder[i], "")
//            }
//        }
//    }

    private fun getBingoNumbersOrder(lines: List<String>) = lines.first().split(",")

    private fun readLinesFromFile() = File(path).readLines()

    private fun getPlayersGrid(lines: List<String>): MutableList<PlayerGrid> {
        var grids: MutableList<PlayerGrid> = mutableListOf()
        var grid = Array(5) { Array(5) { 0 } }
        var index = 0

        val usefulValues = lines.drop(2)
            .map { it.split("\n\n") }

        for (i in usefulValues.indices) {
            if (usefulValues[i][0].isNotEmpty() && index < 5) {
                grid[index] = getNumbersFromListOfValues(usefulValues[i])
                //     grid[index] = getNumbersFromListOfValues(usefulValues[i])
                index++
            } else {
                grids.add(PlayerGrid(grid))
                grid = Array(5) { Array(5) { 0 } }
                index = 0
            }
        }

        return grids
    }

    private fun getNumbersFromListOfValues(usefulValues: List<String>): Array<GridValue> {
        return usefulValues.toString()
            .removeSurrounding("[", "]")
            .split(" ").filter { it.isNotBlank() }.map { GridValue(it.toInt()) }.toTypedArray()
    }
}