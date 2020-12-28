package integration

import util.linspace

class Trapezoidal {
    var independentValues: Array<Double> = arrayOf()
    var dependentValues: Array<Double> = arrayOf()

    constructor(function: (Double) -> (Double), domain: Array<Double>, intervals: Int = 50) {
        when (domain.size){
            1 -> this.independentValues = linspace(0.0, domain[0], intervals)

            2 -> this.independentValues = linspace(domain[0], domain[1], intervals)
        }
        assignDependentValues(function, this.independentValues)

    }

    constructor(dependentValues: Array<Double>) {
        this.dependentValues = dependentValues
        independentValues = linspace(0.0, dependentValues.size.toDouble(), dependentValues.size)
    }

    constructor(dependentValues: Array<Double>, independentValues: Array<Double>) {
        this.dependentValues = dependentValues
        this.independentValues = independentValues
    }

    fun trapezoidArea(leftValue: Double, rightValue: Double) {
        TODO("This function needs to be reworked")
    }


    private fun assignDependentValues(function: (Double) -> Double, domain: Array<Double>) {
        val values = arrayListOf<Double>()

        for ( i in domain){
            values.add(function(i))
        }
        dependentValues = values.toTypedArray()
    }

}