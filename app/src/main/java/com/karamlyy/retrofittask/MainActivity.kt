package com.karamlyy.retrofittask


import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.karamlyy.retrofittask.model.Results
import com.karamlyy.retrofittask.network.RetrofitClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response


class MainActivity : AppCompatActivity() {

    private val heros = mutableListOf<HerosDTO>()
    private lateinit var adapter: Adapter
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getSuperHeroes()
    }

    private fun getSuperHeroes() {
        val call: Call<List<Results>>? = RetrofitClient.instance?.getMyApi()?.getsuperHeroes()
        call?.enqueue(object : Callback<List<Results>> {

            override fun onResponse(call: Call<List<Results>>, response: Response<List<Results>>) {
                val myheroList: List<Results> = response.body() as List<Results>
                val heroes = mutableListOf<HerosDTO>()

                for (heroResult in myheroList) {
                    heroes.add(
                        HerosDTO(
                            name = heroResult.name,
                            realname = heroResult.realname,
                            team = heroResult.team,
                            firstappearance = heroResult.firstappearance,
                            createdby = heroResult.createdby,
                            publisher = heroResult.publisher,
                            bio = heroResult.bio,
                            //imageurl = heroResult.image,
                        )
                    )
                }

                val recyclerView = findViewById<RecyclerView>(R.id.myListView)
                recyclerView.layoutManager = LinearLayoutManager(applicationContext)
                recyclerView.adapter = Adapter(heroes) // Now we pass List<HerosDTO> to the adapter
            }
            override fun onFailure(call: Call<List<Results>>, t: Throwable) {
                Toast.makeText(applicationContext, "An error has occured", Toast.LENGTH_LONG).show()
            }

        })
    }
}