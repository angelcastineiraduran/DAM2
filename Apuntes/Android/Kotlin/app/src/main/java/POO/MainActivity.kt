package POO

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.introduccion.R

class MainActivity : AppCompatActivity(){
    override fun onCreate (savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var angel : Person = Person("Angel", "32234233")
    }

}