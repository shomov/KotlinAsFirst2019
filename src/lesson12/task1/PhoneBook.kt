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
class PhoneBook() {

    private val book = mutableMapOf<String, MutableList<String>>()

    /**
     * Добавить человека.
     * Возвращает true, если человек был успешно добавлен,
     * и false, если человек с таким именем уже был в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */

    private fun inspection(type: Boolean, data: String) {
        if (type) {
            if (!data.matches(Regex("""[А-Яа-яЁё]+ [А-Яа-яЁё]+""")))
                throw IllegalArgumentException(data)
        } else {
            if (
                !data.matches(Regex("""(\+?\d[-\d]*(\([-\d ]+\)[-\d]+)?)""")) ||
                data.matches(Regex("""\*\d[\d+-]+\d#"""))
            )
                throw IllegalArgumentException(data)
        }
    }

    //хотя... не надо, выводить номер будет неудобно
    //в принципе, можно каждый раз проверять на эквивалентность имеющихся в базе номеров и входных
    // private fun generalizer() Эта функция должна приводить телефонный номер в единый формат , скажем из +7x-x-x -> 8xxx

    fun addHuman(name: String): Boolean {
        inspection(true, name)
        return if (!book.containsKey(name)) {
            book[name] = mutableListOf()
            true
        } else
            false
    }

    /**
     * Убрать человека.
     * Возвращает true, если человек был успешно удалён,
     * и false, если человек с таким именем отсутствовал в телефонной книге
     * (во втором случае телефонная книга не должна меняться).
     */
    fun removeHuman(name: String): Boolean {
        inspection(true, name)
        return if (book.containsKey(name)) {
            book.remove(name)
            true
        } else
            false
    }

    /**
     * Добавить номер телефона.
     * Возвращает true, если номер был успешно добавлен,
     * и false, если человек с таким именем отсутствовал в телефонной книге,
     * либо у него уже был такой номер телефона,
     * либо такой номер телефона зарегистрирован за другим человеком.
     */
    fun addPhone(name: String, phone: String): Boolean {
        inspection(true, name)
        inspection(false, phone)
        if (book.containsKey(name)) {
            for ((person, _) in book)
                if (book[person]?.contains(phone)!!)
                    return false
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
        inspection(true, name)
        inspection(false, phone)
        if (book.containsKey(name)) {
            for ((person, _) in book)
                if (book[person]?.contains(phone)!!) {
                    book[name]?.remove(phone)
                    return true
                }
        }
        return false
    }

    /**
     * Вернуть все номера телефона заданного человека.
     * Если этого человека нет в книге, вернуть пустой список
     */
    fun phones(name: String): Set<String> = TODO()

    /**
     * Вернуть имя человека по заданному номеру телефона.
     * Если такого номера нет в книге, вернуть null.
     */
    fun humanByPhone(phone: String): String? = TODO()

    /**
     * Две телефонные книги равны, если в них хранится одинаковый набор людей,
     * и каждому человеку соответствует одинаковый набор телефонов.
     * Порядок людей / порядок телефонов в книге не должен иметь значения.
     */
    override fun equals(other: Any?): Boolean = TODO()
}