package gc.com.todoapp.task;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.support.v7.widget.DividerItemDecoration;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gc.com.todoapp.R;
import gc.com.todoapp.tasklist.TasklistActivity;
import gc.com.todoapp.todolist.AddTodolistActivity;
import gc.com.todoapp.TodoApplication;
import gc.com.todoapp.db.TodoData;

/**
 * Created by jyin on 3/28/18.
 */

public class TaskFragment extends Fragment implements TaskContract.View, TodoAdapter.TodoAdapterCallback {

    private static final String TAG = "TaskFragment";
    private TodoAdapter<TodoData> m_adapter;
    private TaskContract.Presenter m_presenter;
    public static TaskFragment newInstance() {
        return new TaskFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        TodoApplication application = (TodoApplication) getActivity().getApplication();
        m_adapter = new TodoAdapter<TodoData>(getContext(), application.getDatabase());
        m_adapter.setCallback(this);
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_content, container, false);
        Log.e(TAG, "TaskFragment create");
        initRecycleView(root);
        initAddlist(root);
        return root;
    }

    @Override
    public void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        Log.e(TAG, "onActivityResult");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.e(TAG, "onResume");
        m_presenter.start();
    }

    private void initRecycleView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.content_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(m_adapter);
    }

    private void initAddlist(View root) {
        TextView textView = root.findViewById(R.id.tv_addlist);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "click add list");
                m_presenter.addTodoList();
            }
        });
    }

    @Override
    public void showAddTodoList() {
        Log.e(TAG, "showAddTodoList");
        startActivityForResult(new Intent(getContext(), AddTodolistActivity.class), AddTodolistActivity.REQUEST_ADD_TODOLIST);
    }

    @Override
    public void setPresenter(TaskContract.Presenter presenter) {
        if (presenter != null) {
            Log.e(TAG, "setPresenter");
            m_presenter = presenter;
        }
    }

    @Override
    public void showTodolist() {
        Log.e(TAG, "showTodolist");
        TodoApplication application = (TodoApplication) getActivity().getApplication();
        m_adapter.replaceData(application.getDatabase());
    }

    @Override
    public void onClick(Object o) {
        TodoData data = (TodoData)o;
        Log.e(TAG, "click " + String.valueOf(data.id));
        Intent intent = new Intent(getContext(), TasklistActivity.class);
        intent.putExtra(TasklistActivity.ARG_ID, data.id);
        startActivityForResult(intent, TasklistActivity.REQUEST_ADD_TASKLIST);
    }
}
