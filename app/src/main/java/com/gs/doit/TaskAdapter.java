package com.gs.doit;

import android.databinding.DataBindingUtil;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.ViewGroup;

import com.gs.doit.databinding.ListItemTaskBinding;

import org.pcollections.PVector;

public class TaskAdapter extends RecyclerView.Adapter<TaskViewHolder> {

    private final LayoutInflater mInflater;
    private PVector<Task> mTasks;

    public TaskAdapter(LayoutInflater inflater, PVector<Task> initTasks) {
        mInflater = inflater;
        mTasks = initTasks;
        setHasStableIds(true);
    }

    public void swapTasks(PVector<Task> newTasks) {
        mTasks = newTasks;
        notifyDataSetChanged();
    }

    @Override
    public long getItemId(int position) {
        return position ;
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
