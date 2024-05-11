package com.example.msanalytics.ui.entry.reg

import android.view.View
import androidx.lifecycle.MutableLiveData
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
class RegViewModel @Inject constructor(
    private val accountRepository: AccountRepository
): ViewModel() {
    private lateinit var accountModel: BackendAccountModel

    fun registration(
        login: String, email: String, password: String, v: View
    ): Boolean {
        accountModel = BackendAccountModel(
            login, email, password
        )
        viewModelScope.launch {
            val response = accountRepository.createAccount(accountModel)
            if (response.isSuccessful) {
                v.findNavController().navigate(R.id.testingFragment)
            }
        }
        return (true)
    }
}