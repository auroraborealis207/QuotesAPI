package wave.project.quotesapi

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView


class RecyclerAdapter(val context: Context) : RecyclerView.Adapter<RecyclerAdapter.MyViewHolder>() {

    var Quotes : List<RandomQuote> = listOf()
    var key = ""


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.adapter_recycler,parent,false)
        return MyViewHolder(view)
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        Log.e("MyActivity","Second Message")
        holder.author.text = Quotes.get(position).author
        holder.content.text = Quotes.get(position).content
    }

    override fun getItemCount(): Int {
        return Quotes.size
    }

    fun setQuote(rQuote: RandomQuote){
        this.Quotes = listOf(rQuote);
        this.key = "Random"
    }

    fun setQuoteList(rQuote: QuoteList){
        this.Quotes = rQuote.results
        this.key = "Quotes"
        notifyDataSetChanged()
    }

    class MyViewHolder(itemView : View) : RecyclerView.ViewHolder(itemView) {
        val content: TextView = itemView!!.findViewById(R.id.textView1)
        val author: TextView = itemView!!.findViewById(R.id.textView2)
    }
}