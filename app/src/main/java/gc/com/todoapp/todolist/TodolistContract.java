package gc.com.todoapp.todolist;

import gc.com.todoapp.BasePresenter;
import gc.com.todoapp.BaseView;

public interface TodolistContract {
    interface View extends BaseView<Presenter> {
        void showAddTodoList();
        void showTodolist();
    }

    interface Presenter extends BasePresenter {
        void addTodoList();
    }
}
