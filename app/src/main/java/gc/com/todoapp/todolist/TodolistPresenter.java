package gc.com.todoapp.todolist;

import android.support.annotation.NonNull;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gc.com.todoapp.db.TaskData;
import gc.com.todoapp.db.TodoData;

/**
 * Created by jyin on 4/4/18.
 */

public class TodolistPresenter implements TodolistContract.Presenter {
    private static final String TAG = "TodolistPresenter";
    private final TodolistContract.View m_view;

    public TodolistPresenter(@NonNull TodolistContract.View todolistView) {
        m_view = todolistView;
        m_view.setPresenter(this);
    }

    @Override
    public void start() {

    }

    @Override
    public void saveTodolist(String title) {
        TaskData task = new TaskData();
        task.content = "abc";

        TodoData data = new TodoData();
        data.title = title;
        data.tasks = new ArrayList<>();
        data.tasks.add(task);

        task.todo = data;

        data.save();

        createTodolist();
    }

    private void createTodolist() {
        m_view.showTasksList();
    }
}
