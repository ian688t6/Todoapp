package gc.com.todoapp.tasklist;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CheckBox;
import android.widget.ImageButton;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import gc.com.todoapp.R;
import gc.com.todoapp.db.TaskData;
import gc.com.todoapp.db.TodoData;
import gc.com.todoapp.db.TodoData_Table;

public class TasklistAdapter<Data> extends RecyclerView.Adapter<TasklistAdapter.TasklistViewHolder<Data>> {
    private Context m_context;
    private List<Data> m_list;
    private TasklistAdapterCallback m_callback;
    private static final String TAG = "TasklistAdapter";

    public TasklistAdapter(Context context, List<Data> list) {
        m_context = context;
        m_list = list;
    }


    public void setCallback(TasklistAdapterCallback callback) {
        m_callback = callback;
    }

    public void replaceData(List<Data> list) {
        m_list = list;
        notifyDataSetChanged();
    }

    @Override
    public TasklistViewHolder<Data> onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_context).inflate(R.layout.tasklist_item, parent, false);
        TasklistViewHolder holder = new TasklistViewHolder(view);

        return holder;
    }

    @Override
    public void onBindViewHolder(final TasklistViewHolder<Data> holder, final int position) {
        final TaskData data = (TaskData) m_list.get(position);
        holder.textView.setText(data.title);

        Log.e(TAG, "task: " + data.title);

        holder.imageButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "imageButtonSettings click " + holder.textView.getText());
            }
        });
        holder.imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "imageButtonDelete click " + holder.textView.getText());
                if (m_callback != null) {
                    m_callback.itemDelete(position);
                }
                m_list.remove(position);
                notifyDataSetChanged();
            }
        });

    }

    @Override
    public int getItemViewType(int position) {
        return super.getItemViewType(position);
    }

    @Override
    public int getItemCount() {
        return m_list.size();
    }


    public interface TasklistAdapterCallback<Data> {
        void onClick(Data data);
        void itemDelete(int position);
    }


    public static class TasklistViewHolder<Data> extends  RecyclerView.ViewHolder {

        private ImageButton imageButtonDelete;
        private ImageButton imageButtonSettings;
        private CheckBox checkBox;
        private TextView textView;


        public TasklistViewHolder(View itemView) {
            super(itemView);

            checkBox = itemView.findViewById(R.id.tasklist_cb);
            textView = itemView.findViewById(R.id.tasklist_title);
            imageButtonSettings = itemView.findViewById(R.id.btn_tasklist_settings);
            imageButtonDelete = itemView.findViewById(R.id.btn_tasklist_del);
        }
    }
}
