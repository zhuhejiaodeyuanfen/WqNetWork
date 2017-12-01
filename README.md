# WqNetWork #
自定义网络连接库,功能及实现较简单,后期会逐渐完善功能

```java
 RoNetWorkUtil
                .getInstance()
                .get(VivianUrls.TEST_GET_ALL_USER)
                .params("")
                .execute(new ResponseCallBack<UserBean>() {
                    @Override
                    public void onResponseSuccess(UserBean response) {

                    }
                });
               ```
