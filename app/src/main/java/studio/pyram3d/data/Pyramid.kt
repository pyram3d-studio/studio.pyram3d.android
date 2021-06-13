package studio.pyram3d.data

import kotlin.math.sqrt

class Pyramid(val height: Double, val base: Double, sides: Int = 3, val regular: Boolean = false) {
    val laterals: HashSet<Triangle> = hashSetOf()
    val area: Double = base * base
    val lateralArea: Double
    val totalArea: Double
    val volume: Double = if (regular)
        when (sides) {
            3 -> (area * height) / (sqrt(3.0) / 12)
            4 -> (area * height) / 3
            5 -> base * (base / 2) * height / (5 / 6)
            6 -> (area * height) / 3
            else -> 0.0 //out of bound exception
        }
    else (area * height) / 3

    init {
        arrayOfNulls<Triangle>(sides).iterator().forEach { _ -> this.laterals.add(Triangle(height, base / 2)) }
        val apotema: Double = if (this.laterals.any()) this.laterals.first().apothem else 0.0
        lateralArea = ((area * apotema) / 2) * sides
        totalArea = (area) + lateralArea
    }
}