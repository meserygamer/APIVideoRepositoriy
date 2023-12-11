package com.example.apivideo.APIUsing

import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.JsonObject
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.Header
import retrofit2.http.Query

data class News(
    var id : Int,
    var name : String?,
    var description : String?,
    var price : Int,
    var image : String?
)

interface APIInterface
{
    @GET("api/News")
    fun GetNews() : Call<MutableList<News>>
}

public object RetrofitConnection
{
    fun getRetrofit() : APIInterface
    {
       return Retrofit.Builder()
           .baseUrl("https://iis.ngknn.ru/NGKNN/%D0%9C%D0%B0%D0%BC%D1%88%D0%B5%D0%B2%D0%B0%D0%AE%D0%A1/MedicMadlab/")
           .addConverterFactory(GsonConverterFactory.create(GsonBuilder().setLenient().create()))
           .build()
           .create(APIInterface::class.java)
    }
}

/*
public object RetrofitConnection
{
    var Base_URL = "https://iis.ngknn.ru/NGKNN/%D0%9C%D0%B0%D0%BC%D1%88%D0%B5%D0%B2%D0%B0%D0%AE%D0%A1/MedicMadlab/"

    var gson : Gson = GsonBuilder().setLenient().create()

    private var connection : Retrofit? = null

    fun getRetrofit() : Retrofit
    {
        if(connection == null)
        {
            connection = Retrofit.Builder()
                    .baseUrl(Base_URL).addConverterFactory(GsonConverterFactory
                    .create(gson)).build()
            return connection!!;
        }
        return connection!!
    }
}

public object RetrofitInterface
{
    fun getRetrofit(retrofitConnection : Retrofit) : APIInterface
    {
        return retrofitConnection.create(APIInterface::class.java)
    }
}*/