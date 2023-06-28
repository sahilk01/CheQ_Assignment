package com.example.cheqassignment

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.commit
import com.example.cheqassignment.databinding.ActivityMainBinding
import com.example.cheqassignment.view.HomeFragment
import com.example.rewards.view.RewardsFragment

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this, R.layout.activity_main)
        disableIconTinting()
        manageBottomNavigation()
    }

    private fun disableIconTinting() {
        binding.bottomNav.itemIconTintList = null
    }

    private fun showFragment() {
        supportFragmentManager.commit {
            replace(R.id.mainFragmentContainer, HomeFragment())
        }
    }

    private fun manageBottomNavigation() {
        val homeFragment = HomeFragment()
        val rewardsFragment = RewardsFragment()
        supportFragmentManager.commit {
            add(R.id.mainFragmentContainer, rewardsFragment)
            add(R.id.mainFragmentContainer, homeFragment)
        }
        var activeFragment: Fragment = homeFragment
        binding.bottomNav.setOnItemSelectedListener {
            when(it.itemId) {
                R.id.home -> {
                    supportFragmentManager.commit {
                        activeFragment?.let { active ->
                            hide(active)
                        }
                        show(homeFragment)
                        activeFragment = homeFragment
                    }
                }
                R.id.rewards -> {
                    supportFragmentManager.commit {
                        activeFragment?.let { active ->
                            hide(active)
                        }
                        show(rewardsFragment)
                        activeFragment = rewardsFragment
                    }
                }
            }
            return@setOnItemSelectedListener true
        }
    }
}