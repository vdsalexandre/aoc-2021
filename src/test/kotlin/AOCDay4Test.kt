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
        playBingo(bingoNumbersOrder, playerGrids)
    }

    private fun playBingo(bingoNumbersOrder: List<Int>, grids: MutableList<PlayerGrid>) {
        for (i in bingoNumbersOrder.indices) {
            for (j in grids.indices) {
                grids[j].numberToSelect(bingoNumbersOrder[i])
            }

            for (index in grids.indices) {
                if (grids[index].hasARowCompleted()) {
                    println("player ${index+1} wins with number ${bingoNumbersOrder[i]}")
                    return
                }
            }

        }
    }

    private fun getBingoNumbersOrder(lines: List<String>) = lines.first().split(",").map { it.toInt() }

    private fun readLinesFromFile() = File(path).readLines()

    private fun getPlayersGrid(lines: List<String>): MutableList<PlayerGrid> {
        val grids: MutableList<PlayerGrid> = mutableListOf()
        var grid: Array<Array<GridValue>> = Array(5) { Array(5) { GridValue() } }
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
                grid = Array(5) { Array(5) { GridValue() } }
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