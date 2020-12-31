package integration

import util.linspace

/**
 * Bar integration is a crude form of numerical integration where a rectangle is used to calculate the area
 * between two points.
 *
 * @author Alex Cole
 *
 * @constructor Takes multiple data types and returns either a double or float value
 *
 */
class Bar {

    constructor(dependentValues: Array<Double>, independentValues: Array<Double>) {
        /**
         * @param array of f(x) values, x values
         */
        integrate(dependentValues, independentValues)

    }

    constructor(dependentValues: Array<Float>, independentValues: Array<Float>) {
        integrate(dependentValues, independentValues)
    }

    constructor(function: (Double) -> (Double), domain: Array<Double>, intervals: Int = 50) {
        var independentValues = arrayOf<Double>()
        when (domain.size){
            1 -> {
                independentValues = linspace(0.0, domain[0], intervals)
            }

            2 -> {
                independentValues = linspace(domain[0], domain[1], intervals)
            }
        }
        val dependentValues = arrayListOf<Double>()

        for (i in independentValues) {
            dependentValues.add(function(i))
        }

        integrate(dependentValues.toTypedArray(), independentValues)

    }

    constructor(function: (Float) -> (Float), domain: Array<Float>, intervals: Int = 50) {
        var independentValues = arrayOf<Float>()
        when (domain.size){
            1 -> {
                independentValues = linspace(0.0f, domain[0], intervals)
            }

            2 -> {
                independentValues = linspace(domain[0], domain[1], intervals)
            }
        }
        val dependentValues = arrayListOf<Float>()

        for (i in independentValues) {
            dependentValues.add(function(i))
        }

        integrate(dependentValues.toTypedArray(), independentValues)

    }

    constructor(dependentValues: Array<Double>) {
        val independentValues = linspace(0.0, dependentValues.size.toDouble(), dependentValues.size)
        integrate(dependentValues, independentValues)
    }

    constructor(dependentValues: Array<Float>) {
        val independentValues = linspace(0.0f, dependentValues.size.toFloat(), dependentValues.size)
        integrate(dependentValues, independentValues)
    }



    private fun integrate(dependentValues: Array<Double>, independentValues: Array<Double>): Double {
        var sum = 0.0
        var barCount = dependentValues.size - 1

        for (i in 0 until barCount){
            sum = calculateArea(dependentValues[i], independentValues[i])
        }

        return sum
    }

    private fun integrate(dependentValues: Array<Float>, independentValues: Array<Float>): Float {
        var sum = 0.0f
        var barCount = dependentValues.size - 1

        for (i in 0 until barCount){
            sum = calculateArea(dependentValues[i], independentValues[i])
        }

        return sum
    }

    private fun calculateArea(height: Double, width: Double): Double {
        return height * width
    }

    private fun calculateArea(height: Float, width: Float): Float {
        return height * width
    }


}

