package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\"\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u00042\u0006\u0010\u0018\u001a\u00020\u00042\b\u0010\u0019\u001a\u0004\u0018\u00010\u001aH\u0014J\u0012\u0010\u001b\u001a\u00020\u00162\b\u0010\u001c\u001a\u0004\u0018\u00010\u001dH\u0014J\b\u0010\u001e\u001a\u00020\u0016H\u0014J\b\u0010\u001f\u001a\u00020\u0016H\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u001a\u0010\u0006\u001a\u00020\u0007X\u0080.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\b\u0010\t\"\u0004\b\n\u0010\u000bR\u001a\u0010\f\u001a\u00020\rX\u0086.\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u000e\u0010\u000f\"\u0004\b\u0010\u0010\u0011R\u0014\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00140\u0013X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006 "}, d2 = {"Lcom/example/senthil/kotlin_tablayout/Dialog;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "ADD_REQUEST", "", "EDIT_REQUEST", "db", "Lcom/example/senthil/kotlin_tablayout/DBHelper;", "getDb$app_release", "()Lcom/example/senthil/kotlin_tablayout/DBHelper;", "setDb$app_release", "(Lcom/example/senthil/kotlin_tablayout/DBHelper;)V", "dialogAdapter", "Lcom/example/senthil/kotlin_tablayout/DialogAdapter;", "getDialogAdapter", "()Lcom/example/senthil/kotlin_tablayout/DialogAdapter;", "setDialogAdapter", "(Lcom/example/senthil/kotlin_tablayout/DialogAdapter;)V", "listConsumptions", "", "Lcom/example/senthil/kotlin_tablayout/Consumption;", "onActivityResult", "", "requestCode", "resultCode", "data", "Landroid/content/Intent;", "onCreate", "savedInstanceState", "Landroid/os/Bundle;", "onRestart", "refreshData", "app_release"})
public final class Dialog extends android.support.v7.app.AppCompatActivity {
    @org.jetbrains.annotations.NotNull()
    public com.example.senthil.kotlin_tablayout.DBHelper db;
    @org.jetbrains.annotations.NotNull()
    public com.example.senthil.kotlin_tablayout.DialogAdapter dialogAdapter;
    private java.util.List<com.example.senthil.kotlin_tablayout.Consumption> listConsumptions;
    private int EDIT_REQUEST;
    private int ADD_REQUEST;
    private java.util.HashMap _$_findViewCache;
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.senthil.kotlin_tablayout.DBHelper getDb$app_release() {
        return null;
    }
    
    public final void setDb$app_release(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.DBHelper p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.example.senthil.kotlin_tablayout.DialogAdapter getDialogAdapter() {
        return null;
    }
    
    public final void setDialogAdapter(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.DialogAdapter p0) {
    }
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    @java.lang.Override()
    protected void onActivityResult(int requestCode, int resultCode, @org.jetbrains.annotations.Nullable()
    android.content.Intent data) {
    }
    
    private final void refreshData() {
    }
    
    @java.lang.Override()
    protected void onRestart() {
    }
    
    public Dialog() {
        super();
    }
}