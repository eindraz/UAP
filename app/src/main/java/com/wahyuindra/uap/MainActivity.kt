package com.wahyuindra.uap

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentManager

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        tampilMahasiswaFragment()
    }

    private fun gantiFragment(
        fragmentManager: FragmentManager,
        fragment: Fragment, frameId: Int
    ) {
        val transaction = fragmentManager.beginTransaction()
        transaction.replace(frameId, fragment)

        transaction.commit()
    }

    fun tampilMahasiswaFragment() {
        gantiFragment(supportFragmentManager, MahasiswaFragment.newInstance(), R.id.contentFrame)
    }

    fun tampilMahasiswaAddFragment() {
        gantiFragment(supportFragmentManager, MahasiswaAddFragment.newInstance(), R.id.contentFrame)
    }

}