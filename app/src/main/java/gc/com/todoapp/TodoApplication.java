package gc.com.todoapp;

import android.app.Application;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jyin on 3/29/18.
 */

public class TodoApplication extends Application {
    private ArrayList<HashMap<String, Object>> m_data;
    private static final String TAG = "TodoApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        initData();
    }

    private void initData() {

    }
}
