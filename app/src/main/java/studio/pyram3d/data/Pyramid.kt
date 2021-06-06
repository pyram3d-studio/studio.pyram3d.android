package studio.pyram3d.data

class Pyramid(val height: Double, val base: Double, sides: Int = 3) {
    val laterals: HashSet<Triangle> = hashSetOf()
    val area: Double = base * base
    val lateralArea: Double
    val totalArea: Double
    val volume: Double = ((area) * height) / 3

    init {
        arrayOfNulls<Triangle>(sides).iterator().forEach { this.laterals.add(Triangle(height, base / 2)) }
        val apotema: Double = if (this.laterals.any()) this.laterals.first().apotema else 0.0
        lateralArea = ((area * apotema) / 2) * sides
        totalArea = (area) + lateralArea
    }
}