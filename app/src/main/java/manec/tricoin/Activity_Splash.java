package manec.tricoin;

import android.support.v4.util.Pair;

import ndk.utils.activities.Splash_Base_URL_Layout;

import static manec.tricoin.Server_Endpoint.UPDATE_URL;

public class Activity_Splash extends Splash_Base_URL_Layout {

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
        return Introduction_Slide_1.class;
    }

    @Override
    protected int configure_LAYOUT() {
        return R.layout.activity_launch;
    }

    @Override
    protected Pair[] configure_NEXT_ACTIVITY_CLASS_EXTRAS() {
        return new Pair[0];
    }

}
