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

public class TodolistFragment extends Fragment {

    private static final String TAG = "TodolistFragment";
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
}
