// EnterpriseBase.kt
package enterprise

abstract class EnterpriseBase : IEnterprise {
    private var _name: String
    private var _plannedVolume: Double
    private var _actualVolume: Double

    // Конструктор 1
    constructor() {
        this._name = "Неизвестное предприятие"
        this._plannedVolume = 1.0
        this._actualVolume = 0.0
    }

    // Конструктор 2
    constructor(name: String, plannedVolume: Double, actualVolume: Double) {
        this._name = name
        this._plannedVolume = if (plannedVolume > 0) plannedVolume else 1.0
        this._actualVolume = actualVolume
    }

    // Реализация метода интерфейса
    override fun getName(): String = _name

    // Реализация метода интерфейса
    override fun getQuality(): Double {
        return if (_plannedVolume != 0.0) _actualVolume / _plannedVolume else 0.0
    }

    // Дополнительные геттеры для других полей
    fun getPlannedVolume(): Double = _plannedVolume
    fun getActualVolume(): Double = _actualVolume

    override fun displayInfo() {
        println("Предприятие: $_name")
        println("Плановый объем: ${"%.2f".format(_plannedVolume)}")
        println("Фактический объем: ${"%.2f".format(_actualVolume)}")
        println("Q (отношение факт/план): ${"%.4f".format(getQuality())}")
    }
}