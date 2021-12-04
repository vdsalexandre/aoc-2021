import java.io.File
import org.assertj.core.api.Assertions.assertThat
import org.junit.jupiter.api.Test

class SonarSweepTest {

    @Test
    internal fun `should count increases measurement`() {
        val expectedCount = 1266
        val measures = readMeasuresFromFile("src/test/resources/sonarsweep.txt").toIntArray()

        val sonar = SonarSweep()
        val count = sonar.countIncreasesMeasurement(measures)
        print("count : $count")

        assertThat(count).isEqualTo(expectedCount)
    }

    private fun readMeasuresFromFile(filename: String): List<Int> = File(filename).useLines { it.map { it.toInt() }.toList() }
}