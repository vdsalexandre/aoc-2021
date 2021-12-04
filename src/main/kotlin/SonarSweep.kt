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

    fun countIncreasesMeasurementBy3(measures: IntArray): Int {
        var count = 0
        var elementToCompare = measures[0] + measures[1] + measures[2]

        for (i in 1 until measures.size - 2) {
            val measuresBy3 = measures[i] + measures[i+1] + measures[i+2]
            if (measuresBy3 > elementToCompare)
                count++
            elementToCompare = measuresBy3
        }
        return count
    }
}
