package com.example.msanalytics.ui.entry.reg

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import com.example.msanalytics.databinding.FragmentRegBinding
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class RegFragment : Fragment() {

    private val viewModel: RegViewModel by viewModels()
    private lateinit var binding: FragmentRegBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentRegBinding.inflate(layoutInflater)
        val inputLogin = binding.fragmentRegLogin.text.toString()
        val inputEmail = binding.fragmentRegEmail.text.toString()
        val inputPassword = binding.fragmentRegPassword.text.toString()
        binding.fragmentRegFirstButton.setOnClickListener() {
            if (inputPassword != "" && (inputEmail != "" || inputLogin != "")) {
                viewModel.registration(
                    inputLogin, inputEmail, inputPassword, binding.root
                )
            }
        }
        return binding.root
    }
}