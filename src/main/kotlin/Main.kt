fun main(){
    /*
    Тестируем просто наследование. Создаем инстанс класса Employee, наследника класса Person.
     */
    val employee = Employee("Engeneer","Microsoft","John Doe",36)
    // вызываем функцию getInfo() класса Employee, переопределенную из суперкласса Person
    employee.getInfo()
    // Вызываем функции суперкласса
    employee.sleep()
    employee.eat()
    employee.work()

    /*
    Тестируем интерфейсы.
    Класс TV имплементирует 2 интерфейса и переопределяет все функции в этих интерфейсах
     */

    val tv = TV()
    tv.powerOn()
    tv.volumeUp()
    tv.volumeDown()
    tv.powerOff()

    /*
    Пример принципа Single responsibility principle
     */

    val car=Car().drive()

    /*
    Пример принципа Open Closed principle
     */

    val coffeeMaker=CoffeeMaker().cookCoffee()
    val coffeeMakerWithBeeper=CoffeeMakerWithBeeper().cookCoffee()

}