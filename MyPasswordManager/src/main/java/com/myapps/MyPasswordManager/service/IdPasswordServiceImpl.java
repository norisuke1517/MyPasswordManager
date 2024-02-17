package com.myapps.MyPasswordManager.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Service;

import com.myapps.MyPasswordManager.model.IdPassword;
import com.myapps.MyPasswordManager.repository.IdPasswordRepository;

import jakarta.transaction.Transactional;

@Service
@Transactional
public class IdPasswordServiceImpl implements IdPasswordService {

    private final IdPasswordRepository idPasswordRepository;
    private final List<IdPassword> deletedPasswords;

    public IdPasswordServiceImpl(IdPasswordRepository idPasswordRepository) {
        this.idPasswordRepository = idPasswordRepository;
        this.deletedPasswords = new ArrayList<>();
    }

    @Override
    public List<IdPassword> getAllPasswords() {
        return idPasswordRepository.findAll();
    }

    @Override
    public IdPassword getIdPasswordBySiteApplicationName(String siteApplicationName) {
        return idPasswordRepository.findBySiteApplicationName(siteApplicationName);
    }

    @Override
    public List<IdPassword> getSiteApplicationNamePasswordById(String userId) {
        return idPasswordRepository.findByUserId(userId);
    }

    @Override
    public List<IdPassword> getSiteApplicationNameIdByPassword(String password) {
        return idPasswordRepository.findByPassword(password);
    }

    @SuppressWarnings("null")
    @Override
    public IdPassword registerPassword(IdPassword idPassword) {
        return idPasswordRepository.save(idPassword);
    }

    @Override
    public void deletePassword(String siteApplicationName) {
        IdPassword deletedPassword = idPasswordRepository.findBySiteApplicationName(siteApplicationName);
        if (deletedPassword != null) {
            idPasswordRepository.deleteBySiteApplicationName(siteApplicationName);
            deletedPasswords.add(deletedPassword);
        }
    }

    @Override
    public void restoredDeletedPassword(String siteApplicationName) {
        // 削除されたパスワードを取得
        IdPassword deletedPassword = deletedPasswords.stream()
                .filter(password -> password.getSiteApplicationName().equals(siteApplicationName))
                .findFirst()
                .orElse(null);

        // 削除されたパスワードが存在する場合
        if (deletedPassword != null) {
            // パスワードをデータベースに保存
            idPasswordRepository.save(deletedPassword);

            // メモリ上の削除済みリストからも削除
            deletedPasswords.remove(deletedPassword);
        }
    }

}
