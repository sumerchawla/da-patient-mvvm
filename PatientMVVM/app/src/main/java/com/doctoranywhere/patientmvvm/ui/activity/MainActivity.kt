package com.doctoranywhere.patientmvvm.ui.activity

import android.os.Bundle
import com.doctoranywhere.patientmvvm.R
import androidx.navigation.NavController
import androidx.navigation.Navigation
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.NavigationUI
import com.doctoranywhere.patientmvvm.databinding.ActivityMainBinding
import com.doctoranywhere.patientmvvm.ui.base.BaseActivity

import java.util.HashSet

class MainActivity : BaseActivity<ActivityMainBinding>(),
    AppBarConfiguration.OnNavigateUpListener  {
    private var navController: NavController? = null
    private var appBarConfiguration: AppBarConfiguration? = null
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        initializeView()
    }


    override fun getLayoutId(): Int{
        return R.layout.activity_main;
    }
    private fun initializeView() {
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)
        setupNavigation()
    }


    private fun setupNavigation() {
        setSupportActionBar(getActivityDataBinding().toolbar)
        val topLevelDestinations = HashSet<Int>()
        //setting Dashboard as Top Level in Backstack
        topLevelDestinations.add(R.id.loginFragment)
        appBarConfiguration = AppBarConfiguration.Builder(topLevelDestinations)
            .setFallbackOnNavigateUpListener(this)
            .build()

        navController?.let {
            NavigationUI.setupActionBarWithNavController(this,
                it, appBarConfiguration!!
            )
        }
        //wiring up click event wrt bottom navigation view with navigation action
        /* bottomNavigation.setupWithNavController(navController!!)
        navController?.let {
            NavigationUI.setupWithNavController(
                getActivityDataBinding().cdtoolbarLayout.toolbar,
                it,
                appBarConfiguration!!
            )
        }*/
        //Binding toolbar title based on Label in Navigation View
        navController!!.addOnDestinationChangedListener { controller, destination, arguments ->
            getActivityDataBinding().toolbar.title = controller.currentDestination!!.label!!.toString()
        }
    }

    override fun onSupportNavigateUp(): Boolean {
        return navController?.let {
            appBarConfiguration?.let { it1 ->
                NavigationUI.navigateUp(
                    it,
                    it1
                )
            }
        }!! || super.onSupportNavigateUp()
    }

}