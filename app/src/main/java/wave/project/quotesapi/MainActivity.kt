package wave.project.quotesapi

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    lateinit var recyclerView: RecyclerView
    lateinit var recyclerAdapter: RecyclerAdapter

    var key = "Quotes"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        recyclerView = findViewById(R.id.recyclerview)
        recyclerAdapter = RecyclerAdapter(this)
        recyclerView.layoutManager = LinearLayoutManager(this,LinearLayoutManager.VERTICAL,false)
        recyclerView.adapter = recyclerAdapter
        val toast = Toast.makeText(this@MainActivity,"Text received",Toast.LENGTH_SHORT)




        //apiInterface.enqueue( Callback<List<Movie>>())

        if (key == "Random") {
            val apiInterface = ApiInterface.create().getRandomQuote()

            apiInterface.enqueue(object : Callback<RandomQuote> {
                override fun onResponse(
                    call: Call<RandomQuote>?,
                    response: Response<RandomQuote>?
                ) {
                    if (response?.body() != null)
                        recyclerAdapter.setQuote(response.body()!!)
                }

                override fun onFailure(call: Call<RandomQuote>, t: Throwable) {

                }
            })
        }else if (key == "Quotes"){
            val apiInterface = ApiInterface.create().getAllQuotes()

            apiInterface.enqueue( object : Callback<QuoteList> {
                override fun onResponse(
                    call: Call<QuoteList>?,
                    response: Response<QuoteList>?
                ) {
                    if (response?.body() != null)
                        recyclerAdapter.setQuoteList(response.body()!!)
                }

                override fun onFailure(call: Call<QuoteList>, t: Throwable) {

                }
            })
        }

    }
}