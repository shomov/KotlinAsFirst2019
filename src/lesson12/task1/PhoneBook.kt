@file:Suppress("UNUSED_PARAMETER")

package lesson12.task1

/**
 * Класс "Телефонная книга".
 *
 * Общая сложность задания -- средняя.
 * Объект класса хранит список людей и номеров их телефонов,
 * при чём у каждого человека может быть более одного номера телефона.
 * Человек задаётся строкой вида "Фамилия Имя".
 * Телефон задаётся строкой из цифр, +, *, #, -.
 * Поддерживаемые методы: добавление / удаление человека,
 * добавление / удаление телефона для заданного человека,
 * поиск номера(ов) телефона по заданному имени человека,
 * поиск человека по заданному номеру телефона.
 *
 * Класс должен иметь конструктор по умолчанию (без параметров).
 */
class PhoneBook {

    private val book = mutableMapOf<String, MutableSet<String>>()

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже был в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */

    private fun checkName(data: String) {
        if (!data.matches(Regex("""[А-Яа-яЁё]+ [А-Яа-яЁё]+""")))
            throw IllegalArgumentException(data)

    }

    private fun checkPhone(data: String) {
        if (
            !data.matches(Regex("""(\+?\d[-\d]*(\([-\d ]+\)[-\d]+)?)""")) ||
            data.matches(Regex("""\*\d[\d+-]+\d#"""))
        )
            throw IllegalArgumentException(data)
    }

    fun addHuman(name: String): Boolean {
        checkName(name)
        return if (!book.containsKey(name)) {
            book[name] = mutableSetOf()
            true
        } else {
            false
        }
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun removeHuman(name: String): Boolean {
        checkName(name)
        return if (book.containsKey(name)) {
            book.remove(name)
            true
        } else {
            false
        }
    }

    /**
     * Добавить номер телефона.
     * Возвращает true, если номер был успешно добавлен,
     * и false, если человек с таким именем отсутствовал в телефонной книге,
     * либо у него уже был такой номер телефона,
     * либо такой номер телефона зарегистрирован за другим человеком.
     */
    fun addPhone(name: String, phone: String): Boolean {
        checkName(name)
        checkPhone(phone)
        if (book.containsKey(name) && book.values.find { it.contains(phone) }.isNullOrEmpty()) {
            book[name]?.add(phone)
            return true
        }
        return false
    }


    /**
     * Убрать номер телефона.
     * Возвращает true, если номер был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * либо у него не было такого номера телефона.
     */
    fun removePhone(name: String, phone: String): Boolean {
        checkName(name)
        checkPhone(phone)
        if (book.containsKey(name) && book[name]?.contains(phone) == true) {
            book[name]?.remove(phone)
            return true
        }
        return false
    }

    /**
     * Вернуть все номера телефона заданного человека.
     * Если этого человека нет в книге, вернуть пустой список
     */
    fun phones(name: String): Set<String>? {
        if (book.containsKey(name))
            return book[name]?.toSet()
        return emptySet()
    }

    /**
     * Вернуть имя человека по заданному номеру телефона.
     * Если такого номера нет в книге, вернуть null.
     */
    fun humanByPhone(phone: String): String? =
        if (book.filterValues { it.contains(phone) }.keys.isNotEmpty())
            book.filterValues { it.contains(phone) }.keys.first()
        else
            null

    /**
     * Две телефонные книги равны, если в них хранится одинаковый набор людей,
     * и каждому человеку соответствует одинаковый набор телефонов.
     * Порядок людей / порядок телефонов в книге не должен иметь значения.
     */
    override fun equals(other: Any?): Boolean {
        if (other is PhoneBook)
            return other.book == book
        return false
    }

    override fun hashCode(): Int = book.hashCode()
}
