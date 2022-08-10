package wave.project.quotesapi

import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET

interface ApiInterface {

    @GET("random")
    fun getRandomQuote() : Call<RandomQuote>

    @GET("quotes")
    fun getAllQuotes() : Call<QuoteList>

    companion object {

        var base_url = "https://api.quotable.io/"

        fun create() : ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(base_url)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }

    }
}