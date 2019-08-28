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

    private lateinit var viewModel: MainViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Add Callback
        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {

                override fun handleOnBackPressed() {
                    if (!viewModel.isEanble1) {
                        Toast.makeText(
                            this@MainFragment.context,
                            "[handleOnBackPressed]: false",
                            Toast.LENGTH_SHORT
                        ).show()
                        isEnabled = false
                    }
                }
            })

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {

                override fun handleOnBackPressed() {
                    if (!viewModel.isEanble2) {
                        Toast.makeText(
                            this@MainFragment.context,
                            "[handleOnBackPressed]: false",
                            Toast.LENGTH_SHORT
                        ).show()
                        isEnabled = false
                    }
                }
            })

        requireActivity().onBackPressedDispatcher.addCallback(
            this,
            object : OnBackPressedCallback(true) {

                override fun handleOnBackPressed() {
                    if (!viewModel.isEanble3) {
                        Toast.makeText(
                            this@MainFragment.context,
                            "[handleOnBackPressed]: false",
                            Toast.LENGTH_SHORT
                        ).show()
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

        button1.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this@MainFragment.context, "[Button1]: $isChecked", Toast.LENGTH_SHORT)
                .show()
            viewModel.isEanble1 = isChecked
        }

        button2.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this@MainFragment.context, "[Button2]: $isChecked", Toast.LENGTH_SHORT)
                .show()
            viewModel.isEanble2 = isChecked
        }

        button3.setOnCheckedChangeListener { _, isChecked ->
            Toast.makeText(this@MainFragment.context, "[Button3]: $isChecked", Toast.LENGTH_SHORT)
                .show()
            viewModel.isEanble3 = isChecked
        }
    }

    companion object {

        @JvmStatic
        fun newInstance() = MainFragment()
    }
}
