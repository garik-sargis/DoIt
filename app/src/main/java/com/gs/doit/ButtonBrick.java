package com.gs.doit;

import android.content.Context;
import android.view.View;
import android.widget.Button;

import rx.Observable;
import rx.subjects.PublishSubject;

public class ButtonBrick {

    private final Button mButton;
    private final PublishSubject<Unit> mClickSubject;
    
    private ButtonBrick(Context context) {
        mButton = new Button(context);
        mClickSubject = PublishSubject.create();
        mButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                mClickSubject.onNext(Unit.UNIT);
            }
        });
    }

    public Button getView() {
        return mButton;
    }
    
    public Observable<Unit> events() {
        return mClickSubject;
    }
}
