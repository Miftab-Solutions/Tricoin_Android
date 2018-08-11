package manec.tricoin;

import android.content.Context;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.util.Pair;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.LinearLayout;

import com.dariopellegrini.formbuilder.FormBuilder;
import com.dariopellegrini.formbuilder.FormButton;
import com.dariopellegrini.formbuilder.FormElement;
import com.dariopellegrini.formbuilder.FormObject;

import java.util.ArrayList;
import java.util.List;

import ndk.utils.Activity_Utils;
import ndk.utils.SharedPreference_Utils;
import ndk.utils.TODO_Utils;
import ndk.utils.Toast_Utils;

public class Activity_Login extends AppCompatActivity implements Fragment_Login.OnFragmentInteractionListener {

    Context activity_context = this;
    private RecyclerView mRecyclerView;
    private FormBuilder mFormBuilder;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.blank_linear);

        LinearLayout mLinearLayout = findViewById(R.id.linearLayout);
        FormBuilder formBuilder = new FormBuilder(this, mLinearLayout);
        List<FormObject> formObjects = new ArrayList<FormObject>();

        formObjects.add(new FormElement()
                .setTag("Username") // Tag is necessary in order to retrieve values
                .setHint("Username") // Hint is the placeholder of the generated EditText
                .setType(FormElement.Type.TEXT) // Type of form
                .setRequired(true) // For validation purpose (default false)
                .setErrorMessage("Invalid Username")
        );

        formObjects.add(new FormElement()
                .setTag("Password")
                .setHint("Password")
                .setType(FormElement.Type.PASSWORD)
                .setRequired(true) // For validation purpose (default false)
                .setErrorMessage("Invalid Password"));

//        formObjects.add(new FormElement().setTag("phone").setHint("phone").setType(FormElement.Type.PHONE));

        formObjects.add(new FormButton()
                        .setTitle("Login")
                        .setBackgroundColor(Color.GRAY)
                        .setTextColor(Color.BLACK)
                        .setRunnable(new Runnable() {
                            @Override
                            public void run() {
//                        boolean isValid = formBuilder.validate();
                                Log.i("Forms", formBuilder.formMap.toString());

                                if (formBuilder.validate()) {
                                    if (formBuilder.formMap.get("Username").getValue().equals("Tri") && formBuilder.formMap.get("Password").getValue().equals("coin")) {
                                        SharedPreference_Utils.commit_Shared_Preferences(getApplicationContext(), Application_Specification.APPLICATION_NAME, new Pair[]{new Pair<>("user_id", String.valueOf(0)), new Pair<>("is_logged", String.valueOf(true)), new Pair<>("is_skipped_login", String.valueOf(false))});
//                                Activity_Utils.start_activity_with_finish(activity_context, Signed_Portals.class, Application_Specification.APPLICATION_NAME);
                                        Activity_Utils.start_activity_with_finish(activity_context, Activity_Dashboard.class, Application_Specification.APPLICATION_NAME);

                                    } else {
                                        Toast_Utils.longToast(getApplicationContext(), "Login Failure.");
                                    }
                                }
                            }
                        })
        );

        formObjects.add(new FormButton()
                        .setTitle("Login with Google")
                        .setBackgroundColor(Color.RED)
                        .setTextColor(Color.BLACK)
                        .setRunnable(new Runnable() {
                            @Override
                            public void run() {
//                        boolean isValid = formBuilder.validate();
                                Log.i("Forms", formBuilder.formMap.toString());
                                TODO_Utils.display_TODO_no_FAB_SnackBar(activity_context);
                            }
                        })
        );


        formObjects.add(new FormButton()
                        .setTitle("Skip")
                        .setBackgroundColor(Color.LTGRAY)
                        .setTextColor(Color.BLACK)
                        .setRunnable(new Runnable() {
                            @Override
                            public void run() {
//                        boolean isValid = formBuilder.validate();
                                Log.i("Forms", formBuilder.formMap.toString());
                                SharedPreference_Utils.commit_Shared_Preferences(getApplicationContext(), Application_Specification.APPLICATION_NAME, new Pair[]{new Pair<>("is_skipped_login", String.valueOf(true))});

                                //TODO:Implement Application Utils Wrapper
//                        Activity_Utils.start_activity_with_finish(activity_context, Signed_Portals.class, Application_Specification.APPLICATION_NAME);
                                Activity_Utils.start_activity_with_finish(activity_context, Activity_Dashboard.class, Application_Specification.APPLICATION_NAME);
                            }
                        })
        );


        formBuilder.build(formObjects);

//        setContentView(R.layout.ssforms_blank);
//        Fragment_Utils.attach_fragment(this, Fragment_Login.newInstance("", ""));

//        mRecyclerView = (RecyclerView) findViewById(R.id.recyclerView);
//        mFormBuilder = new FormBuilder(this, mRecyclerView);
//        FormElementTextEmail element1 = FormElementTextEmail.createInstance().setTag(1).setTitle("Email").setRequired(true);
//        FormElementTextPassword element2 = FormElementTextPassword.createInstance().setTag(2).setTitle("Password").setRequired(true);
//
//        List<BaseFormElement> formItems = new ArrayList<>();
//        formItems.add(element1);
//        formItems.add(element2);
//
//        mFormBuilder.addFormElements(formItems);
    }

    @Override
    public void onFragmentInteraction(Uri uri) {

    }
}
