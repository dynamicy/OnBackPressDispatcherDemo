package com.example.demo

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import kotlinx.android.synthetic.main.fragment_main.*

class MainFragment : Fragment() {

    lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Add Callback
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                if (!isEnable1Handled()) {
                    Toast.makeText(this@MainFragment.context, "[handleOnBackPressed]: false", Toast.LENGTH_SHORT).show()
                } else {
                    isEnabled = false
                }
            }
        })

        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                if (!isEnable2Handled()) {
                    Toast.makeText(this@MainFragment.context, "[handleOnBackPressed]: false", Toast.LENGTH_SHORT).show()
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

        button1.setOnClickListener {
            handleEnable1()
            Toast.makeText(this@MainFragment.context, "[Button1]: enable", Toast.LENGTH_SHORT).show()
        }

        button2.setOnClickListener {
            handleEnable2()
            Toast.makeText(this@MainFragment.context, "[Button2]: enable", Toast.LENGTH_SHORT).show()
        }
    }

    fun isEnable1Handled(): Boolean {
        return viewModel.isEanble1
    }

    fun handleEnable1() {
        viewModel.isEanble1 = true
    }

    fun isEnable2Handled(): Boolean {
        return viewModel.isEanble2
    }

    fun handleEnable2() {
        viewModel.isEanble2 = true
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
