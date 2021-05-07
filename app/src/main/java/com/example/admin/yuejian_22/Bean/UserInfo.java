package com.example.admin.yuejian_22.Bean;

/**
 * Created by Admin on 2017/9/26.
 */

public class UserInfo {
//    {
//        "user_name": "18041175762",
//            "photo": "club/thumb/20160708/thumb_20160708030348_1348465802.JPG",
//            "shaitunum": "7",
//            "messagenum": "0",
//            "focusnum": "0"
//    }
private String user_id;
    private String username;
    private String photo;
    private String shaitunum;

    public String getFocusnum() {
        return focusnum;
    }

    public void setFocusnum(String focusnum) {
        this.focusnum = focusnum;
    }

    public String getMessagenum() {
        return messagenum;
    }

    public void setMessagenum(String messagenum) {
        this.messagenum = messagenum;
    }

    public String getPhoto() {
        return photo;
    }

    public void setPhoto(String photo) {
        this.photo = photo;
    }

    public String getShaitunum() {
        return shaitunum;
    }

    public void setShaitunum(String shaitunum) {
        this.shaitunum = shaitunum;
    }

    public String getUser_id() {
        return user_id;
    }

    public void setUser_id(String user_id) {
        this.user_id = user_id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    private String messagenum;
    private String focusnum;



}
