package enterprise

fun main() {
// 1. Демонстрация базового класса (3 объекта)
    println("")

    val baseEnterprise1 = BaseEnterpriseDemo("Магазин 'Продукты'", 1000.0, 1200.0)
    val baseEnterprise2 = BaseEnterpriseDemo("Магазин 'Одежда'", 2000.0, 1900.0)
    val baseEnterprise3 = BaseEnterpriseDemo("Магазин 'Электроника'", 1500.0, 1500.0)


    val taxEnterprise1 = TaxEnterprise("ООО 'Прибыль Плюс'", 1000.0, 1200.0, 5.0)    // Налог 5% (≤6%)
    val taxEnterprise2 = TaxEnterprise("ООО 'Норма'", 2000.0, 2100.0, 6.0)            // Налог 6% (граница)
    val taxEnterprise3 = TaxEnterprise("ООО 'Убыток Минус'", 1500.0, 1300.0, 10.0)     // Налог 10% (>6%)
    val taxEnterprise4 = TaxEnterprise("ООО 'Граница'", 1800.0, 1710.0, 7.0)          // Qp ≈ 0.95


    // 3. Демонстрация работы анализатора

    val analyzer = EnterpriseAnalyzer()

    // Добавляем все предприятия
    analyzer.addEnterprise(baseEnterprise1)
    analyzer.addEnterprise(baseEnterprise2)
    analyzer.addEnterprise(baseEnterprise3)
    analyzer.addEnterprise(taxEnterprise1)
    analyzer.addEnterprise(taxEnterprise2)
    analyzer.addEnterprise(taxEnterprise3)
    analyzer.addEnterprise(taxEnterprise4)

    // Анализируем все
    analyzer.analyzeAll()

    // Находим самое прибыльное
    val mostProfitable = analyzer.findMostProfitable()
    if (mostProfitable != null) {
        println("\nСАМОЕ ПРИБЫЛЬНОЕ ПРЕДПРИЯТИЕ:")
        mostProfitable.displayInfo()
    }

    // Статистика
    val stats = analyzer.getStatistics()
    println("")
    println("\nСТАТИСТИКА")
    println("")
    println("Прибыльных предприятий: ${stats["прибыльные"]}")
    println("Бесприбыльных: ${stats["бесприбыльные"]}")
    println("Убыточных: ${stats["убыточные"]}")

}