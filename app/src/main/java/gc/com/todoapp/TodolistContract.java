package gc.com.todoapp;

/**
 * Created by jyin on 4/4/18.
 */

public class TodolistContract {
    interface View extends BaseView<Presenter> {
        void showTasksList();
        void setTitle(String title);
    }

    interface Presenter extends BasePresenter {
        void saveTodolist(String title);
    }
}
