package manec.tricoin;

import ndk.utils.Log_Utils;

//TODO : Make abstract class of Log Utils

public class Log_Utils_Wrapper {

    public static void debug(String message) {
        Log_Utils.debug(Application_Specification.APPLICATION_NAME, message, BuildConfig.DEBUG);

    }
}
