package pro.yagupov.mvpdagger2kotlinexample.adapter

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import kotlinx.android.synthetic.main.view_news_item.view.*
import pro.yagupov.model.repository.remote.News
import pro.yagupov.mvpdagger2kotlinexample.R
import pro.yagupov.mvpdagger2kotlinexample.common.setImage
import pro.yagupov.mvpdagger2kotlinexample.common.setPassedTime

/**
 * Created by developer on 01.06.17.
 */
class NewsAdapter : RecyclerView.Adapter<NewsAdapter.ViewHolder>() {

    var news: MutableList<News> = mutableListOf()


    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent!!.context).inflate(R.layout.view_news_item, parent, false))
    }

    override fun onBindViewHolder(holder: ViewHolder?, position: Int) {
        holder!!.bind(news[position])
    }

    override fun getItemCount(): Int = news.size

    fun add(pNews: List<News>) {
        news.addAll(pNews)
        notifyDataSetChanged()
    }

    fun clean() {
        news.clear()
        notifyDataSetChanged()
    }

    class ViewHolder(view: View) : RecyclerView.ViewHolder(view), View.OnClickListener {

        override fun onClick(v: View?) {
        }

        fun bind(news: News) {
            with(news) {
                itemView.preview.setImage(image?.image1, R.drawable.meduza)

                itemView.article.text = tag.name
                itemView.title.text = title

                if (!secondTitle.isNullOrBlank()) {
                    itemView.second_title.text = secondTitle
                    itemView.second_title.visibility = View.VISIBLE
                } else {
                    itemView.second_title.visibility = View.GONE
                }


                itemView.passed_time.setPassedTime(news.publishedAt)
            }

            itemView.setOnClickListener(this)
        }
    }
}