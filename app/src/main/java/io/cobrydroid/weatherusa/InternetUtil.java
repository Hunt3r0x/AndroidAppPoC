package io.cobrydroid.weatherusa;

public class InternetUtil {

    static {
        System.loadLibrary("native-lib"); // Load the native library
    }

    private static native String getKey(String str);

    public static String solve() {
        return getKey("moiba1cybar8smart4sheriff4securi");
    }
}