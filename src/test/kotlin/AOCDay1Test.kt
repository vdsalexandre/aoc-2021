import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class AOCDay1Test {

    private val path: String = "src/test/resources/sonarsweep.txt"

    @Test
    internal fun `should count increases measurement`() {
        val expectedCount = 1266
        val measures = readMeasuresFromFile()

        val sonar = SonarSweep()
        val count = sonar.countIncreasesMeasurement(measures)

        assertThat(count).isEqualTo(expectedCount)
    }

    @Test
    internal fun `part 2`() {
        val expectedCount = 1217
        val measures = readMeasuresFromFile()

        val sonar = SonarSweep()
        val count = sonar.countIncreasesMeasurementBy3(measures)

        assertThat(count).isEqualTo(expectedCount)
    }

    private fun readMeasuresFromFile(): IntArray = File(path).useLines { it.map { it.toInt() }.toList() }.toIntArray()
}