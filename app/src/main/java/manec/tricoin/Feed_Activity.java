package manec.tricoin;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class Feed_Activity extends AppCompatActivity {


    private RecyclerView recyclerView;
    private RecyclerView.LayoutManager mLayoutManager;
    private FeedAdapter adapter;
    private List<Feed> feedList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.recycler_view);

        feedList = new ArrayList<>();
        adapter = new FeedAdapter(this, feedList);

        // sets our layout manager and recycler view
        mLayoutManager = new LinearLayoutManager(this);
        recyclerView = (RecyclerView) findViewById(R.id.recycler_view);
        recyclerView.setLayoutManager(mLayoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(adapter);

        // create a new object feed to be inserted in our adapter.
        Feed feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial5.jpg",
                "In this tutorial, I’m going to teach you how to use Android Context Menu and " +
                        "GridView. We’re going to creating a simple wallpaper application that " +
                        "will allow the users to choose and apply a wallpaper in our gallery.",
                "3 DAYS AGO");
        feedList.add(0, feed);

        feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial6.jpg",
                "Remember the old Facebook Messenger app? In this tutorial, I’m going to teach " +
                        "you how to create a Facebook Messenger like layout using Android Design " +
                        "library, Fragments and ViewPager. I’ll also teach you how to support " +
                        "multiple screens by adding different sizes of drawables in your project.",
                "1 DAY AGO");
        feedList.add(0, feed);

        feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial7.jpg",
                "Being able to save data locally  is one of the most important feature of an app. " +
                        "In this tutorial, I’m going to teach you how to do that by using Android " +
                        "SQLite Database. I’ll also teach you how to apply basic material design " +
                        "in your application.",
                "10 HOURS AGO");
        feedList.add(0, feed);

        feed = new Feed("androidprime",
                "Metro Manila, Philippines",
                "http://androidprime.info/android/images/Tutorial8.jpg",
                "The quickest and easiest way of integrating user registration in your application " +
                        "is through existing social networks such as Google, Facebook, VK and etc.. " +
                        "In this tutorial, I’m going to teach you how to implement Google Plus " +
                        "Sign In using Android.",
                "26 MINUTES AGO");
        feedList.add(0, feed);

        //call this every time you're going to add new items in your recycler view
        adapter.notifyDataSetChanged();

    }


}
