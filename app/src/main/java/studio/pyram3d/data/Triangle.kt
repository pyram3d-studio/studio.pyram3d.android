package studio.pyram3d.data

import kotlin.math.sqrt

class Triangle(height: Double, side: Double) {
    val apothem: Double = sqrt((height * height) + (side * side))
}