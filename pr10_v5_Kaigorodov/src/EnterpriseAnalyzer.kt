// EnterpriseAnalyzer.kt
package enterprise

class EnterpriseAnalyzer {
    private val enterprises = mutableListOf<IEnterprise>()

    fun addEnterprise(enterprise: IEnterprise) {
        enterprises.add(enterprise)
    }

    fun analyzeAll() {
        if (enterprises.isEmpty()) {
            println("Нет предприятий для анализа")
            return
        }

        println("АНАЛИЗ ВСЕХ ПРЕДПРИЯТИЙ")

        for ((index, enterprise) in enterprises.withIndex()) {
            println("\n${index + 1}. ")
            enterprise.displayInfo()
        }
    }

    fun findMostProfitable(): IEnterprise? {
        var best: TaxEnterprise? = null
        var bestQp = Double.MIN_VALUE

        for (e in enterprises) {
            if (e is TaxEnterprise) {
                val qp = e.getQuality()
                if (qp > bestQp) {
                    bestQp = qp
                    best = e
                }
            }
        }

        return best
    }

    fun getStatistics(): Map<String, Int> {
        var profitable = 0
        var neutral = 0
        var unprofitable = 0

        for (e in enterprises) {
            if (e is TaxEnterprise) {
                when (e.getStatus()) {
                    "ПРИБЫЛЬНОЕ" -> profitable++
                    "НЕ ПРИНОСИТ ПРИБЫЛИ" -> neutral++
                    "УБЫТОЧНОЕ" -> unprofitable++
                }
            }
        }

        return mapOf(
            "прибыльные" to profitable,
            "бесприбыльные" to neutral,
            "убыточные" to unprofitable
        )
    }
}