fun main() {
    /*
    Тестируем просто наследование. Создаем инстанс класса Employee, наследника класса Person.
     */
    val employee = Employee("Engeneer", "Microsoft", "John Doe", 36)
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

    val car = Car().drive()

    /*
    Пример принципа Open Closed principle
     */

    val coffeeMaker = CoffeeMaker().cookCoffee()
    val coffeeMakerWithBeeper = CoffeeMakerWithBeeper().cookCoffee()

// Тупо таймер по фану - пусть будет
    val timer = Timer(30)

    /*
    Пример принципа Liskows substitution principle
*/

    val monitor = Monitor()
    val theWitcher = Game("The witcher 3")
    val pS4 = PS4()
    val pS4Pro = PS4Pro()
    // теперь при вызове функции монитора я могу передать в качестве аргумента 2 разных класса и все будет работать
    monitor.switchToHDMI(pS4, theWitcher)
    monitor.switchToHDMI(pS4Pro, theWitcher)

    /*
   Пример принципа Dependency inversion principle
*/
    val cezve = Cezve()
    val coffeeMaker2 = AutomaticCoffeeMaker()
    val manuallGrinder = ManuallGrinder()
    val autoGrinder = AutomaticGrinder()
    println(Coffee(manuallGrinder,coffeeMaker2).getCoffee())
    println(Coffee(autoGrinder,cezve).getCoffee())


}