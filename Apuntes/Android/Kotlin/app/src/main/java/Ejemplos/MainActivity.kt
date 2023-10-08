package Ejemplos

import POO.Person
import POO.futbolista
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.introduccion.R

class MainActivity {class MainActivity : AppCompatActivity(){
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var angel : Person = Person("Angel", "32234233")
        var fur : futbolista = futbolista("hdwie","jbiu",3)

    }

}

}