package com.wq.wqnetwork;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import com.wq.wqnetwork.bean.UserBean;
import com.wq.wqnetwork.constants.VivianUrls;
import com.wq.wqnetwork.response.ResponseCallBack;
import com.wq.wqnetwork.response.RoNetWorkUtil;
import com.wq.wqnetwork.util.NetWorkLogUtil;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RoNetWorkUtil
                .getInstance()
                .get(VivianUrls.TEST_GET_ALL_USER)
                .params("")
                .execute(new ResponseCallBack<UserBean>() {
                    @Override
                    public void onResponseSuccess(UserBean response) {

                    }
                });
    }

}
