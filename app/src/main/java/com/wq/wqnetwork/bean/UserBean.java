package com.wq.wqnetwork.bean;

import java.util.List;

/**
 * Created by vivianWQ on 2017/11/24
 * Mail: wangqi_vivian@sina.com
 * desc:
 * Version: 1.0
 */
public class UserBean {


    /**
     * code : 100
     * data : [{"email":"11","id":1,"passWord":"123456","username":"vivian"},{"email":"333","id":2,"passWord":"333","username":"sssss"},{"email":"33","id":3,"passWord":"44","username":"3333"},{"email":"43","id":4,"passWord":"1","username":"mytest"},{"email":"33","id":5,"passWord":"444","username":"intddfs"},{"email":"444","id":6,"passWord":"44","username":"jack"}]
     */

    private int code;
    private List<DataBean> data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public List<DataBean> getData() {
        return data;
    }

    public void setData(List<DataBean> data) {
        this.data = data;
    }

    public static class DataBean {
        /**
         * email : 11
         * id : 1
         * passWord : 123456
         * username : vivian
         */

        private String email;
        private int id;
        private String passWord;
        private String username;

        public String getEmail() {
            return email;
        }

        public void setEmail(String email) {
            this.email = email;
        }

        public int getId() {
            return id;
        }

        public void setId(int id) {
            this.id = id;
        }

        public String getPassWord() {
            return passWord;
        }

        public void setPassWord(String passWord) {
            this.passWord = passWord;
        }

        public String getUsername() {
            return username;
        }

        public void setUsername(String username) {
            this.username = username;
        }
    }
}
