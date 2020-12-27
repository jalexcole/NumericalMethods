/**
 *
 *
 * Muller's Method is used to find the roots of a polynomial system similar to the secant method.
 * A parabola is construted through three points and used for root solving.
 *
 */

fun mullersMethod(polynomialFunction: (Double) -> (Double), iterations: Int = 1024) {
    var initalGuess = arrayOf(0.0, 1.0, 2.0)

}