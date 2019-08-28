package com.example.demo.util

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

fun FragmentActivity.showFragment(from: Fragment, to: Fragment, frameId: Int) {

    supportFragmentManager.transact {
        if (to.isAdded) {
            show(to)
        } else {
            add(frameId, to, to.javaClass.simpleName).addToBackStack(to.javaClass.simpleName)
        }

        if (to != from && from.isAdded) {
            hide(from)
        }
    }
}

private inline fun FragmentManager.transact(action: FragmentTransaction.() -> Unit) {
    beginTransaction().apply {
        action()
    }.commit()
}