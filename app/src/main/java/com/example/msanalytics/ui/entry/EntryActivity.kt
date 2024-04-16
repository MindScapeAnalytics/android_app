package com.example.msanalytics.ui.entry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.msanalytics.R
import dagger.hilt.android.AndroidEntryPoint

class EntryActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_entry)
    }
}