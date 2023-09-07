package com.example.buttcheeks

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.splashscreen.SplashScreen.Companion.installSplashScreen
import androidx.fragment.app.Fragment
import com.example.buttcheeks.fragments.DiaryFragment

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        val splashScreen = installSplashScreen()

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        val fragmentTransaction = supportFragmentManager.beginTransaction()
        //Indica en qué elemento se incrustará qué fragment
        fragmentTransaction.add(R.id.mainLayout, DiaryFragment())
        //Realiza la operación
        fragmentTransaction.commit()
    }
}