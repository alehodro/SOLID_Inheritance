/*
Интерфейс - это абстракция очень похожая на абстрактный класс с той лишь разницей, что интерфейс не может хранить
состояния(значения свойств), в интерфейсе могут быть объявлены свойства и функции, но по факту все они абстракные по
умолчанию и должны быть обязательно переопределены в имплементирующем интерфейс классе.
Важной особенностью интерфейса является то, что классы могут имплементировать (по сути отнаследоваться от) множество
интерфейсов.
Назначение интерфейсов это группировка и объявление некоторого множества функций и их контрактов, которые любой
имплементирующий интерфейс класс может реализовывать по своему, также интерфейс служит абстаркцией через которую
устанавливаются зависимости классов между собой (т.е. класс А который зависит от класса B, что не хорошо, может
зависеть от интерфейса C, который имплементирует класс B, что уже хорошо)
 */

/*
Все функции  интерфейсов имеющие свою реализацию по умолчанию открытые (interface PowerController),
а если они не имеют свою реализацию то абстрактные (interface VolumeController).
Функции интерфейсов имеющие собственную реализацию могут вызываться у объекта имплементирующего класса через
точку и не обязаны(fun powerOff()), но могут быть переопределены в имплементирующем классе (fun powerOn)
(внутри переопределенной функции имеющей свою реализацию в интерфейсе, свою реализацию можно вызвать через
ключевое слово super)
Интерфейс не может хранить состояния, тобишь литералы - но можно прописать литерал через getter переменной.
 */

interface PowerController {
    val off: String
        get() = "TV switched off"
    val on: String
        get() = "Телевизор включен"
    fun powerOn(){
        println("$on")
    }
    fun powerOff() {
        println("$off")
    }
}

interface VolumeController {
    fun volumeUp()
    fun volumeDown()
}

class TV : PowerController, VolumeController {
    override fun powerOn() {
        super.powerOn()
        println("TV switched on")
    }

    //  override fun powerOff() {
    //      println("TV switched off")
    //  }

    override fun volumeUp() {
        println("Volume increased")
    }

    override fun volumeDown() {
        println("Volume decreased")
    }

}
