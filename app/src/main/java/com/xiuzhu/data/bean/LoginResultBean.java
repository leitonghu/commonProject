package com.xiuzhu.data.bean;


public class LoginResultBean extends BaseBean {


    private String uid;
    private String access_token;
    private String expires_in;
    private String username;

    public LoginResultBean(String uid, String access_token, String expires_in, String username) {
        super();
        this.uid = uid;
        this.access_token = access_token;
        this.expires_in = expires_in;
        this.username = username;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public LoginResultBean() {
        super();
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getAccess_token() {
        return access_token;
    }

    public void setAccess_token(String access_token) {
        this.access_token = access_token;
    }

    public String getExpires_in() {
        return expires_in;
    }

    public void setExpires_in(String expires_in) {
        this.expires_in = expires_in;
    }


    @Override
    public String toString() {
        return "uid=" + uid +
                ",access_token=" + access_token +
                ",expires_in=" + expires_in +
                ",username=" + username;
    }
}
