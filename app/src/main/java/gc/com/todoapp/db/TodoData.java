package gc.com.todoapp.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.OneToMany;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.sql.language.SQLite;
import com.raizlabs.android.dbflow.structure.BaseModel;

import java.util.List;

@Table(database = AppDataBase.class)
public class TodoData extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String title;

    public List<TaskData> tasks;

    public void insertData(String title, String description) {
        title = title;
    }

    @OneToMany(methods = {OneToMany.Method.ALL}, variableName = "tasks")
    public List<TaskData> getTasks() {
        if (tasks == null || tasks.isEmpty()) {
            tasks = SQLite.select()
                    .from(TaskData.class)
                    .where(TaskData_Table.todo_id.eq(id))
                    .queryList();
        }
        return tasks;
    }

    @Override
    public String toString() {
        return "Todo {" +
                "id=" + id +
                ", title='" + title + '\'' +
                ", tasks=" + tasks +
                '}';
    }
}
