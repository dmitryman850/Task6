package dmitry.man.task6ted

import android.content.Context
import android.content.res.AssetManager
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import coil.api.load

class TedAdapter(val itemClickListener: OnItemClickListener) : RecyclerView.Adapter<TedViewHolder>() {

    private lateinit var context: Context

    val items = mutableListOf<TedVideo>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): TedViewHolder {
        context = parent.context
        val view = LayoutInflater.from(parent.context).inflate(R.layout.layout_item, null)
        return TedViewHolder(view)
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: TedViewHolder, position: Int) {
        val fileName = items[position].title ?: "" // -> get(position)
        val imageUrl = items[position].imageUrl ?: ""
        val durationText = items[position].durationText ?: ""
        val description = items[position].description ?: ""
        val descriptionFull = items[position].descriptionFull ?: ""
        holder.bind(fileName, imageUrl, durationText, description, descriptionFull, itemClickListener)
    }

    fun addItems(newItems: List<TedVideo>) {
        items.addAll(newItems)
        notifyDataSetChanged()
    }
}

class TedViewHolder(view: View) : RecyclerView.ViewHolder(view) {

    private val textTitle = view.findViewById<TextView>(R.id.text_title)
    private val imageView = view.findViewById<ImageView>(R.id.video_imageView)
    private val textDescription = view.findViewById<TextView>(R.id.text_description)
    private val textDuration = view.findViewById<TextView>(R.id.text_duration)
    private lateinit var descriptionFull: TextView

    fun bind(filmName: String, imageUrl: String, durationText: String, description: String, descriptionFull: String,
    clickListener: OnItemClickListener) {
        textTitle.text = filmName
        textDescription.text = description
        textDuration.text = durationText
        imageView.load(imageUrl)
        val descriptionFull = descriptionFull


        itemView.setOnClickListener {
            clickListener.onItemClicked(filmName, description, durationText, imageUrl, descriptionFull)
        }
    }
}
interface OnItemClickListener{
    fun onItemClicked(fileName: String, description: String, durationText: String,
    imageUrl: String, descriptionFull: String)
}