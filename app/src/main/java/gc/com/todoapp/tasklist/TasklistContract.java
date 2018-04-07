package gc.com.todoapp.tasklist;

import gc.com.todoapp.BasePresenter;
import gc.com.todoapp.BaseView;

public interface TasklistContract {

    interface View extends BaseView<Presenter> {
        void showAddTasklist();
        void showTasklist();
    }

    interface Presenter extends BasePresenter {
        void addTask();
    }

}
