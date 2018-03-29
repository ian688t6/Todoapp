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

    public ArrayList<HashMap<String, Object>> getData() {
        return m_data;
    }

    private void initData() {
        m_data = new ArrayList<>();
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put(TodoAdapter.TITLE, "Inbox");
            m_data.add(map);
        }
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put(TodoAdapter.TITLE, "Work");
            m_data.add(map);
        }
        {
            HashMap<String, Object> map = new HashMap<>();
            map.put(TodoAdapter.TITLE, "Private");
            m_data.add(map);
        }
    }
}
