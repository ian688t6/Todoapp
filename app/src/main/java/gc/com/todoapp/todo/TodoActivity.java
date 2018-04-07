package gc.com.todoapp.todo;

import android.support.annotation.NonNull;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.util.Log;
import android.view.Gravity;
import android.view.MenuItem;
import android.view.View;

import gc.com.todoapp.ActivityUtils;
import gc.com.todoapp.R;

public class TodoActivity extends AppCompatActivity {

    private DrawerLayout m_drawerLayout;
    private TodoPresenter m_presenter;
    private static final String TAG = "TodoActivity";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initToolbar();
        initTaskFragment();
        initFloatingActionButton();
//
//        List<TodoData> todoDataList = SQLite.select()
//                .from(TodoData.class)
//                .queryList();
//        for (TodoData t : todoDataList) {
//            android.util.Log.e("mf", "Queen=" + t);
//            for (TaskData task : t.tasks) {
//                android.util.Log.e("mf", "Ant=" + task);
//            }
//        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case android.R.id.home:
                m_drawerLayout.openDrawer(Gravity.START);
                return true;

            default:
                break;
        }
        return super.onOptionsItemSelected(item);
    }

    private void initToolbar() {
        Toolbar toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        ActionBar ab = getSupportActionBar();
        ab.setHomeAsUpIndicator(R.drawable.ic_navmenu);
        ab.setDisplayHomeAsUpEnabled(true);
        ab.setDisplayShowTitleEnabled(false);

        m_drawerLayout = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        if (navigationView != null) {
            setNavigationView(navigationView);
        }
    }

    private void setNavigationView(NavigationView navigationView) {
        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()) {
                    case R.id.nav_detail:
                        Log.e(TAG,"click nav detail");
                        break;

                    case R.id.nav_about:
                        Log.e(TAG, "click nav about");
                        break;

                    default:
                        break;
                }
                item.setChecked(true);
                m_drawerLayout.closeDrawers();
                return true;
            }
        });
    }

    private void initTaskFragment() {
        TodoFragment todoFragment = (TodoFragment) getSupportFragmentManager().findFragmentById(R.id.contentFrame);
        if (todoFragment == null) {
            todoFragment = TodoFragment.newInstance();
            ActivityUtils.addFragmentToActivity(getSupportFragmentManager(), todoFragment, R.id.contentFrame);
        }
        m_presenter = new TodoPresenter(todoFragment);
    }

    private void initFloatingActionButton() {
        FloatingActionButton fab = findViewById(R.id.fab);
        fab.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Log.e(TAG, "click fab");
                //m_presenter.addTodoList();
            }
        });
    }
}
