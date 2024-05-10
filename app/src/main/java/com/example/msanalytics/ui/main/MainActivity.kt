package com.example.msanalytics.ui.main

import android.os.Bundle
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.findNavController
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.setupWithNavController
import com.example.msanalytics.R
import com.example.msanalytics.databinding.ActivityMainBinding
import com.example.msanalytics.ui.main.event.EventCreateFragment
import com.example.msanalytics.ui.main.profile.ProfileFragment
import com.example.msanalytics.ui.main.swipeable_feed.SwipeableFeedFragment
import com.google.android.material.bottomnavigation.BottomNavigationView
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : AppCompatActivity() {
    private lateinit var activityMainBinding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        activityMainBinding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(activityMainBinding.root)

        val navController = (supportFragmentManager.findFragmentById(R.id.activity_main__nav_host_fragment)
                as NavHostFragment).navController
        activityMainBinding.activityMainBottomNav.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            if(destination.id == R.id.eventFragment) {
                activityMainBinding.activityMainBottomNav.visibility = View.GONE
            } else {
                activityMainBinding.activityMainBottomNav.visibility = View.VISIBLE
            }
        }
    }
}
