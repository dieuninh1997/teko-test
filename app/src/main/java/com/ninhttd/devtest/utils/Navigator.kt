package com.ninhttd.devtest.utils

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.fragment.app.FragmentManager
import androidx.fragment.app.FragmentTransaction

import com.ninhttd.devtest.R

object Navigator {
    fun startFragment(activity: FragmentActivity, frameId: Int, target: Fragment, isReplace: Boolean) {
        if (isReplace) {
            activity.supportFragmentManager.beginTransaction().replace(frameId, target).commit()
        } else {
            activity.supportFragmentManager.beginTransaction().add(frameId, target).commit()
        }
    }

    fun startFragmentWithAnimation(activity: FragmentActivity, frameId: Int, target: Fragment, tag: String?, isReplace: Boolean, animationType: Int) {
        val backStateName = target.javaClass.name
        val manager = activity.supportFragmentManager
        val transaction = manager.beginTransaction()
        when (animationType) {
            1 -> transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right)
            2 -> transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left)
            3 -> transaction.setCustomAnimations(R.anim.slide_in_up, android.R.animator.fade_out, android.R.animator.fade_in, R.anim.slide_out_down)
        }
        if (isReplace) {
            transaction.replace(frameId, target).addToBackStack(backStateName).commit()
        } else {
            transaction.add(frameId, target).addToBackStack(backStateName).commit()
        }
    }
}
