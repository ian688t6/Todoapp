package gc.com.todoapp;

import android.app.Application;
import android.util.Log;

import com.raizlabs.android.dbflow.config.FlowManager;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

import gc.com.todoapp.db.AppDataBase;
import gc.com.todoapp.db.TodoData;

/**
 * Created by jyin on 3/29/18.
 */

public class TodoApplication extends Application {
    private static final String TAG = "TodoApplication";

    @Override
    public void onCreate() {
        super.onCreate();
        initDataBase();
    }

    private void initDataBase() {
        FlowManager.init(this);
    }

    public List<TodoData> getDatabase() {
        return SQLite.select().from(TodoData.class).queryList();
    }

}
