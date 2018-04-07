package gc.com.todoapp.todo;

import gc.com.todoapp.BasePresenter;
import gc.com.todoapp.BaseView;

public interface TodoContract {
    interface View extends BaseView<Presenter> {
        void showAddTodoList();
        void showTodolist();
    }

    interface Presenter extends BasePresenter {
        void addTodoList();
    }
}
