package integration

import org.junit.jupiter.api.Assertions.*
import util.linspace
import kotlin.math.pow


internal class BarTest {
    val testFunction: (Double) -> (Double) = {x:Double -> 5 * x.pow(2.0) + 3.0 * x + 5.0}
    val testRange = arrayOf(0, 10)

    val independentValues = linspace(0.0, 10.0)
    val dependentValues = dependentTestValues(testFunction, independentValues)

    var expetedValue = 1866.7 // from wolfram alpha



}


fun dependentTestValues(function: (Double) -> (Double), independentTestValues: Array<Double>): Array<Double> {
    var dependentValues = arrayListOf<Double>()
    for(i in independentTestValues) {
        dependentValues.add(function(i))
    }

    return dependentValues.toTypedArray()
}