package gc.com.todoapp.tasklist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import gc.com.todoapp.ActivityUtils;
import gc.com.todoapp.R;

public class TasklistActivity extends AppCompatActivity {
    public static final String ARG_ID = "argid";
    public static final int REQUEST_ADD_TASKLIST = 1;
    private static final String TAG = "TasklistActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tasklist);
        Intent intent = getIntent();
        long id = intent.getLongExtra(ARG_ID, 0);
        Log.e(TAG, "id = " + String.valueOf(id));
        initTaskFragment();
    }

    private void initTaskFragment() {
        TasklistFragment fragment = (TasklistFragment)getSupportFragmentManager().findFragmentById(R.id.tasklist_frame);
        if (fragment == null) {
            fragment = TasklistFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), fragment, R.id.tasklist_frame);
        }
    }

}
