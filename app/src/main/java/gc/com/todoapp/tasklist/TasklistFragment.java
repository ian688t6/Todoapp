package gc.com.todoapp.tasklist;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import java.util.List;

import gc.com.todoapp.R;
import gc.com.todoapp.db.TaskData;

public class TasklistFragment extends Fragment implements TasklistContract.View {
    private TasklistContract.Presenter m_presenter;
    private boolean m_editfinish = false;
    private TextView m_textEdit;
    private EditText m_titleText;
    private static final String TAG = "TasklistFragment";

    public static TasklistFragment newInstance() {
        return new TasklistFragment();
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.e(TAG, "onCreate");

    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        Log.e(TAG, "onViewCreated");
        if (m_presenter != null) {
            List<TaskData>list =  m_presenter.queryTasklist(((TasklistActivity)getActivity()).getId());
            for (TaskData t : list) {
                Log.e(TAG, t.toString());
            }
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
        m_textEdit = root.findViewById(R.id.tv_edit);
        m_textEdit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "click edit");
                if (m_editfinish) {
                    String title = m_titleText.getText().toString();
                    m_titleText.setText(null);
                    m_titleText.clearFocus();
                    Log.e(TAG, "title: " + title);
                }
            }
        });
        m_titleText = root.findViewById(R.id.newtask_title);
        m_titleText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                if (hasFocus) {
                    Log.e(TAG, "hasfocus true");
                    m_textEdit.setText("Add");
                } else {
                    Log.e(TAG, "hasfocus false");
                }
            }
        });
        m_titleText.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                Log.e(TAG, "beforeTextChanged");
                m_editfinish = false;
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                Log.e(TAG, "onTextChanged");
            }

            @Override
            public void afterTextChanged(Editable s) {
                Log.e(TAG, "afterTextChanged");
                m_editfinish = true;
            }
        });

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
