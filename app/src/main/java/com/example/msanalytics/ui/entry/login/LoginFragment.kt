package com.example.msanalytics.ui.entry.login

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.msanalytics.R
import com.example.msanalytics.databinding.FragmentLoginBinding
import com.example.passagge.ui.entry.login.LoginViewModel

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
            val email = binding.fragmentLoginEmail.text.toString()
            val password = binding.fragmentLoginPassword.text.toString()
            /*if (email != "" && password != "") {
                viewModel.signInUser(
                    email,
                    password,
                    binding.root
                )
            }
            */
            findNavController().navigate(R.id.mainActivity)
        }
        return binding.root
    }

}