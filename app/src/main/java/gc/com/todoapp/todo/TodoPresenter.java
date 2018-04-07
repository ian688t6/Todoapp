package gc.com.todoapp.todo;

import android.support.annotation.NonNull;
import android.util.Log;

/**
 * Created by jyin on 3/30/18.
 */

public class TodoPresenter implements TodoContract.Presenter {
    private static final String TAG = "TodoPresenter";
    private final TodoContract.View m_taskView;


    public TodoPresenter(@NonNull TodoContract.View taskView) {
        m_taskView = taskView;
        m_taskView.setPresenter(this);

    }

    @Override
    public void start() {
        Log.e(TAG, "start");
        m_taskView.showTodolist();
    }

    @Override
    public void addTodoList() {
        m_taskView.showAddTodoList();
    }
}
