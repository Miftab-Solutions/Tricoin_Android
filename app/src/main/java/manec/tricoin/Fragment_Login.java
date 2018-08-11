package manec.tricoin;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.List;

import me.riddhimanadib.formmaster.FormBuilder;
import me.riddhimanadib.formmaster.model.FormElementTextPassword;
import me.riddhimanadib.formmaster.model.FormElementTextSingleLine;

/**
 * A simple {@link Fragment} subclass.
 * Activities that contain this fragment must implement the
 * {@link Fragment_Login.OnFragmentInteractionListener} interface
 * to handle interaction events.
 * Use the {@link Fragment_Login#newInstance} factory method to
 * create an instance of this fragment.
 */
public class Fragment_Login extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    private OnFragmentInteractionListener mListener;

    public Fragment_Login() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment Fragment_Login.
     */
    // TODO: Rename and change types and number of parameters
    public static Fragment_Login newInstance(String param1, String param2) {
        Fragment_Login fragment = new Fragment_Login();
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

        View view = inflater.inflate(R.layout.ssforms_blank, container, false);
        RecyclerView recyclerView = view.findViewById(R.id.recyclerView);

        FormBuilder mFormBuilder = new FormBuilder(getActivity(), recyclerView);

//        FormElementTextEmail element1 = FormElementTextEmail.createInstance().setTag(1).setTitle("Email").setRequired(true);
//        FormElementTextPassword element2 = FormElementTextPassword.createInstance().setTag(2).setTitle("Password").setRequired(true);
        FormElementTextSingleLine username = FormElementTextSingleLine.createInstance().setTitle("Username").setRequired(true);
        FormElementTextPassword password = FormElementTextPassword.createInstance().setTitle("Password").setRequired(true);

        List<me.riddhimanadib.formmaster.model.BaseFormElement> formItems = new ArrayList<>();
//        formItems.add(element1);
//        formItems.add(element2);
        formItems.add(username);
        formItems.add(password);

        mFormBuilder.addFormElements(formItems);

//        OnFormElementValueChangedListener onFormElementValueChangedListener=new OnFormElementValueChangedListener() {
//            @Override
//            public void onValueChanged(BaseFormElement<?> baseFormElement) {
////                Toast.makeText(this, formElement.getValueAsString(), Toast.LENGTH_SHORT).show();
//            }
//        };
//
//        FormLayouts formLayouts = new FormLayouts();
//        FormBuildHelper formBuilder = new FormBuildHelper(getActivity(), onFormElementValueChangedListener, recyclerView, true, formLayouts);
//        List<BaseFormElement<?>> elements = new ArrayList<>();
//        ButtonBuilder button = new ButtonBuilder(1);
//        button.setValue("Button Text");
//        button.getValueObservers().add((newValue, element) -> {
//            // Nothing was changed but the button was tapped!
//            return Unit.INSTANCE;
//        });
//        elements.add(button.build());
//        formBuilder.addFormElements(elements);
        return view;

//        TextView textView = new TextView(getActivity());
//        textView.setText(R.string.hello_blank_fragment);
//        return textView;
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
