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

    fun getIfARowCompleted(): MutableList<GridValue> {
        val gridValues: MutableList<GridValue> = mutableListOf()

        for (i in grid.indices) {
            var count = 0
            val row = grid[i]

            for (j in row.indices) {
                if (row[j].selected) {
                    count++
                    gridValues.add(row[j])
                }
            }

            if (count == 5)
                return gridValues
        }
        return mutableListOf()
    }

    fun hasAColumnCompleted(): Boolean {
        for (i in grid.indices) {

        }


        return false
    }
}