package gc.com.todoapp.task;

import android.support.annotation.NonNull;
import android.util.Log;

import java.util.ArrayList;
import java.util.HashMap;

import gc.com.todoapp.task.TaskContract;

/**
 * Created by jyin on 3/30/18.
 */

public class TaskPresenter implements TaskContract.Presenter {
    private static final String TAG = "TaskPresenter";
    private final TaskContract.View m_taskView;


    public TaskPresenter(@NonNull TaskContract.View taskView) {
        m_taskView = taskView;
        m_taskView.setPresenter(this);

    }

    @Override
    public void start() {
        Log.e(TAG, "start");
        m_taskView.showTodolist();
    }

    @Override
    public void addTodoList() {
        m_taskView.showAddTodoList();
    }
}
