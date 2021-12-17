package com.taufik.androidpemula

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.androidpemula.databinding.ActivityRecyclerViewBinding

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var heroAdapter: HeroAdapter
    private var listHero: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setDataHero()
    }

    private fun setDataHero() {
        listHero.addAll(HeroesData.listData)
        heroAdapter = HeroAdapter(listHero)
        binding.apply {
            with(rvHero) {
                layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
                rvHero.adapter = heroAdapter
            }
        }
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode) {
            R.id.action_list -> {
                //TODO: to action list
            }

            R.id.action_grid -> {
                //TODO: to action grid
            }

            R.id.action_cardview -> {
                //TODO: to action cardview
            }
        }
    }
}