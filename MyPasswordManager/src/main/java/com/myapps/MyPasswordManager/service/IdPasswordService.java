package com.myapps.MyPasswordManager.service;

import java.util.List;

import com.myapps.MyPasswordManager.model.IdPassword;

public interface IdPasswordService {
    List<IdPassword> getAllPasswords();

    IdPassword getIdPasswordBySiteApplicationName(String siteApplicationName);

    List<IdPassword> getSiteApplicationNamePasswordById(String userId);

    List<IdPassword> getSiteApplicationNameIdByPassword(String password);

    IdPassword registerPassword(IdPassword idPassword);

    void deletePassword(String siteApplicationName);

    void restoredDeletedPassword(String siteApplicationName);
}