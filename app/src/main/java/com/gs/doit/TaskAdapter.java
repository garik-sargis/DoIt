package com.gs.doit;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gs.doit.databinding.ListItemTaskBinding;

import org.pcollections.PVector;
import org.pcollections.TreePVector;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    public static PVector<Task> TASKS = TreePVector.empty();

    static {
        for (int i = 0; i < 100; i++) {
            TASKS = TASKS.plus(Task.with("Title #" + i));
        }
    }

    private final LayoutInflater mInflater;
    private PVector<Task> mTasks;

    public TaskAdapter(LayoutInflater inflater, PVector<Task> initTasks) {
        mInflater = inflater;
        mTasks = initTasks;
    }

    public void swapTasks(PVector<Task> newTasks) {
        mTasks = newTasks;
        notifyDataSetChanged();
    }

    @Override
    public TaskViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        ListItemTaskBinding binding =
                DataBindingUtil.inflate(mInflater, R.layout.list_item_task, parent, false);
        return new TaskViewHolder(binding);
    }

    @Override
    public void onBindViewHolder(TaskViewHolder holder, int position) {
        ListItemTaskBinding binding = DataBindingUtil.findBinding(holder.itemView);
        binding.setTask(mTasks.get(position));
    }

    @Override
    public int getItemCount() {
        return mTasks.size();
    }
}
