@file:Suppress("UNUSED_PARAMETER")

package lesson11.task1

/**
 * Класс "Величина с размерностью".
 *
 * Предназначен для представления величин вроде "6 метров" или "3 килограмма"
 * Общая сложность задания - средняя.
 * Величины с размерностью можно складывать, вычитать, делить, менять им знак.
 * Их также можно умножать и делить на число.
 *
 * В конструктор передаётся вещественное значение и строковая размерность.
 * Строковая размерность может:
 * - либо строго соответствовать одной из abbreviation класса Dimension (m, g)
 * - либо соответствовать одной из приставок, к которой приписана сама размерность (Km, Kg, mm, mg)
 * - во всех остальных случаях следует бросить IllegalArgumentException
 */
class DimensionalValue(value: Double, dimension: String) : Comparable<DimensionalValue> {
    /**
     * Величина с БАЗОВОЙ размерностью (например для 1.0Kg следует вернуть результат в граммах -- 1000.0)
     */


    var value: Double = when {
        (dimension.length > 1 &&
                DimensionPrefix.values().find { it.abbreviation == dimension.first().toString() } != null &&
                Dimension.values().find { it.abbreviation == dimension } == null &&
                Dimension.values().find { it.abbreviation == dimension.removePrefix(dimension[0].toString()) } != null
                ) -> value * DimensionPrefix.values().find { it.abbreviation == dimension.first().toString() }?.multiplier!!
        (Dimension.values().find { it.abbreviation == dimension } == null) -> throw IllegalArgumentException()
        else -> value
    }


    /**
     * БАЗОВАЯ размерность (опять-таки для 1.0Kg следует вернуть GRAM)
     */

    val dimension: Dimension = when {
        (dimension.length > 1) -> Dimension.values().find { it.abbreviation == dimension.removePrefix(dimension[0].toString()) }!!
        (Dimension.values().find { it.abbreviation == dimension } != null) -> Dimension.values().find { it.abbreviation == dimension }!!
        else -> throw IllegalArgumentException()
    }

    /**
     * Конструктор из строки. Формат строки: значение пробел размерность (1 Kg, 3 mm, 100 g и так далее).
     */
    constructor(s: String) : this(s.substringBefore(" ").toDouble(), s.substringAfter(" "))

    private val abbr: String
        get() = dimension.abbreviation

    /**
     * Сложение с другой величиной. Если базовая размерность разная, бросить IllegalArgumentException
     * (нельзя складывать метры и килограммы)
     */

    operator fun plus(other: DimensionalValue): DimensionalValue {
        if (dimension == other.dimension)
            return DimensionalValue(value + other.value, abbr)
        else
            throw IllegalArgumentException()
    }

    /**
     * Смена знака величины
     */
    operator fun unaryMinus(): DimensionalValue = DimensionalValue((-1.0) * value, abbr)

    /**
     * Вычитание другой величины. Если базовая размерность разная, бросить IllegalArgumentException
     */
    operator fun minus(other: DimensionalValue): DimensionalValue {
        if (dimension == other.dimension)
            return DimensionalValue(value - other.value, abbr)
        else
            throw IllegalArgumentException()
    }

    /**
     * Умножение на число
     */
    operator fun times(other: Double): DimensionalValue =
        DimensionalValue(value * other, abbr)

    /**
     * Деление на число
     */
    operator fun div(other: Double): DimensionalValue =
        DimensionalValue(value / other, abbr)

    /**
     * Деление на другую величину. Если базовая размерность разная, бросить IllegalArgumentException
     */
    operator fun div(other: DimensionalValue): Double {
        if (dimension == other.dimension)
            return value / other.value
        else
            throw IllegalArgumentException()
    }


    /**
     * Сравнение на равенство
     */
    override fun equals(other: Any?): Boolean =
        other is DimensionalValue && (value == other.value && dimension == other.dimension)

    /**
     * Сравнение на больше/меньше. Если базовая размерность разная, бросить IllegalArgumentException
     */
    override fun compareTo(other: DimensionalValue): Int {
        if (dimension == other.dimension)
            return when {
                value < other.value -> -1
                value > other.value -> 1
                else -> 0
            }
        else
            throw IllegalArgumentException()
    }

    override fun hashCode(): Int {
        var result = value.hashCode()
        result = 31 * result + dimension.hashCode()
        return result
    }
}


/**
 * Размерность. В этот класс можно добавлять новые варианты (секунды, амперы, прочие), но нельзя убирать
 */
enum class Dimension(val abbreviation: String) {
    METER("m"),
    GRAM("g"),
    VOLT("V"),
    HERTZ("Hz");
}

/**
 * Приставка размерности. Опять-таки можно добавить новые варианты (деци-, санти-, мега-, ...), но нельзя убирать
 */
enum class DimensionPrefix(val abbreviation: String, val multiplier: Double) {
    KILO("K", 1000.0),
    MILLI("m", 0.001),
    NANO("n", 0.000000001);
}