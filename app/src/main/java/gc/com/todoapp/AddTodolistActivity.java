package gc.com.todoapp;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class AddTodolistActivity extends AppCompatActivity {

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
    }
}
