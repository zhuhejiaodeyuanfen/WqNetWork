package com.wq.wqnetwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wq.wqnetwork.constants.VivianUrls;
import com.wq.wqnetwork.response.ResponseCallBack;
import com.wq.wqnetwork.response.RoNetWorkUtil;
import com.wq.wqnetwork.testbean.BaiduBean1;
import com.wq.wqnetwork.util.NetWorkLogUtil;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoNetWorkUtil
                .getInstance()
                .get(VivianUrls.TEST_URL1)
                .params("")
                .execute(new ResponseCallBack<BaiduBean1>() {
                    @Override
                    public void onResponseSuccess(BaiduBean1 response) {

                        NetWorkLogUtil.i(response.getCopyrights());
                    }
                });
    }

}
