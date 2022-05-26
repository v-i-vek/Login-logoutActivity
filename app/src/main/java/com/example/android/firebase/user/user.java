package com.example.android.firebase.user;

public class user {
    String profilePic,Email,Password,userName,userId,lastMessage;

    public user(String profilePic, String email, String password, String userName, String userId, String lastMessage) {
        this.profilePic = profilePic;
        Email = email;
        Password = password;
        this.userName = userName;
        this.userId = userId;
        this.lastMessage = lastMessage;
    }

    public user(){// defalut customer for fire base

    }


        // signup constructor
    public user(String userName,String Mail , String password){
        this.userName = userName;
        this.Password = password;
        this.Email = Mail;
    }


    public String getProfilePic() {
        return profilePic;
    }

    public String getEmail() {
        return Email;
    }

    public String getPassword() {
        return Password;
    }

    public String getUserName() {
        return userName;
    }

    public String getUserId(String key) {
        return userId;
    }

    public String getLastMessage() {
        return lastMessage;
    }
}
