package gc.com.todoapp.db;

import com.raizlabs.android.dbflow.annotation.Column;
import com.raizlabs.android.dbflow.annotation.PrimaryKey;
import com.raizlabs.android.dbflow.annotation.Table;
import com.raizlabs.android.dbflow.structure.BaseModel;

@Table(database = AppDataBase.class)
public class TodoData extends BaseModel {
    @PrimaryKey(autoincrement = true)
    public long id;

    @Column
    public String m_title;

    @Column
    public String m_description;

    public void insertData(String title, String description) {
        m_title = title;
        m_description = description;
    }
}
