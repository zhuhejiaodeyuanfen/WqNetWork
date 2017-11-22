package com.wq.wqnetwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;

import com.wq.wqnetwork.constants.VivianUrls;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        doGetUrl(VivianUrls.TEST_URL1);
    }

    public void doGetUrl(final String url) {
        Observable.create(new Observable.OnSubscribe<String>() {

            @Override
            public void call(Subscriber<? super String> subscriber) {
                String result = VivianHttpUtil.sendGet(url, "", "utf-8");
                subscriber.onNext(result);

            }
        }).observeOn(AndroidSchedulers.mainThread())//指定subscriber的回调发生在UI线程
                .subscribeOn(Schedulers.newThread())
                .subscribe(new Subscriber<String>() {
                    @Override
                    public void onCompleted() {

                    }

                    @Override
                    public void onError(Throwable e) {

                    }

                    @Override
                    public void onNext(String s) {
                        Log.i("doGetUrl2", "获得返回结果" + s);
                        onCompleted();
                    }
                });
    }
}
