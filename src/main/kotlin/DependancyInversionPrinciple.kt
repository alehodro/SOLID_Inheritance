/*
Принцип инверсии зависимостей (Dependency inversion principle - DIP) - состоит в подходе к проектированию зависимостей
в системе, а именно в использовании прослойки из абстракций для взаимодействия между программными модулями или классами.
Классы/модули не должны зависеть от деталей реализации друг-друга , вместо этого при
взаимодействии классы/модули должны зависеть от абстракций которые они разделяют, тоесть конкретная реализация должна
зависеть от абстракций, а не наоборот.
 */

/*Суть в том, чтобы класс/модуль уровнем выше не зависел от конкретной реализации классов/модулей уровнем ниже,
* которые он использует. Классы/модули должны быть максимально автономными и соединяться с помощью абстракций.
*  Например,
* class ManuallGrinder() {
     fun grind(): Boolean {
        println("Coffee grinded manually")
        return true
    }
}

class CoffeeMaker() {
     fun cookCoffee(): Boolean {
        println("Coffee cooked in coffee maker")
        return true
    }
}

class Coffee(grinder: ManuallGrinder, cofeeCooker: CoffeeMaker) {
    val grindedCoffee = grinder.grind()
    val cookedCoffee = cofeeCooker.cookCoffee()
    fun getCoffee(): String {
        val coffee = if (grindedCoffee && cookedCoffee) "Cup of coffee" else "No coffee"
        return coffee
    }
*
*
* Класс Coffee возвращает чашку кофе и зависит от конкретных классов ManuallGrinder и Coffee maker, если бы мне
* понадобилось добавить возможность молоть кофе автоматически и варить его в турке  мне бы
* пришлось создать новые классы AutomaticGrinder и Cezve и менять класс Coffee, добавляя зависимости через параметры
* (т.е. добавить параметры AutomaticGrinder:automaticGrinder и Cezve:Cezve ) и добавить логику в самом классе, чтобы
* проверять какие параметры передали, и дергать методы переданных в параметрах классов.
*
* class Coffee(
*        manuallGrinder: ManuallGrinder?,
*        cofeeCooker: CoffeeMaker?,
*        automaticGrinder:AutomaticGrinder?,
*        cezve:Cezve?) {
*     DO SOME STUFF...
* }
*

* Вместо этого я создаю абстракции (интерфейсы) кофемолка (Grinder) и устройство варки кофе (CoffeeCooker), которые
* содержат абстрактные функции grind(молоть) и варить кофе (cookCoffee), определяющие контракты. Теперь зависимости
* между классами разного уровня можно устанавливать через эти абстракции. Теперь я могу передать интерфейсы
* в класс Coffee уровнем выше как параметры, в то же время теперь я могу создавать множество классов уровнем ниже,
* имплементируя созданные интерфейсы, что теперь позволяет передавать любой класс имплементирующий эти интерфейсы в
* качестве параметров в функцию класса высшего уровня Coffee.
*
*  val cezve = Cezve()
   val coffeeMaker = CoffeeMaker()
   val manuallGrinder = ManuallGrinder()
   val autoGrinder = AutomaticGrinder()
   Coffee(manuallGrinder,coffeeMaker).getCoffee()
   Coffee(autoGrinder,cezve).getCoffee()
*
*  Тем самым класс Coffee не нужно менять при изменении
*  классов уровнем ниже, которые он использует
*
*   */
interface Grinder {
    fun grind(): Boolean
}

interface CoffeeCooker {
    fun cookCoffee(): Boolean
}

class AutomaticGrinder() : Grinder {
    override fun grind(): Boolean {
        println("Coffee grinded automatically")
        return true
    }
}

class ManuallGrinder() : Grinder {
    override fun grind(): Boolean {
        println("Coffee grinded manually")
        return true
    }
}

class AutomaticCoffeeMaker() : CoffeeCooker {
    override fun cookCoffee(): Boolean {
        println("Coffee cooked in coffee maker")
        return true
    }
}

class Cezve() : CoffeeCooker {
    override fun cookCoffee(): Boolean {
        println("Coffee cooked in сezve")
        return true
    }
}

class Coffee(grinder: Grinder, cofeeCooker: CoffeeCooker) {
    val grindedCoffee = grinder.grind()
    val cookedCoffee = cofeeCooker.cookCoffee()
    fun getCoffee(): String {
        val coffee = if (grindedCoffee && cookedCoffee) "Cup of coffee" else "No coffee"
        return coffee
    }
}