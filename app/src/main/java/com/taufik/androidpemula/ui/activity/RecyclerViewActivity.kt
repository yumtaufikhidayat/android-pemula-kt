package com.taufik.androidpemula.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.androidpemula.R
import com.taufik.androidpemula.data.Hero
import com.taufik.androidpemula.data.HeroesData
import com.taufik.androidpemula.databinding.ActivityRecyclerViewBinding
import com.taufik.androidpemula.ui.adapter.GridHeroAdapter
import com.taufik.androidpemula.ui.adapter.ListHeroAdapter

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var listHeroAdapter: ListHeroAdapter
    private lateinit var gridHeroAdapter: GridHeroAdapter
    private var listHero: ArrayList<Hero> = arrayListOf()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        showData()
    }

    private fun showData() {
        listHero.addAll(HeroesData.listData)
        showRecyclerList()
        showRecyclerGrid()
    }

    private fun showRecyclerList() {
        listHeroAdapter = ListHeroAdapter(listHero)
        binding.apply {
            with(rvHero) {
                layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
                rvHero.adapter = listHeroAdapter
            }
        }
    }

    private fun showRecyclerGrid() {
        gridHeroAdapter = GridHeroAdapter(listHero)
        binding.apply {
            with(rvHero) {
                layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)
                rvHero.adapter = gridHeroAdapter
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
            R.id.action_list -> showRecyclerList()
            R.id.action_grid -> showRecyclerGrid()
            R.id.action_cardview -> {
                //TODO: to action cardview
            }
        }
    }
}