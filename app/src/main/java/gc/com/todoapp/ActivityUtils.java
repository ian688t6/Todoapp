package gc.com.todoapp;

import android.support.annotation.NonNull;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.util.Log;

/**
 * Created by jyin on 3/28/18.
 */

public class ActivityUtils {
    private static final String TAG = "ActivityUtils";

    public static void addFragmentToActivity(@NonNull FragmentManager fragmentManager, @NonNull Fragment fragment, int fragmentId) {
        if ((fragmentManager == null) || (fragment == null)) {
            Log.e(TAG, "fragmentManager or fragment null");
            return;
        }

        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.add(fragmentId, fragment);
        fragmentTransaction.commit();
    }
}
