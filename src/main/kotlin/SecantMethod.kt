import kotlin.math.abs

fun secant(function: (Double) -> (Double), iteration: Int = 1024, errorAllowed: Double = 1e-16): Double {
    var lastPosition = 0.0
    var currentPosition = 1.0
    var nextPosition: Double
    for (i in 0 until iteration) {
        val f0 = function(lastPosition)
        val f1 = function(currentPosition)

        nextPosition = currentPosition - (f1 * (lastPosition - currentPosition)) / (f0 - f1)

        lastPosition = currentPosition
        currentPosition = nextPosition

        if (function(currentPosition) == 0.0 || abs(function(currentPosition)) < errorAllowed) {
            return currentPosition
        }
    }

    return Double.NaN
}