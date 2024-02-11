package com.myapps.MyPasswordManager.model;

import java.security.Timestamp;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.MappedSuperclass;

/**
 * 共通エンティティ
 */
@MappedSuperclass
public class CommonIdPassword {
    /**
     * ID
     */
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    /**
     * created_at
     */
    @Column(name = "created_at")
    private Timestamp createdAt;

    /**
     * updated_at
     */
    @Column(name = "updated_at")
    private Timestamp updatedAt;

    // 空のコンストラクタ
    public CommonIdPassword() {
    }

    // setter, getter
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Timestamp getCreatedAt() {
        return createdAt;
    }

    public void setCreatedAt(Timestamp createdAt) {
        this.createdAt = createdAt;
    }

    public Timestamp getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(Timestamp updatedAt) {
        this.updatedAt = updatedAt;
    }
}
