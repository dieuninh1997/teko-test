package com.ninhttd.devtest.utils;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;

import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.ninhttd.devtest.R;
import com.ninhttd.devtest.custom.LogUtils;

public class Navigator {
    public static void startFragment(FragmentActivity activity, int frameId, Fragment target, boolean isReplace) {
        if (isReplace) {
            activity.getSupportFragmentManager().beginTransaction().replace(frameId, target).commit();
        } else {
            activity.getSupportFragmentManager().beginTransaction().add(frameId, target).commit();
        }
    }


    public static void startFragmentWithAddBackStack(FragmentActivity activity, int frameId, Fragment target, String tag, boolean isReplace) {
        String backStateName = target.getClass().getName();
        FragmentManager manager=activity.getSupportFragmentManager();
        if(isReplace){
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.replace(frameId, target);
            transaction.addToBackStack(tag);
            transaction.commit();
        }else{
            FragmentTransaction transaction=manager.beginTransaction();
            transaction.add(frameId, target);
            transaction.addToBackStack(tag);
            transaction.commit();
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

    public static void removeFragmentInStack(FragmentActivity activity, Fragment target) {
        activity.getSupportFragmentManager().beginTransaction().remove(target).commit();
    }

    public static void startActivity(Activity activity, Class target) {
        LogUtils.infoLog(activity, "Current Activity: " + target.getSimpleName());
        Intent starter = new Intent(activity, target);
        activity.startActivity(starter);
    }

    public static void startActivityWithAnimation(Activity activity, Class target, int amin1, int amin2) {
        LogUtils.infoLog(activity, "Current Activity: " + target.getSimpleName());
        Intent starter = new Intent(activity, target);
        activity.startActivity(starter);
        activity.overridePendingTransition(amin1, amin2);
    }

    public static void startActivity(Activity activity, Class target, Bundle bundle) {
        LogUtils.infoLog(activity, "Current Activity: " + target.getSimpleName());
        Intent starter = new Intent(activity, target);
        starter.putExtras(bundle);
        activity.startActivity(starter);
    }
}
