package util

fun linspace(start: Double, stop: Double, stepCount: Int = 50): Array<Double> {
        val step = (stop - start) / stepCount.toDouble()
        val linspaceArray = arrayOf<Double>()
        for (i in linspaceArray.indices) {
           linspaceArray[i] = start + i * step
        }

        return linspaceArray
    }
