package io.adev.itpark.view

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import io.adev.itpark.R
import kotlinx.android.synthetic.main.item_news.view.*

//generics можно почитать этот раздел
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.Holder>(){//создали класс адаптер для натсройки адаптера (правил)

    var mData: List<NewsActivity.New> = emptyList()

    fun setData(data: List<NewsActivity.New>){//заполняем данными которые передаём

        mData = data
        notifyDataSetChanged()//обновили данные в полях
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {//заполняем содержимым

        val new = mData[position]

        holder.title.text = new.title
        holder.text.text = new.text

        Glide.with(holder.itemView.context)
                .load(new.image)
                .into(holder.image)
    }


    override fun getItemCount(): Int {//возвращает количество эл-ов в списке
        return mData.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {//создаёт ячейку
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_news, parent, false)
        return Holder(view)
    }

    class Holder(view: View) : RecyclerView.ViewHolder(view) {
        val title: TextView = view.title
        val text: TextView = view.text
        val image: ImageView = view.image
    }

}