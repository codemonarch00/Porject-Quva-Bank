package com.example.zoomnride;

import androidx.room.Entity;
import androidx.room.PrimaryKey;

@Entity(tableName = "Register_table")
public class Register {

    @PrimaryKey(autoGenerate = true)
    public int id;

    public String Username;

    public String UserEmail;

    public String Phone;

    public String UserCountry;

    public String UserState;

    public String UserPassword;

    public Register(String Username, String UserEmail, String Phone, String UserCountry, String UserState, String UserPassword) {
        this.Username = Username;
        this.UserEmail = UserEmail;
        this.Phone = Phone;
        this.UserCountry = UserCountry;
        this.UserState = UserState;
        this.UserPassword = UserPassword;
    }

    public int getId() {
        return id;
    }

    public String getUsername() {
        return Username;
    }

    public String getUserEmail() {
        return UserEmail;
    }

    public String getPhone() {
        return Phone;
    }

    public String getUserCountry() {
        return UserCountry;
    }

    public String getUserState() {
        return UserState;
    }

    public String getUsePassword() {
        return UserPassword;
    }

    public void setId(int id) {
        this.id = id;
    }
}
