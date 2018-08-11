package manec.tricoin.utils;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;

import ndk.utils.Activity_Utils;

public class Activity_Utils_Extension extends Activity_Utils {

    public static void start_activity_for_result(Context context, Class activity, int request_code) {

        Intent intent = new Intent(context, activity);
        ((AppCompatActivity) context).startActivityForResult(intent, request_code);

    }
}
