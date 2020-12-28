package curveFitting.regression

import org.junit.jupiter.api.Assertions.*

internal class LinearRegressionTest {
    val independentValues = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)
    val dependentValues = arrayOf(0.5, 2.5, 2.0, 4.0, 3.5, 6.0, 5.5)

    fun LinearRegressionTest() {
        val regressionTest = LinearRegression(dependentValues, independentValues)

        val expectedResult = arrayOf(0.07142857, 0.8392857)
        val actualResult = regressionTest.getVariables()

        val expectedError = 2.9911
        val actualError = regressionTest.error

        assertArrayEquals(expectedResult, actualResult) {
            "$expectedResult does not equal $actualResult"
        }
    }
}