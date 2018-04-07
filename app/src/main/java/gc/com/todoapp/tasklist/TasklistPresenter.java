package gc.com.todoapp.tasklist;

import com.raizlabs.android.dbflow.sql.language.SQLite;

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
    public void addTask() {

    }

    @Override
    public void start() {

    }

    @Override
    public List<TaskData> queryTasklist(long id) {
        TodoData todo = SQLite.select()
                .from(TodoData.class)
                .where(TodoData_Table.id.eq(id))
                .querySingle();
        return todo.tasks;
    }
}
