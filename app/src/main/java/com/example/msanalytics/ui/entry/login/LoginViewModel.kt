package com.example.msanalytics.ui.entry.login

import android.view.View
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.navigation.findNavController
import com.example.msanalytics.R
import com.example.msanalytics.data.api.repository.AccountRepository
import com.example.msanalytics.data.api.retrofit.backend.models.BackendAccountModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class LoginViewModel: ViewModel() {
    @Inject
    lateinit var accountRepository: AccountRepository
    private lateinit var accountModel: BackendAccountModel
    fun navToReg(v: View) {
        v.findNavController().navigate(R.id.regFragment)
    }

    fun navToMain(login: String, password: String, v: View
    ): Boolean {
        accountModel = if (android.util.Patterns.EMAIL_ADDRESS.matcher(login).matches()) {
            BackendAccountModel(
                login, "", password,
            )
        } else {
            BackendAccountModel(
                "" ,login, password,
            )
        }
        viewModelScope.launch {
            val response = accountRepository.getToken(accountModel)
            if (response.code() != 400) {
                v.findNavController().navigate(R.id.mainActivity)
            }
        }
        return true
    }
}