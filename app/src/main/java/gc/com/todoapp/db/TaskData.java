package gc.com.todoapp.db;


import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.ForeignKey;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDataBase.class)
public class TaskData extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;

    @ForeignKey(stubbedRelationship = true)
    public TodoData todo;

    @Column
    public String content;

    @Override
    public String toString() {
        return "Task {" +
                "id=" + id +
                ", todo=" + todo +
                ", content='" + content  + '}';
    }
}
