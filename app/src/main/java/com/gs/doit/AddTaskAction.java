package com.gs.doit;

import org.pcollections.PVector;

public class AddTaskAction implements Action<PVector<Task>> {
    private final Task mNewTask;

    public AddTaskAction(Task newTask) {
        mNewTask = newTask;
    }

    @Override
    public PVector<Task> apply(PVector<Task> oldValue) {
        return oldValue.plus(mNewTask);
    }
}
