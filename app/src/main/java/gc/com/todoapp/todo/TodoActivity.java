package gc.com.todoapp.todo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import gc.com.todoapp.ActivityUtils;
import gc.com.todoapp.R;

public class TodoActivity extends AppCompatActivity {
    private static final String TAG = "TodoActivity";
    private TodoPresenter m_presenter;
    public static final int REQUEST_ADD_TODOLIST = 1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_todolist);
        initTodolistFragment();
    }

    public void initTodolistFragment() {
        TodoFragment todolistFragment = (TodoFragment) getSupportFragmentManager().findFragmentById(R.id.addTodolistFrame);
        if (todolistFragment == null) {
            todolistFragment = TodoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), todolistFragment, R.id.addTodolistFrame);
        }
        m_presenter = new TodoPresenter(todolistFragment);
    }
}
