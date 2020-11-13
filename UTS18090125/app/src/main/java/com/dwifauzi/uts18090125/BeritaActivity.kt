package com.dwifauzi.uts18090125

import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.widget.Toast
import android.os.PersistableBundle
import android.util.Log
import android.view.ActionMode
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.LinearLayoutManager
import kotlinx.android.synthetic.main.activity_berita.*


class BeritaActivity : AppCompatActivity() {

    private val list = ArrayList<Berita>()
    private var title = "Mode List"
    private var mode: Int = 0

    companion object{
        private const val STATE_TITLE = "state_string"
        private const val STATE_LIST = "state_list"
        private const val STATE_MODE = "state_mode"
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_berita)

        rv_berita.setHasFixedSize(true)

        // ORIENTATION SET
        if(savedInstanceState == null){
            setActionBarTitle(title)
            list.addAll(getListBerita())
            showRecyclerList()
            setActionBarTitle(title)
        }else{
            title = savedInstanceState.getString(STATE_TITLE).toString()
            val stateList = savedInstanceState.getParcelableArrayList<Berita>(STATE_LIST)
            val stateMode = savedInstanceState.getInt(STATE_MODE)

            setActionBarTitle(title)
            if(stateList != null){
                list.addAll(stateList)
            }
            setMode(stateMode)
        }


    }

    fun getListBerita(): ArrayList<Berita>{
        val dataName = resources.getStringArray(R.array.data_name)
        val dataDescription = resources.getStringArray(R.array.data_description)
        val dataPhoto = resources.getStringArray(R.array.data_photo)

        val listBerita = ArrayList<Berita>()
        for(position in dataName.indices){
            val Berita = Berita(
                dataName[position],
                dataDescription[position],
                dataPhoto[position]
            )
            listBerita.add(Berita)
        }
        return listBerita
    }

    override fun onSaveInstanceState(outState: Bundle) {
        super.onSaveInstanceState(outState)
        outState.putString(STATE_TITLE, title)
        outState.putParcelableArrayList(STATE_LIST, list)
        outState.putInt(STATE_MODE, mode)
    }

    private fun showRecyclerList(){
        rv_berita.layoutManager = LinearLayoutManager(this)
        val listBeritaAdapter = ListBeritaAdapter(list)
        rv_berita.adapter = listBeritaAdapter

        listBeritaAdapter.setOnItemClickCallback(object : ListBeritaAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Berita) {
                showSelectedBerita(data)
            }
        })
    }

    private fun showRecyclerGrid(){
        rv_berita.layoutManager = GridLayoutManager(this, 2)
        val gridBeritaAdapter = GridBeritaAdapter(list)
        rv_berita.adapter = gridBeritaAdapter

        gridBeritaAdapter.setOnItemClickCallback(object : GridBeritaAdapter.OnItemClickCallback{
            override fun onItemClicked(data: Berita) {
                showSelectedBerita(data)
            }
        })
    }

    private fun showRecyclerCardView(){
        rv_berita.layoutManager = LinearLayoutManager(this)
        val cardViewBeritaAdapter = CardViewBeritaAdapter(list)
        rv_berita.adapter = cardViewBeritaAdapter
    }

    private fun setActionBarTitle(title: String?){
        supportActionBar?.title = title
    }

    private fun showSelectedBerita(berita: Berita){
        Toast.makeText(this, "Kamu memilih ${berita.name}", Toast.LENGTH_SHORT).show()
    }


    // MENU OPTIONS
    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.menu_main, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        setMode(item.itemId)
        return super.onOptionsItemSelected(item)
    }

    private fun setMode(selectedMode: Int){
        when(selectedMode){
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
        mode = selectedMode
        setActionBarTitle(title)
    }
}