package gc.com.todoapp;

public interface TaskContract {
    interface View extends BaseView<Presenter> {
        void showAddTodoList();
    }

    interface Presenter extends BasePresenter {
        void addTodoList();
    }
}
