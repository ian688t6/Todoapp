package gc.com.todoapp;

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

import java.util.ArrayList;
import java.util.HashMap;

/**
 * Created by jyin on 3/29/18.
 */

public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.TodoViewHolder> {
    private static final String TAG = "TodoAdapter";
    public static final String TITLE = "title";
    private ArrayList<HashMap<String, Object>> m_list;
    private Context m_context;
    public TodoAdapter(Context context, ArrayList<HashMap<String, Object>> list) {
        m_list = list;
        m_context = context;
    }

    @Override
    public TodoViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(m_context).inflate(R.layout.listitem, parent, false);
        return new TodoViewHolder(view);
    }

    @Override
    public void onBindViewHolder(TodoViewHolder holder, int position) {
        holder.textView.setText(m_list.get(position).get(TITLE).toString());
        holder.imageButtonSettings.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "imageButtonSettings click");
            }
        });
        holder.imageButtonDelete.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "imageButtonDelete click");
            }
        });
    }

    @Override
    public int getItemCount() {
        return m_list.size();
    }

    public static class TodoViewHolder extends RecyclerView.ViewHolder {

        private SwipeLayout swipeLayout;
        private ImageView imageView;
        private ImageButton imageButtonDelete;
        private ImageButton imageButtonSettings;
        private TextView textView;

        public TodoViewHolder(View itemView) {
            super(itemView);
            swipeLayout = itemView.findViewById(R.id.swipe_layout);
            imageView = itemView.findViewById(R.id.img_list);
            textView = itemView.findViewById(R.id.text_title);
            imageButtonDelete = itemView.findViewById(R.id.btn_del);
            imageButtonSettings = itemView.findViewById(R.id.btn_settings);
        }
    }
}
