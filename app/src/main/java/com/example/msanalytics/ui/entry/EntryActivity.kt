package com.example.msanalytics.ui.entry

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.msanalytics.R
import com.example.msanalytics.databinding.ActivityEntryBinding
import com.example.msanalytics.databinding.ActivityMainBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class EntryActivity : AppCompatActivity() {
    private lateinit var entryActivityBinding: ActivityEntryBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        entryActivityBinding = ActivityEntryBinding.inflate(layoutInflater)
        setContentView(entryActivityBinding.root)
    }
}