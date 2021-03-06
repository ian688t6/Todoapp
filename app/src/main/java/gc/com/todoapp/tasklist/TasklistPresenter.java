package gc.com.todoapp.tasklist;

import android.util.Log;

import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.ArrayList;
import java.util.List;

import gc.com.todoapp.db.TaskData;
import gc.com.todoapp.db.TodoData;
import gc.com.todoapp.db.TodoData_Table;

public class TasklistPresenter implements TasklistContract.Presenter {
    private static final String TAG = "TasklistPresenter";
    private final TasklistContract.View m_view;

    public TasklistPresenter(TasklistContract.View view) {
        m_view = view;
        m_view.setPresenter(this);
    }

    @Override
    public void addTask(long id, String title) {
        Log.e(TAG, "addTask id " + String.valueOf(id));
        TodoData todo = SQLite.select()
                .from(TodoData.class)
                .where(TodoData_Table.id.eq(id))
                .querySingle();
        {
            TaskData task = new TaskData();
            task.todo = todo;
            task.title = title;
            task.save();
            if (todo.tasks == null) {
                todo.tasks = new ArrayList<>();
            }
            todo.tasks.add(task);
            todo.update();
            todo.save();
        }
        m_view.showTasklist(todo.getTasks());
    }

    @Override
    public void delTask(long id, TaskData task) {
        TodoData todo = SQLite.select()
                .from(TodoData.class)
                .where(TodoData_Table.id.eq(id))
                .querySingle();

        if (todo.tasks == null || todo.tasks.size() == 0) {
            Log.e(TAG, "delTask todo tasks null");
            return;
        }

        Log.e(TAG, "deltask task id " + String.valueOf(task.id));
        task.delete();
        todo.tasks.remove(task);
        todo.update();
    }

    @Override
    public void loadTasklist(long id) {
        TodoData todo = SQLite.select()
                .from(TodoData.class)
                .where(TodoData_Table.id.eq(id))
                .querySingle();
        m_view.showTasklist(todo.getTasks());
    }

    @Override
    public List<TaskData> queryTasklist(long id) {
        TodoData todo = SQLite.select()
                .from(TodoData.class)
                .where(TodoData_Table.id.eq(id))
                .querySingle();
        return todo.getTasks();
    }

    @Override
    public void start() {

    }
}
