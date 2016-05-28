package com.gs.doit;

import android.databinding.DataBindingUtil;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.LinearLayoutManager;
import android.view.View;

import com.gs.doit.databinding.ActivityMainBinding;

import org.pcollections.PVector;
import org.pcollections.TreePVector;

import java.util.Random;

import rx.functions.Action1;
import rx.observers.Subscribers;

public class MainActivity extends AppCompatActivity {

    private Store mStore;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        mStore = new Store(TreePVector.<Task>empty());

        final ActivityMainBinding binding =
                DataBindingUtil.setContentView(this, R.layout.activity_main);

        binding.setActivity(this);
        binding.taskList.setLayoutManager(new LinearLayoutManager(this));
        final TaskAdapter adapter = new TaskAdapter(getLayoutInflater(), TaskAdapter.TASKS);
        binding.taskList.setAdapter(adapter);

        setSupportActionBar(binding.appBar);

        mStore.stateSubject().subscribe(Subscribers.create(new Action1<PVector<Task>>() {
            @Override
            public void call(PVector<Task> tasks) {
                adapter.swapTasks(tasks);
            }
        }));
    }

    public void onFabClick(View fab) {
        Random rand = new Random();
        Task task = Task.with("Task #" + rand.nextInt(100));
        AddTaskAction action = new AddTaskAction(task);
        mStore.dispatch(action);
    }
}
