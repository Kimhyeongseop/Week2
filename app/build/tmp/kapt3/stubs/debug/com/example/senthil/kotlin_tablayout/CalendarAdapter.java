package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\b\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\n\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\u0018\u00002\b\u0012\u0004\u0012\u00020\u00020\u0001B-\u0012\u0006\u0010\u0003\u001a\u00020\u0004\u0012\u001e\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\u0002\u0010\tJ\u0006\u0010\u000e\u001a\u00020\bJ\u0006\u0010\u000f\u001a\u00020\bJ\b\u0010\u0010\u001a\u00020\u0007H\u0016J\u0018\u0010\u0011\u001a\u00020\b2\u0006\u0010\u0012\u001a\u00020\u00022\u0006\u0010\u0013\u001a\u00020\u0007H\u0016J\u0018\u0010\u0014\u001a\u00020\u00022\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0007H\u0016J\u0010\u0010\u0018\u001a\u00020\b2\u0006\u0010\u0019\u001a\u00020\u001aH\u0002R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R)\u0010\u0005\u001a\u001a\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\u0007\u0012\u0004\u0012\u00020\b0\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u000e\u0010\u0003\u001a\u00020\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001b"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/CalendarAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/example/senthil/kotlin_tablayout/ViewHolderHelper;", "mainActivity", "Lcom/example/senthil/kotlin_tablayout/Fragment/AccountBookFragment;", "itemClick", "Lkotlin/Function3;", "", "", "(Lcom/example/senthil/kotlin_tablayout/Fragment/AccountBookFragment;Lkotlin/jvm/functions/Function3;)V", "baseCalendar", "Lcom/example/senthil/kotlin_tablayout/BaseCalendar;", "getItemClick", "()Lkotlin/jvm/functions/Function3;", "changeToNextMonth", "changeToPrevMonth", "getItemCount", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "refreshView", "calendar", "Landroid/icu/util/Calendar;", "app_debug"})
public final class CalendarAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.example.senthil.kotlin_tablayout.ViewHolderHelper> {
    private final com.example.senthil.kotlin_tablayout.BaseCalendar baseCalendar = null;
    private final com.example.senthil.kotlin_tablayout.Fragment.AccountBookFragment mainActivity = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, java.lang.Integer, kotlin.Unit> itemClick = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.senthil.kotlin_tablayout.ViewHolderHelper onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.ViewHolderHelper holder, int position) {
    }
    
    public final void changeToPrevMonth() {
    }
    
    public final void changeToNextMonth() {
    }
    
    private final void refreshView(android.icu.util.Calendar calendar) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function3<java.lang.Integer, java.lang.Integer, java.lang.Integer, kotlin.Unit> getItemClick() {
        return null;
    }
    
    public CalendarAdapter(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.Fragment.AccountBookFragment mainActivity, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function3<? super java.lang.Integer, ? super java.lang.Integer, ? super java.lang.Integer, kotlin.Unit> itemClick) {
        super();
    }
}