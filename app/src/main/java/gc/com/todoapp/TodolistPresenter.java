package gc.com.todoapp;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jyin on 4/4/18.
 */

public class TodolistPresenter implements TodolistContract.Presenter {
    private static final String TAG = "TodolistPresenter";
    private final ArrayList<HashMap<String, Object>> m_data;
    private final TodolistContract.View m_view;

    public TodolistPresenter(@NonNull ArrayList<HashMap<String, Object>> data, @NonNull TodolistContract.View todolistView) {
        m_data = data;
        m_view = todolistView;
        m_view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void saveTodolist(String title) {
        createTodolist();
        HashMap<String, Object> map = new HashMap<>();
        map.put(TodoAdapter.TITLE, title);
        m_data.add(map);
    }

    private void createTodolist() {
        m_view.showTasksList();
    }
}
