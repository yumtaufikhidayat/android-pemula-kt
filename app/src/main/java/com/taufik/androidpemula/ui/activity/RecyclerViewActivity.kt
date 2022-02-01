package com.taufik.androidpemula.ui.activity

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import com.taufik.androidpemula.R
import com.taufik.androidpemula.data.Hero
import com.taufik.androidpemula.data.HeroesData
import com.taufik.androidpemula.databinding.ActivityRecyclerViewBinding
import com.taufik.androidpemula.ui.adapter.CardViewHeroAdapter
import com.taufik.androidpemula.ui.adapter.GridHeroAdapter
import com.taufik.androidpemula.ui.adapter.ListHeroAdapter
import com.taufik.androidpemula.ui.helper.OnItemClickCallback

class RecyclerViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityRecyclerViewBinding
    private lateinit var listHeroAdapter: ListHeroAdapter
    private lateinit var gridHeroAdapter: GridHeroAdapter
    private lateinit var cardViewHeroAdapter: CardViewHeroAdapter
    private var listHero: ArrayList<Hero> = arrayListOf()
    private var titleText: String = "Mode CardView"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityRecyclerViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setActionBarTitle(titleText)
        showData()
    }

    private fun showData() {
        listHero.addAll(HeroesData.listData)
        showRecyclerList()
        showRecyclerGrid()
        showRecyclerCardView()
    }

    private fun showRecyclerList() {
        listHeroAdapter = ListHeroAdapter(listHero)
        binding.apply {
            with(rvHero) {
                layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
                adapter = listHeroAdapter
            }
        }

        listHeroAdapter.setOnItemClickCallback(object: OnItemClickCallback {
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerGrid() {
        gridHeroAdapter = GridHeroAdapter(listHero)
        binding.apply {
            with(rvHero) {
                layoutManager = GridLayoutManager(this@RecyclerViewActivity, 2)
                adapter = gridHeroAdapter
            }
        }

        gridHeroAdapter.setOnItemClickCallback(object: OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showRecyclerCardView() {
        cardViewHeroAdapter = CardViewHeroAdapter(listHero)
        binding.apply {
            with(rvHero) {
                layoutManager = LinearLayoutManager(this@RecyclerViewActivity)
                adapter = cardViewHeroAdapter
            }
        }

        cardViewHeroAdapter.setOnItemClickCallback(object: OnItemClickCallback{
            override fun onItemClicked(data: Hero) {
                showSelectedHero(data)
            }
        })
    }

    private fun showSelectedHero(hero: Hero) {
        Toast.makeText(this, "Kamu memilih ${hero.name}", Toast.LENGTH_SHORT).show()
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setActionBarTitle(title: String) {
        supportActionBar?.title = title
    }

    private fun setMode(selectedMode: Int) {
        when(selectedMode) {
            R.id.action_list -> {
                title = "Mode List"
                showRecyclerList()
            }

            R.id.action_grid -> {
                title = "Mode Grid"
                showRecyclerGrid()
            }

            R.id.action_cardview -> {
                title = "Mode CardView"
                showRecyclerCardView()
            }
        }

        setActionBarTitle(titleText)
    }
}