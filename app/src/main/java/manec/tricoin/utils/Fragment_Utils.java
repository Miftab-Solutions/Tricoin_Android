package manec.tricoin.utils;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

import manec.tricoin.R;

public class Fragment_Utils {

    public static void attach_fragment(AppCompatActivity activity, Fragment fragment) {
        activity.setContentView(R.layout.blank_frame);

        // create a FragmentManager
        FragmentManager fragmentManager = activity.getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, fragment);
        fragmentTransaction.commit(); // save the changes
    }
}
