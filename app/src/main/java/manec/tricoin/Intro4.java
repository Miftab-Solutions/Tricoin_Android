package manec.tricoin;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;

public class Intro4 extends AppCompatActivity implements Fragment_Intro4.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_frame);

        // create a FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, Fragment_Intro4.newInstance("", ""));
        fragmentTransaction.commit(); // save the changes
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
