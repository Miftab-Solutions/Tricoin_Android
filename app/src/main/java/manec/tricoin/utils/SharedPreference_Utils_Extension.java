package manec.tricoin.utils;

import android.content.Context;

import com.github.pwittchen.prefser.library.rx2.Prefser;

import ndk.utils.SharedPreference_Utils;

public class SharedPreference_Utils_Extension extends SharedPreference_Utils {

    public void put(Context context, String APPLICATION_NAME, String key, Object value) {

        new Prefser(context.getSharedPreferences(APPLICATION_NAME, Context.MODE_PRIVATE)).put(key, value);
    }

    public Object get(Context context, String APPLICATION_NAME, String key, Class<Object> base_class, Object default_value) {
        return new Prefser(context.getSharedPreferences(APPLICATION_NAME, Context.MODE_PRIVATE)).get(key, base_class, default_value);
    }
}
