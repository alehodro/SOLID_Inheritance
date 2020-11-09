/*
Принцип разделения интефейсов (Interface segregation principle) состоит в том, чтобы дробить крупные интерфейсы на
более мелкие, выделяя в них только специфичные функции. В одном предложении классы не должны реализовывать методы
которые им не нужны.
 */

/*
Ниже представлен пример нарушения принципа ISP, потому что класс Пингвин вынужден реализовывать функцию, которая ему не
нужна. Пингвины не летают, некоторые птицы не умеют плавать.

interface Bird{
    fun walk()
    fun fly()
    fun sleep()
    fun swim()
}

class Penguin:Bird{
    override fun walk() {
         println("Penguin is walking")
    }

    override fun fly() {
        println("N/A")
    }

    override fun sleep() {
        println("Penguin is sleeping")
    }

    override fun swim() {
        println("Penguin is swimming")
    }

}


Интерфейсы нужно разбить на более мелкие и специфичные.

*/

interface Bird{
    fun walk()
    fun sleep()
}

interface FlyingBird{
    fun fly()
}

interface SwimmingBird{
    fun swim()
}

class Penguin:SwimmingBird,Bird{
    override fun swim() {
        println("Penguin is swimming")
    }

    override fun walk() {
        println("Penguin is walking")
    }

    override fun sleep() {
        println("Penguin is sleeping")
    }

}