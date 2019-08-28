package com.example.demo.main

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.demo.R
import com.example.demo.slave.SlaveFragment
import com.example.demo.util.showFragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    private lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Add Callback
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {

                override fun handleOnBackPressed() {
                    Toast.makeText(
                        this@MainFragment.context,
                        "[handleOnBackPressed]: ${viewModel.isHandledBackPressed}",
                        Toast.LENGTH_SHORT
                    ).show()

                    if (!viewModel.isHandledBackPressed) {
                        viewModel.isHandledBackPressed = true
                    } else {
                        isEnabled = false
                    }
                }
            })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = MainViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_main, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        go_to_button.setOnClickListener {
            requireActivity().showFragment(newInstance(), SlaveFragment.newInstance(), R.id.container)
        }
    }

    companion object {
        var instance = MainFragment()

        @JvmStatic
        fun newInstance() = instance
    }
}