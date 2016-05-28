package com.gs.doit;

import org.pcollections.PVector;

import rx.subjects.BehaviorSubject;

public class Store {

    private BehaviorSubject<PVector<Task>> mStateSubject;

    public Store(PVector<Task> initState) {
        mStateSubject = BehaviorSubject.create(initState);
    }

    public BehaviorSubject<PVector<Task>> stateSubject() {
        return mStateSubject;
    }

    public void dispatch(Action<PVector<Task>> action) {
        PVector<Task> newState = action.apply(mStateSubject.getValue());
        mStateSubject.onNext(newState);
    }
}
