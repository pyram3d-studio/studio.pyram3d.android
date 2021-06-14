package studio.pyram3d.data

import kotlin.math.sqrt

class Pyramid(val height: Double, val side: Double, baseType: Int = 3, val regular: Boolean = false) {
    val laterals: HashSet<Triangle> = hashSetOf()
    val baseHeight: Double = when (baseType) {
        3 -> sqrt((side * side) - ((side / 2) * (side / 2)))
        4 -> side
        else -> 0.0
    }
    val area: Double = when (baseType) {
        3 -> (side * baseHeight) / 2
        4 -> side * side
        else -> 0.0
    }
    val lateralArea: Double
    val totalArea: Double
    val volume: Double = if (regular)
        when (baseType) {
            3 -> (area * height) / (sqrt(3.0) / 12)
            4 -> (area * height) / 3
            5 -> side * (side / 2) * height / (5 / 6)
            6 -> (area * height) / 3
            else -> 0.0 //out of bound exception
        }
    else (area * height) / 3

    init {
        arrayOfNulls<Triangle>(baseType).iterator().forEach { _ -> this.laterals.add(Triangle(height,baseHeight / 2)) }
        val apothem: Double = if (this.laterals.any()) this.laterals.first().apothem else 0.0
        lateralArea = when (baseType) {
            3 -> ((side * 3) * apothem) / 2
            4 -> ((area * apothem) / 2) * baseType
            else -> 0.0
        }
        totalArea = area + lateralArea
    }
}