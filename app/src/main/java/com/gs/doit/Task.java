package com.gs.doit;

import com.google.auto.value.AutoValue;

@AutoValue
public abstract class Task {
    public static Task with(String title) {
        return new AutoValue_Task(title);
    }

    public abstract String title();

    public abstract Task withTitle(String title);
}
