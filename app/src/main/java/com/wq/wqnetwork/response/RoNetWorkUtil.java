package com.wq.wqnetwork.response;

import com.wq.wqnetwork.VivianHttpUtil;
import com.wq.wqnetwork.util.NetWorkLogUtil;

import rx.Observable;
import rx.Subscriber;
import rx.android.schedulers.AndroidSchedulers;
import rx.schedulers.Schedulers;

/**
 * Created by vivianWQ on 2017/11/22
 * Mail: wangqi_vivian@sina.com
 * desc:
 * Version: 1.0
 */
public class RoNetWorkUtil {

    private static RoNetWorkUtil roNetWorkUtil;

    public RoNetWorkUtil() {
    }

    public static RoNetWorkUtil getInstance() {
        if (roNetWorkUtil == null)
            roNetWorkUtil = new RoNetWorkUtil();
        return roNetWorkUtil;
    }

    public RoNetWorkUtil get(String url) {
        this.url = url;
        return this;
    }

    public RoNetWorkUtil params(String params) {
        this.params = params;
        return this;
    }

    private String url;
    private String params;

    public String getParams() {
        return params;
    }

    public String getUrl() {
        return url;

    }

    public void execute(ResponseCallBack responseCallBack) {
        doGetUrl(getUrl(), getParams(), responseCallBack);
    }

    private void doGetUrl(final String url, String params, final ResponseCallBack responseCallBack) {
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
                        NetWorkLogUtil.i(s);

                        responseCallBack.onSuccess(s);
                        onCompleted();

                    }
                });
    }
}
