package gc.com.todoapp.todo;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import gc.com.todoapp.R;

/**
 * Created by jyin on 3/30/18.
 */

public class TodoFragment extends Fragment implements TodoContract.View {

    private static final String TAG = "TodoFragment";
    private TodoContract.Presenter m_presenter;
    private TextView m_title;

    public static TodoFragment newInstance() {
        return new TodoFragment();
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        TextView textView = getActivity().findViewById(R.id.tv_confirm);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "click confirm " + m_title.getText());
                m_presenter.saveTodolist(m_title.getText().toString());
            }
        });

        textView = getActivity().findViewById(R.id.tv_cancel);
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "click cancel");
                finishTodolist();
            }
        });


    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_todo, container, false);
        Log.e(TAG, "TodoFragment create");
        m_title = root.findViewById(R.id.et_title);
        return root;
    }

    @Override
    public void setPresenter(TodoContract.Presenter presenter) {
        m_presenter = presenter;
    }

    @Override
    public void showTasksList() {
        finishTodolist();
    }

    @Override
    public void setTitle(String title) {
        m_title.setText(title);
    }

    private void finishTodolist() {
        getActivity().setResult(Activity.RESULT_OK);
        getActivity().finish();
    }
}
