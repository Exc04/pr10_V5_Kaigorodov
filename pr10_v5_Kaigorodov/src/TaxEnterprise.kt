// TaxEnterprise.kt
package enterprise

class TaxEnterprise : EnterpriseBase {
    private var _taxPercent: Double

    // Конструктор 1
    constructor() : super() {
        this._taxPercent = 0.0
    }

    // Конструктор 2
    constructor(name: String, plannedVolume: Double, actualVolume: Double, taxPercent: Double)
            : super(name, plannedVolume, actualVolume) {
        this._taxPercent = taxPercent
    }

    // Геттер для налогов
    fun getTaxPercent(): Double = _taxPercent

    // Переопределение функции качества Qp
    override fun getQuality(): Double {
        val q = super.getQuality()

        val qp = if (_taxPercent <= 6.0) {
            q - (q * _taxPercent / 100.0)
        } else {
            q - 0.2 * q
        }

        return qp
    }

    fun getStatus(): String {
        val qp = getQuality()

        return when {
            qp > 1.0 -> "ПРИБЫЛЬНОЕ"
            qp >= 0.95 && qp <= 1.0 -> "НЕ ПРИНОСИТ ПРИБЫЛИ"
            else -> "УБЫТОЧНОЕ"
        }
    }

    override fun displayInfo() {
        super.displayInfo()
        println("Процент налогов (P): ${"%.2f".format(_taxPercent)}%")
        println("Qp (с учетом налогов): ${"%.4f".format(getQuality())}")
        println("Статус: ${getStatus()}")
    }
}