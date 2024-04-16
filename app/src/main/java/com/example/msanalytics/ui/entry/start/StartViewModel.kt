package com.example.msanalytics.ui.entry.start

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.msanalytics.R

class StartViewModel: ViewModel() {
    fun navToLogin(v: View) {
        v.findNavController().navigate(R.id.loginFragment)
    }
}