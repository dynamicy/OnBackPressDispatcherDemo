package com.example.demo.slave

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.activity.OnBackPressedCallback
import androidx.fragment.app.Fragment
import com.example.demo.R

class SlaveFragment : Fragment() {

    private lateinit var viewModel: SlaveViewModel

    override fun onAttach(context: Context) {
        super.onAttach(context)

        // Add Callback
        requireActivity().onBackPressedDispatcher.addCallback(this, object : OnBackPressedCallback(true) {

            override fun handleOnBackPressed() {
                val fragmentManager = requireActivity().supportFragmentManager
                val backStackCount = fragmentManager.backStackEntryCount

                Toast.makeText(
                    this@SlaveFragment.context,
                    "[handleOnBackPressed]: ${viewModel.isHandledBackPressed}",
                    Toast.LENGTH_SHORT
                ).show()

                if (!viewModel.isHandledBackPressed) {
                    viewModel.isHandledBackPressed = true
                } else {
                    if (backStackCount > 0) {
                        fragmentManager.popBackStack()
                        isEnabled = false
                    }
                }
            }
        })
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        viewModel = SlaveViewModel()
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_slave, container, false)
    }

    companion object {
        var instance = SlaveFragment()

        @JvmStatic
        fun newInstance() = instance
    }
}
