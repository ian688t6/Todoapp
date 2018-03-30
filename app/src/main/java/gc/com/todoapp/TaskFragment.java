package gc.com.todoapp;

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

/**
 * Created by jyin on 3/28/18.
 */

public class TaskFragment extends Fragment implements TaskContract.View {

    private static final String TAG = "TaskFragment";
    private TodoAdapter m_adapter;
    private TaskContract.Presenter m_presenter;
    public static TaskFragment newInstance() {
        return new TaskFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        TodoApplication application = (TodoApplication) getActivity().getApplication();
        m_adapter = new TodoAdapter(getContext(), application.getData());
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

    public void initRecycleView(View root) {
        RecyclerView recyclerView = root.findViewById(R.id.content_recycleview);
        recyclerView.setLayoutManager(new LinearLayoutManager(getContext()));
        recyclerView.setHasFixedSize(true);
        recyclerView.addItemDecoration(new DividerItemDecoration(getContext(), DividerItemDecoration.VERTICAL));
        recyclerView.setAdapter(m_adapter);
    }

    public void initAddlist(View root) {
        TextView textView = root.findViewById(R.id.tv_addlist);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "click add list");
            }
        });
    }

    @Override
    public void showAddTodoList() {

    }

    @Override
    public void setPresenter(TaskContract.Presenter presenter) {
        if (presenter != null) {
            m_presenter = presenter;
        }
    }
}
