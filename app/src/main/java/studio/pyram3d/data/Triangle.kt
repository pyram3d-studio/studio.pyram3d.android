package studio.pyram3d.data

import kotlin.math.sqrt

class Triangle(val height: Double, val base: Double) {
    val apothem: Double = sqrt((height * height) + (base * base))
}