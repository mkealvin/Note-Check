package com.mini.check.presentation.activity

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.mini.check.R
import com.mini.check.presentation.fragment.FragmentCreateNote
import com.mini.check.presentation.fragment.FragmentListNote

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val fragmentManager = supportFragmentManager
        fragmentManager
            .beginTransaction()
            .replace(R.id.container_create_note, FragmentCreateNote.newInstance())
            .commit()

        fragmentManager
            .beginTransaction()
            .replace(R.id.container_list_note, FragmentListNote.newInstance())
            .commit()
    }
}
// pada code ini membuat main activity yaitu membagi 2 antara activity create dan list
