package com.example.msanalytics.ui.main.event

import androidx.fragment.app.viewModels
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.msanalytics.R
import com.example.msanalytics.databinding.FragmentEventBinding
import com.example.msanalytics.databinding.FragmentEventCreateBinding

class EventCreateFragment : Fragment() {
    private val viewModel: EventCreateViewModel by viewModels()
    private lateinit var fragmentEventCreateBinding: FragmentEventCreateBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        fragmentEventCreateBinding = FragmentEventCreateBinding.inflate(layoutInflater)
        return fragmentEventCreateBinding.root
    }
}