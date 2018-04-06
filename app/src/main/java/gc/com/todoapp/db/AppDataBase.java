package gc.com.todoapp.db;

import com.raizlabs.android.dbflow.annotation.Database;

@Database(name = AppDataBase.name, version = AppDataBase.version)
public class AppDataBase {

    public static final String name = "AppDataBase";

    public static final int version = 1;
}
