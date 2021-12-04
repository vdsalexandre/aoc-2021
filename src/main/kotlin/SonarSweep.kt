class SonarSweep {
    fun countIncreasesMeasurement(measures: IntArray): Int {
        var count = 0
        var elementToCompare = measures.first()

        for (i in 1 until measures.size) {
            if (measures[i] > elementToCompare)
                count++
            elementToCompare = measures[i]
        }

        return count
    }
}
