package gst.trainingcourse.lesson6_hieunt94

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.list_author.view.*

class AuthorAdapter (private val context1: Context, private val author: List<dataSong> ) : RecyclerView.Adapter<AuthorAdapter.AuthorViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AuthorViewHolder {
        val viewAuthor = LayoutInflater.from(context1).inflate(R.layout.list_author, parent, false)
        return AuthorViewHolder(viewAuthor)
    }

    override fun getItemCount(): Int {
        return author.size
    }

    override fun onBindViewHolder(holder: AuthorViewHolder, position: Int) {
        val authorList = author[position]
        holder.setData1(authorList, position)
    }
     inner class AuthorViewHolder(itemView: View): RecyclerView.ViewHolder(itemView){
         var currentAuthor: dataSong? = null
         var currentPosition : Int = 0

         init {
            itemView.setOnClickListener{
                Toast.makeText(context1, currentAuthor!!.nameAuthor, Toast.LENGTH_SHORT).show()

            }
        }
        fun setData1(author_list: dataSong? , pos :Int){
            itemView.tvAuthor.text = author_list!!.nameAuthor


            this.currentAuthor =  author_list
            this.currentPosition = pos
        }
     }
}
