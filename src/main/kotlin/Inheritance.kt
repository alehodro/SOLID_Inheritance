/*
Наследование - это базовая механика объектно-ориентированного программирования. Наследование позволяет создавать новые
классы путем наследования из существующих. При наследовании класс наследник получает все свойства и функции суперкласса,
при этом класс наследник может иметь свои свойства и функции, таким образом расширяя возможности суперкласса.
По умолчанию все классы kotlin имеют модификатор final, поэтому для создания наследника суперкласс должен иметь
модификатор open. Свойства и функции супер класса могут быть переопределены в классе наследнике, для этого эти члены суперкласса
должны иметь модификатор доступа open.
 */

open class Person (val name:String, val age:Int){
    init {
        println("Object Person is created")
    }
    fun sleep(){
        println("$name sleepZzzzzz")
    }
    fun eat() {
        println("$name eats")
    }
    open fun getInfo(){
        println("My name is $name, I am $age years old")
    }
}
// при наследовании в конструктор суперкласса необходимо передать параметры из конструктора класса наследника
class Employee(val position:String, val employer:String, val _name:String,val _age:Int):Person(_name,_age){
    fun work(){
        println("$name is working")
    }

    override fun getInfo() {
        // с помощью super вызываем функцию суперкласса как есть
        super.getInfo()
        println("I am working in $employer as an $position ")
    }
}

