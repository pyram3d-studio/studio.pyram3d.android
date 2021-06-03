package app.pyram3d.data

import kotlin.math.sqrt

class Triangle(val height: Double, val base: Double) {
    val apotema: Double = sqrt(height + base)
}