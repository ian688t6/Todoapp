package gc.com.todoapp;

import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by jyin on 3/30/18.
 */

public class TodolistFragment extends Fragment implements TodolistContract.View {

    private static final String TAG = "TodolistFragment";
    private TodolistContract.Presenter m_presenter;

    public static TodolistFragment newInstance() {
        return new TodolistFragment();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_todolist, container, false);
        Log.e(TAG, "TaskFragment create");
        return root;
    }

    @Override
    public void setPresenter(TodolistContract.Presenter presenter) {
        m_presenter = presenter;
    }

    @Override
    public void showTasksList() {

    }

    @Override
    public void setTitle(String title) {

    }
}
