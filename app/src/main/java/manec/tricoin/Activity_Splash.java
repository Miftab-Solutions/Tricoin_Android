package manec.tricoin;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v4.util.Pair;

import ndk.utils.SharedPreference_Utils;
import ndk.utils.activities.Splash_Base_URL_Layout;

import static manec.tricoin.Server_Endpoint.UPDATE_URL;

public class Activity_Splash extends Splash_Base_URL_Layout {

    Context activity_context = this;

    @Override
    protected String configure_GET_CONFIGURATION_URL() {
        return API_Wrapper.get_http_API(API.select_Configuration);
    }

    @Override
    protected String configure_UPDATE_URL() {
        return UPDATE_URL;
    }

    @Override
    protected String configure_APPLICATION_NAME() {
        return Application_Specification.APPLICATION_NAME;
    }

    @Override
    protected Class configure_NEXT_ACTIVITY_CLASS() {

        SharedPreference_Utils.First_Run_Actions first_run_actions = new SharedPreference_Utils.First_Run_Actions() {
            @Override
            public void on_first_run() {

            }
        };

        if (SharedPreference_Utils.is_first_run(this, Application_Specification.APPLICATION_NAME, first_run_actions)) {
            return Introduction_Slide_1.class;
        } else {

            SharedPreferences settings = getSharedPreferences(Application_Specification.APPLICATION_NAME, MODE_PRIVATE);
            if (settings.getString("is_skipped_login", String.valueOf(false)).equals(String.valueOf(true))) {
//                return Signed_Portals.class;
                return Activity_Dashboard.class;
            } else if (settings.getString("is_logged", String.valueOf(false)).equals(String.valueOf(true))) {
//                return Signed_Portals.class;
                return Activity_Dashboard.class;

            }
            return Activity_Login.class;
        }

    }

    @Override
    protected int configure_LAYOUT() {
        return R.layout.activity_launch;
    }

    @Override
    protected Pair[] configure_NEXT_ACTIVITY_CLASS_EXTRAS() {
        return new Pair[0];
    }

//    @Override
//    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
//        super.onActivityResult(requestCode, resultCode, data);
//    }
}
