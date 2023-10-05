package POO

//class Person { } // clase1 - ctr x defecto
//class Person() { } // clase2 - ctr x defect
//class Person(var nombre : String, var edad : Int) { } // - sin ctr x defec --> ctr param
// clase1 == clase2 != clase3


class Person (var name : String = "Antonio", var passport : String? = null, var edad : Int){
    var alive: Boolean = true
    fun die() {
        alive = false
    }
}




