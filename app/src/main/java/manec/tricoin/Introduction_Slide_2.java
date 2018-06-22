package manec.tricoin;

import android.net.Uri;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Introduction_Slide_2 extends AppCompatActivity implements Fragment_Introduction_Slide_2.OnFragmentInteractionListener{

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);

        setContentView(R.layout.blank_frame);

        // create a FragmentManager
        FragmentManager fragmentManager = getSupportFragmentManager();
        // create a FragmentTransaction to begin the transaction and replace the Fragment
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        // replace the FrameLayout with new Fragment
        fragmentTransaction.replace(R.id.frameLayout, Fragment_Introduction_Slide_2.newInstance("", ""));
        fragmentTransaction.commit(); // save the changes
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
