package com.gs.doit;

public interface Action<T> {
    T apply(T oldValue);
}
