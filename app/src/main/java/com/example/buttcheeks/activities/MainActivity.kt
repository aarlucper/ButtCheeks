package com.example.buttcheeks.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import com.example.buttcheeks.R
import com.example.buttcheeks.fragments.DiaryFragment
import com.example.buttcheeks.fragments.FoodsFragment
import com.example.buttcheeks.fragments.StatisticsFragment
import com.example.buttcheeks.interfaces.OnNavigationBtnListener
import com.google.android.material.appbar.MaterialToolbar
import com.google.android.material.navigation.NavigationView

class MainActivity : AppCompatActivity(), OnNavigationBtnListener {

    private lateinit var drawerLayout : DrawerLayout

    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Carga el fragment inicial por defecto
        loadFragment(DiaryFragment())

        //Asigna variables a los elementos del menú de navegación
        drawerLayout = findViewById<DrawerLayout>(R.id.drawer_layout)
        val navigationView = findViewById<NavigationView>(R.id.navigationView)

        //TODO: Controlar aquí la transición a los distintos fragments
        navigationView.setNavigationItemSelectedListener { menuItem ->
            menuItem.isChecked = true

            //Lógica provisional del navdrawer
            when (menuItem.itemId){
                R.id.item1 -> {
                    loadFragment(DiaryFragment())
                }
                R.id.item2 -> {
                    loadFragment(FoodsFragment())
                }
                R.id.item3 -> {
                    loadFragment(StatisticsFragment())
                }
            }

            //Ciera el menú de navegación
            drawerLayout.close()
            true
        }


    }

    private fun loadFragment(fragment: Fragment) {
        /* Transición inicial al fragmento por defecto */
        val fragmentTransaction = supportFragmentManager.beginTransaction()

        //Indica en qué elemento se incrustará qué fragment
        //TODO: Determinar si esta es la mejor implementación para cambiar entre fragmentos
        fragmentTransaction.replace(R.id.mainLayout, fragment).addToBackStack(null)

        //Realiza la operación
        fragmentTransaction.commit()
    }

    //Abre el navigation drawer al pulsar
    override fun onNavigationBtnClick(toolbar: MaterialToolbar) {
        //Abre el menú de navegación
        drawerLayout.open()
    }
}