package com.example.passagge.ui.entry.login

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.navigation.findNavController
import com.example.msanalytics.R

class LoginViewModel: ViewModel() {

    fun navToReg(v: View) {
        v.findNavController().navigate(R.id.regFragment)
    }

    fun navToMain(v: View) {
        v.findNavController().navigate(R.id.mainActivity)
    }

    fun signIn(
        email: String, password: String, v: View
    ): Boolean {
        return true
    }
}