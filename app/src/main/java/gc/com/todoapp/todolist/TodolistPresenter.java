package gc.com.todoapp.todolist;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by jyin on 3/30/18.
 */

public class TodolistPresenter implements TodolistContract.Presenter {
    private static final String TAG = "TodolistPresenter";
    private final TodolistContract.View m_taskView;


    public TodolistPresenter(@NonNull TodolistContract.View taskView) {
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
