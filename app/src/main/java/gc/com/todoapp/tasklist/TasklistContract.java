package gc.com.todoapp.tasklist;

import java.util.List;

import gc.com.todoapp.BasePresenter;
import gc.com.todoapp.BaseView;
import gc.com.todoapp.db.TaskData;

public interface TasklistContract {

    interface View extends BaseView<Presenter> {
        void showAddTasklist();
        void showTasklist(List<TaskData> list);
    }

    interface Presenter extends BasePresenter {
        void addTask(long id, String title);
        void delTask(long id, TaskData task);
        void loadTasklist(long id);
        List<TaskData> queryTasklist(long id);
    }

}
