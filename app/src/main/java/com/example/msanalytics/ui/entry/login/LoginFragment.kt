package com.example.msanalytics.ui.entry.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.msanalytics.databinding.FragmentLoginBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private val viewModel: LoginViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentLoginBinding.inflate(layoutInflater)
        binding.fragmentLoginSecondButton.setOnClickListener {
            viewModel.navToReg(binding.root)
        }
        binding.fragmentLoginFirstButton.setOnClickListener {
            val inputLogin = binding.fragmentLoginLogin.text.toString()
            val inputPassword = binding.fragmentLoginPassword.text.toString()
            if (inputLogin != "" && inputPassword != "") {
                viewModel.navToMain(inputLogin, inputPassword, binding.root)
            }
        }
        return binding.root
    }

}