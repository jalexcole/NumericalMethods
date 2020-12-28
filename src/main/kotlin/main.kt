import curveFitting.regression.LinearRegression

fun main() {
    val myFunction : (Double) -> (Double) =  {x: Double -> 5 * x + 3}

    val bisectionRoot = bisection(myFunction, -10.0, 10.0)
    val newtonRoot = newtonRaphson(myFunction)
    val secantRoot = secant(myFunction)
    println("Root actual is: 0.6")
    println("Bisection root: $bisectionRoot")
    println("Newton Raphson root: $newtonRoot")
    println("Secant Method root: $secantRoot")

    val independentValues = arrayOf(1.0, 2.0, 3.0, 4.0, 5.0, 6.0, 7.0)
    val dependentValues   = arrayOf(0.5, 2.5, 2.0, 4.0, 3.5, 6.0, 5.5)

    println("${LinearRegression(dependentValues, independentValues).getVariables()[0]}, " +
            "${LinearRegression(dependentValues, independentValues).getVariables()[1]}")
}