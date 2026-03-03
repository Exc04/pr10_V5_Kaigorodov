// BaseEnterpriseDemo.kt
package enterprise

// Вспомогательный класс для демонстрации базового класса
class BaseEnterpriseDemo(
    name: String,
    plannedVolume: Double,
    actualVolume: Double
) : EnterpriseBase(name, plannedVolume, actualVolume) {
    // Добавляем метод для получения имени через геттер
    fun getEnterpriseName(): String = getName()
}