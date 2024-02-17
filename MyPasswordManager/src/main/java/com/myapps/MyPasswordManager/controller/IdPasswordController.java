package com.myapps.MyPasswordManager.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.myapps.MyPasswordManager.model.IdPassword;
import com.myapps.MyPasswordManager.service.IdPasswordService;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

@RestController
@RequestMapping("/api/passwords")
public class IdPasswordController {

    private final IdPasswordService idPasswordService;

    public IdPasswordController(IdPasswordService idPasswordService) {
        this.idPasswordService = idPasswordService;
    }

    @GetMapping
    public List<IdPassword> getAllPasswords() {
        return idPasswordService.getAllPasswords();
    }

    @GetMapping("/{siteApplicationName}")
    public ResponseEntity<IdPassword> getIdPasswordBySiteApplicationName(@PathVariable String siteApplicationName) {
        IdPassword idPassword = idPasswordService.getIdPasswordBySiteApplicationName(siteApplicationName);
        return ResponseEntity.ok(idPassword);
    }

    @GetMapping("/user/{userId}")
    public List<IdPassword> getSiteApplicationNamePasswordById(@PathVariable String userId) {
        return idPasswordService.getSiteApplicationNamePasswordById(userId);
    }

    @GetMapping("/password/{password}")
    public List<IdPassword> getSiteApplicationNameIdByPassword(@PathVariable String password) {
        return idPasswordService.getSiteApplicationNameIdByPassword(password);
    }

    @PostMapping
    public ResponseEntity<IdPassword> registerPassword(@RequestBody IdPassword idPassword) {
        IdPassword registeredPassword = idPasswordService.registerPassword(idPassword);
        return new ResponseEntity<>(registeredPassword, HttpStatus.CREATED);
    }

    @DeleteMapping("/{siteApplicationName}")
    public ResponseEntity<Void> deletePassword(@PathVariable String siteApplicationName) {
        idPasswordService.deletePassword(siteApplicationName);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/restore/{siteApplicationName}")
    public ResponseEntity<Void> restoreDeletedPassword(@PathVariable String siteApplicationName) {
        idPasswordService.restoredDeletedPassword(siteApplicationName);
        return ResponseEntity.ok().build();
    }
}
