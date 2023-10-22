package POO

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.introduccion.R

//class Person { } // clase1 - ctr x defecto
//class Person() { } // clase2 - ctr x defect
//class Person(var nombre : String, var edad : Int) { } // - sin ctr x defec --> ctr param
// clase1 == clase2 != clase3


open class Person (var name : String = "Antonio", var passport : String? = null){
    fun setName(name: String){this.name = name}
    open fun andar (){ // open para que pueda sobreescribirla
        println("esta andando")
    }
    open fun patada(){
        println("dar patada")
    }
}
class Futbolista(name: String, passport: String?, var dorsal : Int) : Person (name, passport) {
    fun velocidad(name: String, dorsal: Int) {
        this.name = name
    }
    override fun andar(){ //override para que me deje sobreescribir
        println("esta corriendo")
    }

    override fun patada(){
        super.patada()
        print("....al balon")
    }
}


