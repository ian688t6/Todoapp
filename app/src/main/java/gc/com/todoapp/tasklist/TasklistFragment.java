package gc.com.todoapp.tasklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.List;

import gc.com.todoapp.R;
import gc.com.todoapp.db.TaskData;

public class TasklistFragment extends Fragment implements TasklistContract.View {
    private TasklistContract.Presenter m_presenter;
    private static final String TAG = "TasklistFragment";

    public static TasklistFragment newInstance() {
        return new TasklistFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");
        List<TaskData>list =  m_presenter.queryTasklist(((TasklistActivity)getActivity()).getId());
        for (TaskData t : list) {
            Log.e(TAG, t.toString());
        }
    }

    @Override
    public void onAttach(Context context) {
        super.onAttach(context);
        TasklistActivity activity = (TasklistActivity)context;
        Log.e(TAG, "id " + String.valueOf(activity.getId()));
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_tasklist, container, false);
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
    }

    @Override
    public void showAddTasklist() {

    }

    @Override
    public void showTasklist() {

    }

    @Override
    public void setPresenter(TasklistContract.Presenter presenter) {
        if (presenter != null) {
            Log.e(TAG, "setPresenter");
            m_presenter = presenter;
        }
    }
}
