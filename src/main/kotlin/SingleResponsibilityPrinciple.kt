/*
S- single responsibility principle (принцип единственной отвественности)
Не должно быть более одной причины для изменения класса, под причиной в целом понимается необходимость изменения только
одной базовой функции, которую выполняет класс. Суть в том, что при проектировании решения классы дробить так, чтобы каждый выполнял
свою основную функцию, это позволит гибко реконфигугировать общую архитектуру, избежать излишних зависимостей в жирных
классах*/

/*
В примере ниже главной отвественностью машины является поездка, т.е. причиной изменения класса Car может быть
только изменение логики функции drive(), однако в данной реализации причиной изменени класса может быть также
изменения типа двигателя (по умолчанию бензиновый, а может быть электрический) и/или изменение типа
 трансмиссии (по умолчанию механика, а может быть автомат).
 */

/*
class Car() {
    init {
        println("Car is created")
    }
    fun drive() {
        if (startEngine()&&getIntoGear())
            println("The car drives into a sunset")
    }

    private fun startEngine(): Boolean {
        class Engine() {
            fun start(): Boolean {
                println("Engine started")
                return true

            }
        }
        return Engine().start()
    }

    private fun getIntoGear():Boolean {
        class Transmission() {
            fun getIntoGear():Boolean {
                println("Got into 1 st gear")
                return true
            }
        }
        return Transmission().getIntoGear()
    }
}

*/

// Выносим класс Engine из тела класса Car и делаем его электрическим
class Engine() {
    fun start(): Boolean {
        println("Engine turned on")
        return true

    }
}

// Выносим класс Transmission из тела класса Car и делаем ее автоматической
class Transmission() {
    fun getIntoGear(): Boolean {
        println("Got into Drive mode")
        return true
    }
}

class Car() {
    init {
        println("Car is created")
    }

    fun drive() {
        if (startEngine() && getIntoGear())
            println("The car drives into a sunset")
    }

    private fun startEngine(): Boolean {
        return Engine().start()
    }

    private fun getIntoGear(): Boolean {

        return Transmission().getIntoGear()
    }
}

/*
Суть исполнения принципа в этом примере в том, что если изменится какая-то логика работы двигателя или коробки передач
мне не нужно для этого править класс Car, мне нужно поправить классы Engine и Transmission.
Если для выполнения основной функции класса Car понадобиться что-то еще, например, чтобы поехать  обязательно нужно
пристегнуться, я создам новый класс SeatBelts c функцией fasten(), добавлю функцию для пристегивания ремня в
класс Car и внесу изменения в условия в функции drive()
 */