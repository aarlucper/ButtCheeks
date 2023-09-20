package com.example.buttcheeks.interfaces

import com.google.android.material.appbar.MaterialToolbar


interface OnNavigationBtnListener {
    //Callback para controlar el uso del botón de navegación de las
    //barras de los fragmentos desde la actividad raíz
    fun onNavigationBtnClick(toolbar: MaterialToolbar)
}