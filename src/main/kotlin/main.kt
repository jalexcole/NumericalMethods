
fun main() {
    val myFunction : (Double) -> (Double) =  {x: Double -> 5 * x + 3}

    val bisectionRoot = bisection(myFunction, -10.0, 10.0)
    val newtonRoot = newtonRaphson(myFunction)
    val secantRoot = secant(myFunction)
    println("Root actual is: 0.6")
    println("Bisection root: $bisectionRoot")
    println("Newton Raphson root: $newtonRoot")
    println("Secant Method root: $secantRoot")
}