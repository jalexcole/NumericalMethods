import kotlin.math.abs

fun newtonRaphson(function: (Double) -> (Double), startPoint: Double = 0.0, iterations: Int = 1024, errorAllowed: Double = 1e-16) : Double {
    var setPoint = startPoint

    for (i in 0 until iterations) {
        if (function(setPoint) == 0.0 || abs(function(setPoint)) < errorAllowed) {
            return setPoint
        }
        setPoint -= function(setPoint) / derivative(function, setPoint, errorAllowed)
    }

    return Double.NaN
}

fun derivative(function: (Double) -> (Double), input: Double, errorAllowed: Double = 1e-16): Double {
    val left = input - errorAllowed
    val right = input + errorAllowed

    return (function(right) - function(left)) / (right - left)
}

fun newtonRaphson(function: (Float) -> (Float), startPoint: Float = 0.0f, iterations: Int = 1024, errorAllowed: Float = 1e-16f) : Float {
    var setPoint = startPoint

    for (i in 0 until iterations) {
        if (function(setPoint) == 0.0f || abs(function(setPoint)) < errorAllowed) {
            return setPoint
        }
        setPoint -= function(setPoint) / derivative(function, setPoint, errorAllowed)
    }

    return Float.NaN
}

fun derivative(function: (Float) -> (Float), input: Float, errorAllowed: Float = 1e-16f): Float {
    val left = input - errorAllowed
    val right = input + errorAllowed

    return (function(right) - function(left)) / (right - left)
}