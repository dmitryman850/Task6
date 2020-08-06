package dmitry.man.task6ted

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import coil.api.load

class FullActivity : AppCompatActivity() {

    private lateinit var imageFull: ImageView
    private lateinit var durationFull: TextView
    private lateinit var descriptionFull: TextView
    private lateinit var titleFull: TextView
    private lateinit var informationFull: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_full)
        imageFull = findViewById(R.id.image_full)
        durationFull = findViewById(R.id.text_duration)
        descriptionFull = findViewById(R.id.text_description)
        titleFull = findViewById(R.id.text_title)
        informationFull = findViewById(R.id.text_information)

        val argument = intent.extras
        imageFull.load(argument?.get("imageUrl").toString())
        durationFull.text = argument?.get("textDuration").toString()
        descriptionFull.text = argument?.get("textDescription").toString()
        titleFull.text = argument?.get("textTitle").toString()
        informationFull.text = argument?.get("textDescriptionFull").toString()
    }

    fun onClick(view: View) {
        // тут видосик должен был бы запускаться по моему замыслу)
    }
}