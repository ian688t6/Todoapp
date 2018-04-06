package gc.com.todoapp.task;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.TextView;

import com.daimajia.swipe.SwipeLayout;
import com.raizlabs.android.dbflow.sql.language.SQLite;

import java.util.List;

import gc.com.todoapp.R;
import gc.com.todoapp.db.TodoData;
import gc.com.todoapp.db.TodoData_Table;

public class TodoAdapter<Data> extends RecyclerView.Adapter<TodoAdapter.TodolistViewHolder<Data>> {

    private Context m_context;
    private List<Data> m_list;
    private static final String TAG = "TodolistAdapter";

    public TodoAdapter(Context context, List<Data> list) {
        m_context = context;
        m_list = list;
    }

    public void updateData() {
        Log.e(TAG, "updateData");
        notifyDataSetChanged();
    }

    public void replaceData(List<Data> list) {
        m_list = list;
        notifyDataSetChanged();
    }

    @Override
    public TodolistViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_context).inflate(R.layout.listitem, parent, false);
        return new TodolistViewHolder(view);
    }

    @Override
    public void onBindViewHolder(final TodolistViewHolder holder, final int position) {
        final TodoData data = (TodoData) m_list.get(position);
        holder.textView.setText(data.m_title);
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

                SQLite.delete()
                        .from(TodoData.class)
                        .where(TodoData_Table.id.eq(data.id))
                        .query();
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

    public static class TodolistViewHolder<Data> extends RecyclerView.ViewHolder {
        private SwipeLayout swipeLayout;
        private ImageView imageView;
        private ImageButton imageButtonDelete;
        private ImageButton imageButtonSettings;
        private TextView textView;

        public TodolistViewHolder(View itemView) {
            super(itemView);
            swipeLayout = itemView.findViewById(R.id.swipe_layout);
            imageView = itemView.findViewById(R.id.img_list);
            textView = itemView.findViewById(R.id.text_title);
            imageButtonDelete = itemView.findViewById(R.id.btn_del);
            imageButtonSettings = itemView.findViewById(R.id.btn_settings);
        }
    }
}
