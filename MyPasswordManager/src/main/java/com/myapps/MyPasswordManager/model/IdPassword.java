package com.myapps.MyPasswordManager.model;

import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.Table;

@Entity
@Table(name = "ids_passwords")
public class IdPassword extends CommonIdPassword {
    /**
     * site_application_name
     */
    @Column(name = "site_application_name")
    private String siteApplicationName;

    /**
     * user_id
     */
    @Column(name = "user_id")
    private String userId;

    /**
     * password
     */
    @Column(name = "password")
    private String password;

    // 空のコンストラクタ
    public IdPassword() {
    }

    // コンストラクタ
    public IdPassword(String siteApplicationName, String userId, String password) {
        this.siteApplicationName = siteApplicationName;
        this.userId = userId;
        this.password = password;
    }

    // getter, setter
    public String getSiteApplicationName() {
        return siteApplicationName;
    }

    public void setSiteApplicationName(String siteApplicationName) {
        this.siteApplicationName = siteApplicationName;
    }

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
