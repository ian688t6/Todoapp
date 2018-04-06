package gc.com.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddTodolistActivity extends AppCompatActivity {
    private static final String TAG = "AddTodolistActivity";
    private TodolistPresenter m_presenter;
    public static final int REQUEST_ADD_TODOLIST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todolist);
        initTodolistFragment();
    }

    public void initTodolistFragment() {
        TodolistFragment todolistFragment = (TodolistFragment) getSupportFragmentManager().findFragmentById(R.id.addTodolistFrame);
        if (todolistFragment == null) {
            todolistFragment = TodolistFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), todolistFragment, R.id.addTodolistFrame);
        }
        TodoApplication application = (TodoApplication) getApplication();
        m_presenter = new TodolistPresenter(application.getData(), todolistFragment);
    }
}
