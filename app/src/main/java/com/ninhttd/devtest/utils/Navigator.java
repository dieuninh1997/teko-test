package com.ninhttd.devtest.utils;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ninhttd.devtest.R;

public class Navigator {
    public static void startFragment(FragmentActivity activity, int frameId, Fragment target, boolean isReplace) {
        if (isReplace) {
            activity.getSupportFragmentManager().beginTransaction().replace(frameId, target).commit();
        } else {
            activity.getSupportFragmentManager().beginTransaction().add(frameId, target).commit();
        }
    }

    public static void startFragmentWithAnimation(FragmentActivity activity, int frameId, Fragment target, String tag, boolean isReplace, int animationType) {
        String backStateName = target.getClass().getName();
        FragmentManager manager =activity. getSupportFragmentManager();
        FragmentTransaction transaction = manager.beginTransaction();
        switch (animationType) {
            case 1:
                transaction.setCustomAnimations(R.anim.slide_in_right, R.anim.slide_out_left, R.anim.slide_in_left, R.anim.slide_out_right);
                break;
            case 2:
                transaction.setCustomAnimations(R.anim.slide_in_left, R.anim.slide_out_right, R.anim.slide_in_right, R.anim.slide_out_left);
                break;
            case 3:
                transaction.setCustomAnimations(R.anim.slide_in_up, android.R.animator.fade_out, android.R.animator.fade_in, R.anim.slide_out_down);
                break;
        }
        if (isReplace) {
            transaction.replace(frameId, target).addToBackStack(backStateName).commit();
        } else {
            transaction.add(frameId, target).addToBackStack(backStateName).commit();
        }
    }
}
