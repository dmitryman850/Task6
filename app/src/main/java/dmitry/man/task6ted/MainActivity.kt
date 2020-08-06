package dmitry.man.task6ted

import android.content.Intent
import android.os.Bundle
import android.widget.AdapterView
import android.widget.Toast
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), OnItemClickListener {

     val itemAdapter = TedAdapter(this)

    private val tedViewModel by viewModels<TedViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView.apply {
            adapter = itemAdapter
            layoutManager = LinearLayoutManager(this@MainActivity)
        }

        tedViewModel.items.observe(this, Observer {
            it ?: return@Observer
            itemAdapter.addItems(it)
        })
    }

    override fun onItemClicked(fileName: String, description: String, durationText: String,
        imageUrl: String, descriptionFULL: String) {
        val intent = Intent(this, FullActivity::class.java)
        intent.putExtra("textTitle", fileName)
        intent.putExtra("imageUrl", imageUrl)
        intent.putExtra("textDescription", description)
        intent.putExtra("textDuration", durationText)
        intent.putExtra("textDescriptionFull", descriptionFULL)
//        intent.putExtra("textDescriptionFull", "Информация \n$descriptionFULL")
        startActivity(intent)
    }
}
