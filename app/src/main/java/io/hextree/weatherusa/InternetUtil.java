package io.hextree.weatherusa;

public class InternetUtil {

    private static native String getKey(String str);

    public static String solve(){
        System.loadLibrary("native-lib");
        return getKey("moiba1cybar8smart4sheriff4securi");
    }
}