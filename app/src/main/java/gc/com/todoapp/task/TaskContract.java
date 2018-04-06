package gc.com.todoapp.task;

import gc.com.todoapp.BasePresenter;
import gc.com.todoapp.BaseView;

public interface TaskContract {
    interface View extends BaseView<Presenter> {
        void showAddTodoList();
        void showTodolist();
    }

    interface Presenter extends BasePresenter {
        void addTodoList();
    }
}
