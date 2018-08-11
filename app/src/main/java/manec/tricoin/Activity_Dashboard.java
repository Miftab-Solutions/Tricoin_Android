package manec.tricoin;

import android.net.Uri;
import android.os.Bundle;
import android.support.v4.content.ContextCompat;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.library.BottomBarHolderActivity;
import me.riddhimanadib.library.NavigationPage;

public class Activity_Dashboard extends BottomBarHolderActivity implements Fragment_Ads.OnFragmentInteractionListener, Fragment_News.OnFragmentInteractionListener, Fragment_Extras.OnFragmentInteractionListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        NavigationPage ads = new NavigationPage("Ads", ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp), Fragment_Ads.newInstance("", ""));
        NavigationPage news = new NavigationPage("News", ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp), Fragment_News.newInstance("", ""));
        NavigationPage chats = new NavigationPage("Chats", ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp), Fragment_Extras.newInstance("", ""));
        NavigationPage extra = new NavigationPage("Extras", ContextCompat.getDrawable(this, R.drawable.ic_home_black_24dp), Fragment_Extras.newInstance("", ""));

        List<NavigationPage> navigationPages = new ArrayList<>();
        navigationPages.add(ads);
        navigationPages.add(news);
        navigationPages.add(chats);
        navigationPages.add(extra);

        super.setupBottomBarHolderActivity(navigationPages);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
