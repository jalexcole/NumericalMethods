package curveFitting.regression

import util.linspace
import kotlin.math.pow

class LinearRegression {
    var yIntercept = 0.0 // y intercept
    var slope = 0.0 // slope of the line
    var error: Double = 0.0

    constructor(array: Array<Double>) {
        // Assumes that the interval between the points is one unit
        val xIndex = linspace(0.0, array.size.toDouble(), array.size) // gives a independent axis if one does not exist
        findValues(array, xIndex)

    }
    constructor(arrayY: Array<Double>, arrayX: Array<Double>) {
        findValues(arrayY, arrayX)
    }

    fun findValues(arrayY: Array<Double>, arrayX: Array<Double>) {
        val n = arrayX.size.toDouble()
        slope = (n * summation(vectorMultiply(arrayX, arrayY)) - summation(arrayX) * summation(arrayY)) /
                (n * summation(vectorMultiply(arrayX, arrayX)) - summation(arrayX).pow(2.0))

        yIntercept = average(arrayY) - slope * average(arrayX)

        calculateError(arrayX, arrayY)
    }

    fun calculateError(array1: Array<Double>, array2: Array<Double>) {
        for (i in array1.indices) {
            error += (array2[i] - yIntercept - slope * array1[i]).pow(2.0)
        }
    }

    fun toEquation(): (Double) -> (Double) = {
        x:Double -> slope * x + yIntercept
    }

    fun getVariables(): Array<Double> {
        return arrayOf(yIntercept, slope)
    }


    fun average(array: Array<Double>): Double {
        return summation(array) / array.size.toDouble()
    }

    fun summation(array: Array<Double>): Double {
        var sum = 0.0
        for (value in array) {
            sum += value
        }
        return sum
    }

    fun vectorMultiply(array1: Array<Double>, array2: Array<Double>): Array<Double> {
        val newArray = arrayListOf<Double>()
        for (i in 0 until array1.size) {
            newArray.add(array1[i] * array2[i])
        }
        return newArray.toTypedArray()
    }


}