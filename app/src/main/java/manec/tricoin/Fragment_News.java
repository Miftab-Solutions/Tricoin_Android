package manec.tricoin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_News.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_News#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_News extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private android.support.v7.widget.RecyclerView recyclerview;
    private android.widget.RelativeLayout activitymain;

    public Fragment_News() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_News.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_News newInstance(String param1, String param2) {
        Fragment_News fragment = new Fragment_News();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_news, container, false);
        this.activitymain = view.findViewById(R.id.activity_main);
        this.recyclerview = view.findViewById(R.id.recycler_view);

        List<Feed> feedList = new ArrayList<>();
        FeedAdapter adapter = new FeedAdapter(getActivity(), feedList);

        // sets our layout manager and recycler view
        RecyclerView.LayoutManager mLayoutManager = new LinearLayoutManager(getActivity());
        recyclerview.setLayoutManager(mLayoutManager);
        recyclerview.setItemAnimator(new DefaultItemAnimator());
        recyclerview.setAdapter(adapter);

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

//        return inflater.inflate(R.layout.fragment_news, container, false);
        return view;
    }

    // TODO: Rename method, update argument and hook method into UI event
    public void onButtonPressed(Uri uri) {
        if (mListener != null) {
            mListener.onFragmentInteraction(uri);
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        if (context instanceof OnFragmentInteractionListener) {
            mListener = (OnFragmentInteractionListener) context;
        } else {
            throw new RuntimeException(context.toString()
                    + " must implement OnFragmentInteractionListener");
        }
    }

    @Override
    public void onDetach() {
        super.onDetach();
        mListener = null;
    }

    /**
     * This interface must be implemented by activities that contain this
     * fragment to allow an interaction in this fragment to be communicated
     * to the activity and potentially other fragments contained in that
     * activity.
     * <p>
     * See the Android Training lesson <a href=
     * "http://developer.android.com/training/basics/fragments/communicating.html"
     * >Communicating with Other Fragments</a> for more information.
     */
    public interface OnFragmentInteractionListener {
        // TODO: Update argument type and name
        void onFragmentInteraction(Uri uri);
    }
}
