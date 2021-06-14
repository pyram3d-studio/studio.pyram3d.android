package studio.pyram3d.data

import kotlin.math.sqrt

class Triangle(val height: Double, val side: Double) {
    val apothem: Double = sqrt((height * height) + (side * side))
}