package com.example.bottonappbar

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import android.view.View
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.ui.NavigationUI
import androidx.navigation.ui.setupWithNavController
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), View.OnClickListener {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val navController = findNavController(R.id.fragment)

        // Set up ActionBar
        setSupportActionBar(bottomAppBar)

        click()
    }

    private fun click() {

        floatingActionButton.setOnClickListener(this)

    }

    override fun onClick(view: View) {

        when(view.id) {

            R.id.floatingActionButton -> Navigation.findNavController(this, R.id.fragment).navigate(R.id.test1Fragment)


        }

    }

    override fun onCreateOptionsMenu(menu: Menu): Boolean {
        val inflater = menuInflater
        inflater.inflate(R.menu.bottomappbar_menu, menu)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        return when (item.itemId) {
            R.id.app_bar_fav -> {
                Navigation.findNavController(this, R.id.fragment).navigate(R.id.listFragment)
                return true
            }

            R.id.app_bar_search -> {
                Navigation.findNavController(this, R.id.fragment).navigate(R.id.test2Fragment)
                return true
            }
            else -> super.onOptionsItemSelected(item)
        }
    }

}
