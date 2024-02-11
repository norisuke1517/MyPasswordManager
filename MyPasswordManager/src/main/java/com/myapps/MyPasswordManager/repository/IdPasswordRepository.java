package com.myapps.MyPasswordManager.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.myapps.MyPasswordManager.model.IdPassword;

@Repository
public interface IdPasswordRepository extends JpaRepository<IdPassword, Integer> {

    IdPassword findBySiteApplicationName(String siteApplicationName);

    List<IdPassword> findByUserId(String userId);

    List<IdPassword> findByPassword(String password);

    void deleteBySiteApplicationName(String siteApplicationName);

}