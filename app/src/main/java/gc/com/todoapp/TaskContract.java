package gc.com.todoapp;

public interface TaskContract {
    interface View extends BaseView<Presenter> {
        void showAddTodoList();
        void showTodolist();
    }

    interface Presenter extends BasePresenter {
        void addTodoList();
    }
}
