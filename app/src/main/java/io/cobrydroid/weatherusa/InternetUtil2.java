package io.cobrydroid.weatherusa;

public class InternetUtil2 {

    static {
        System.loadLibrary("native-lib"); // Ensure this matches the library name
    }

    private static native String getKey(String str);

    public static String solve() {
        return getKey("moiba1cybar8smart4sheriff4securi");
    }
}