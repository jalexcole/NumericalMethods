import kotlin.math.abs

fun bisection(function: (Double) -> (Double), a: Double, b: Double, iterations: Int = 1024, errorAllowed: Double = 1e-16): Double {

    var start = a
    var stop = b

    for (i in 0 until iterations) {
        var centerPoint = (start + stop) / 2

        if (abs(function(centerPoint)) < errorAllowed || function(centerPoint) == 0.0) {
            return centerPoint
        }
        if (function(centerPoint) * function(start) < 0) {
            stop = centerPoint
        } else {
            start = centerPoint
        }
    }

    return Double.NaN
}

fun bisection(function: (Float) -> (Float), a: Float, b: Float, iterations: Int = 1024, errorAllowed: Float = 1.0E-9F): Float {

    var start = a
    var stop = b

    for (i in 0 until iterations) {
        var centerPoint = (start + stop) / 2

        if (abs(function(centerPoint)) < errorAllowed || function(centerPoint) == 0.0f) {
            return centerPoint
        }
        if (function(centerPoint) * function(start) < 0) {
            stop = centerPoint
        } else {
            start = centerPoint
        }
    }

    return Float.NaN
}