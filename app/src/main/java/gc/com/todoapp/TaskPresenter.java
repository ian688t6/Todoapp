package gc.com.todoapp;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jyin on 3/30/18.
 */

public class TaskPresenter implements TaskContract.Presenter {
    private static final String TAG = "TaskPresenter";
    private final ArrayList<HashMap<String, Object>> m_data;
    private final TaskContract.View m_taskView;

    public TaskPresenter(@NonNull ArrayList<HashMap<String, Object>> data, @NonNull TaskContract.View taskView) {
        m_data = data;
        m_taskView = taskView;
        m_taskView.setPresenter(this);
    }

    @Override
    public void start() {
        Log.e(TAG, "start");
    }

    @Override
    public void addTodoList() {
        m_taskView.showAddTodoList();
    }
}
