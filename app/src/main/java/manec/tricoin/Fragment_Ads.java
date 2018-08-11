package manec.tricoin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.Fragment;
import android.support.v4.widget.SwipeRefreshLayout;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Objects;

import ndk.utils.Resource_Utils;
import ndk.utils.String_Utils;


/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Ads.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Ads#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Ads extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;
    private android.support.v7.widget.Toolbar toolbar;
    private android.support.v7.widget.RecyclerView recyclerview;
    private android.support.v4.widget.SwipeRefreshLayout swiperefreshrecyclerlist;
    private android.support.design.widget.FloatingActionButton fab;
    private RecyclerViewAdapter mAdapter;
    private ArrayList<AbstractModel> modelList = new ArrayList<>();

    public Fragment_Ads() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Ads.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Ads newInstance(String param1, String param2) {
        Fragment_Ads fragment = new Fragment_Ads();
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
        View view = inflater.inflate(R.layout.fragment_ads, container, false);

        this.fab = view.findViewById(R.id.fab);
        this.swiperefreshrecyclerlist = view.findViewById(R.id.swipe_refresh_recycler_list);
        this.recyclerview = view.findViewById(R.id.recycler_view);
        this.toolbar = view.findViewById(R.id.toolbar);

        initToolbar("Ads.");

        setAdapter();

        swiperefreshrecyclerlist.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {

                // Do your stuff on refresh
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {

                        if (swiperefreshrecyclerlist.isRefreshing())
                            swiperefreshrecyclerlist.setRefreshing(false);
                    }
                }, 5000);

            }
        });

        return view;
    }

    public void initToolbar(String title) {
        ((AppCompatActivity) getActivity()).setSupportActionBar(toolbar);
//        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        Objects.requireNonNull(((AppCompatActivity) getActivity()).getSupportActionBar()).setDisplayShowHomeEnabled(true);
        ((AppCompatActivity) getActivity()).getSupportActionBar().setTitle(title);
    }

    private void setAdapter() {

//        modelList.add(new AbstractModel("Android", "Hello " + " Android"));
//        modelList.add(new AbstractModel("Beta", "Hello " + " Beta"));
//        modelList.add(new AbstractModel("Cupcake", "Hello " + " Cupcake"));
//        modelList.add(new AbstractModel("Donut", "Hello " + " Donut"));
//        modelList.add(new AbstractModel("Eclair", "Hello " + " Eclair"));
//        modelList.add(new AbstractModel("Froyo", "Hello " + " Froyo"));
//        modelList.add(new AbstractModel("Gingerbread", "Hello " + " Gingerbread"));
//        modelList.add(new AbstractModel("Honeycomb", "Hello " + " Honeycomb"));
//        modelList.add(new AbstractModel("Ice Cream Sandwich", "Hello " + " Ice Cream Sandwich"));
//        modelList.add(new AbstractModel("Jelly Bean", "Hello " + " Jelly Bean"));
//        modelList.add(new AbstractModel("KitKat", "Hello " + " KitKat"));
//        modelList.add(new AbstractModel("Lollipop", "Hello " + " Lollipop"));
//        modelList.add(new AbstractModel("Marshmallow", "Hello " + " Marshmallow"));
//        modelList.add(new AbstractModel("Nougat", "Hello " + " Nougat"));
//        modelList.add(new AbstractModel("Android O", "Hello " + " Android O"));

//        String package_name = getApplicationContext().getPackageName();
        for (int i = 1; i <= 88; i++) {

//            String id = String.valueOf(i);
//            if (id.length() == 1) {
//                id = "0" + id;
//            }
//            Log.d(Application_Specification.APPLICATION_NAME, "ID : ad_"+id+".jpg");
//            Log.d(Application_Specification.APPLICATION_NAME, "ID : ad_"+id);
//            Log.d(Application_Specification.APPLICATION_NAME, "Complete ID : " + Resource_Utils.get_drawable_identifier(getApplicationContext(), "ad_" + id));

//            Log.d(Application_Specification.APPLICATION_NAME, "Complete ID : " + Resource_Utils.get_drawable_identifier(getApplicationContext(), String_Utils.get_two_digited_hyphen_divided_zero_filled_length_constrained_serial_number_suffixed_name("ad",i)));

            modelList.add(new AbstractModel(Resource_Utils.get_drawable_identifier(getActivity(), String_Utils.get_two_digited_hyphen_divided_zero_filled_length_constrained_serial_number_suffixed_name("ad", i))));
        }


//        modelList.add(new AbstractModel(R.drawable.ad_01));
//        modelList.add(new AbstractModel(getResources().getIdentifier(package_name+":drawable/ad_01", null, null)));

        mAdapter = new RecyclerViewAdapter(modelList);

        recyclerview.setHasFixedSize(true);

        // use a linear layout manager

        LinearLayoutManager layoutManager = new LinearLayoutManager(getActivity());

        recyclerview.setLayoutManager(layoutManager);


        recyclerview.setAdapter(mAdapter);


        mAdapter.SetOnItemClickListener(new RecyclerViewAdapter.OnItemClickListener() {
            @Override
            public void onItemClick(View view, int position, AbstractModel model) {

                //handle item click events here
//                Toast.makeText(Portals.this, "Hey " + model.getTitle(), Toast.LENGTH_SHORT).show();

            }
        });

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
