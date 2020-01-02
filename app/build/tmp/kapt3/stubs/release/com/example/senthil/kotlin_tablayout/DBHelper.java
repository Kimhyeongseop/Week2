package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0004\u0018\u0000 \u00172\u00020\u0001:\u0001\u0017B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u000e\u0010\u000e\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007J\u0012\u0010\u000f\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u0016J\"\u0010\u0012\u001a\u00020\f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0013\u001a\u00020\u00142\u0006\u0010\u0015\u001a\u00020\u0014H\u0016J\u000e\u0010\u0016\u001a\u00020\u00142\u0006\u0010\r\u001a\u00020\u0007R!\u0010\u0005\u001a\u0012\u0012\u0004\u0012\u00020\u00070\u0006j\b\u0012\u0004\u0012\u00020\u0007`\b8F\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0018"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/DBHelper;", "Landroid/database/sqlite/SQLiteOpenHelper;", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dbList", "Ljava/util/ArrayList;", "Lcom/example/senthil/kotlin_tablayout/Consumption;", "Lkotlin/collections/ArrayList;", "getDbList", "()Ljava/util/ArrayList;", "addConsumption", "", "consumption", "deleteConsumption", "onCreate", "db", "Landroid/database/sqlite/SQLiteDatabase;", "onUpgrade", "oldVersion", "", "newVersion", "updateConsumption", "Companion", "app_release"})
public final class DBHelper extends android.database.sqlite.SQLiteOpenHelper {
    private static final int DATABASE_VER = 1;
    private static final java.lang.String DATABASE_NAME = "ACCOUNTBOOK.db";
    private static final java.lang.String TABLE_NAME = "ACCOUNT";
    private static final java.lang.String ID = "Id";
    private static final java.lang.String MONEY = "Money";
    private static final java.lang.String PM = "Pm";
    private static final java.lang.String USAGE = "Usage";
    private static final java.lang.String TIME = "Time";
    public static final com.example.senthil.kotlin_tablayout.DBHelper.Companion Companion = null;
    
    @java.lang.Override()
    public void onCreate(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db) {
    }
    
    @java.lang.Override()
    public void onUpgrade(@org.jetbrains.annotations.Nullable()
    android.database.sqlite.SQLiteDatabase db, int oldVersion, int newVersion) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.senthil.kotlin_tablayout.Consumption> getDbList() {
        return null;
    }
    
    public final void addConsumption(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.Consumption consumption) {
    }
    
    public final int updateConsumption(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.Consumption consumption) {
        return 0;
    }
    
    public final void deleteConsumption(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.Consumption consumption) {
    }
    
    public DBHelper(@org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super(null, null, null, 0);
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\b\n\u0002\b\u0007\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\t\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u000b\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/DBHelper$Companion;", "", "()V", "DATABASE_NAME", "", "DATABASE_VER", "", "ID", "MONEY", "PM", "TABLE_NAME", "TIME", "USAGE", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}