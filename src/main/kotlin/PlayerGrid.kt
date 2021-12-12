data class PlayerGrid(var grid:Array<Array<GridValue>>) {

    fun numberToSelect(number: Int) {
        for (i in grid.indices) {
            val playerGrid = grid[i]

            for (column in playerGrid.indices) {
                if (playerGrid[column].value == number) {
                    playerGrid[column].selected = true
                }
            }
        }
    }

    fun hasARowCompleted(): Boolean {
        for (i in grid.indices) {
            var count = 0
            val row = grid[i]

            for (j in row.indices) {
                if (row[j].selected)
                    count++
            }

            if (count == 5)
                return true
        }
        return false
    }

    fun hasAColumnCompleted(): Boolean {
        for (i in grid.indices) {

        }


        return false
    }
}