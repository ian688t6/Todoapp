package gc.com.todoapp.todo;

import gc.com.todoapp.BasePresenter;
import gc.com.todoapp.BaseView;

/**
 * Created by jyin on 4/4/18.
 */

public class TodoContract {
    interface View extends BaseView<Presenter> {
        void showTasksList();
        void setTitle(String title);
    }

    interface Presenter extends BasePresenter {
        void saveTodolist(String title);
    }
}
