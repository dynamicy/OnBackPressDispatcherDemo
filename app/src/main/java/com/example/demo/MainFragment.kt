package com.example.demo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Add Callback
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                if (!isEnableHandled()) {
                    Toast.makeText(this@MainFragment.context, "[handleOnBackPressed]: false", Toast.LENGTH_SHORT).show()
                    handleEnable()
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

    fun isEnableHandled(): Boolean {
        return viewModel.isEanble
    }

    fun handleEnable() {
        viewModel.isEanble = true
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
