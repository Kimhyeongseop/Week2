package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u000b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\b\u0018\u0000 $2\u00020\u0001:\u0001$B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001a\u0010\u001a\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001dJ\u001a\u0010\u001e\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001dJ\u001a\u0010\u001f\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001dJ\u0010\u0010 \u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002J\u001c\u0010!\u001a\u00020\u001b2\u0012\u0010\u001c\u001a\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u001b0\u001dH\u0002J\b\u0010\"\u001a\u00020\u001bH\u0002J\u0010\u0010#\u001a\u00020\u001b2\u0006\u0010\u0003\u001a\u00020\u0004H\u0002R\u0019\u0010\u0003\u001a\n \u0005*\u0004\u0018\u00010\u00040\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0006\u0010\u0007R\u001a\u0010\b\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\n\u0010\u000b\"\u0004\b\f\u0010\rR \u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\t0\u000fX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0010\u0010\u0011\"\u0004\b\u0012\u0010\u0013R\u001a\u0010\u0014\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0015\u0010\u000b\"\u0004\b\u0016\u0010\rR\u001a\u0010\u0017\u001a\u00020\tX\u0086\u000e\u00a2\u0006\u000e\n\u0000\u001a\u0004\b\u0018\u0010\u000b\"\u0004\b\u0019\u0010\r\u00a8\u0006%"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/BaseCalendar;", "", "()V", "calendar", "Landroid/icu/util/Calendar;", "kotlin.jvm.PlatformType", "getCalendar", "()Landroid/icu/util/Calendar;", "currentMonthMaxDate", "", "getCurrentMonthMaxDate", "()I", "setCurrentMonthMaxDate", "(I)V", "data", "Ljava/util/ArrayList;", "getData", "()Ljava/util/ArrayList;", "setData", "(Ljava/util/ArrayList;)V", "nextMonthHeadOffset", "getNextMonthHeadOffset", "setNextMonthHeadOffset", "prevMonthTailOffset", "getPrevMonthTailOffset", "setPrevMonthTailOffset", "changeToNextMonth", "", "refreshCallback", "Lkotlin/Function1;", "changeToPrevMonth", "initBaseCalendar", "makeCurrentMonth", "makeMonthDate", "makeNextMonthHead", "makePrevMonthTail", "Companion", "app_release"})
public final class BaseCalendar {
    private final android.icu.util.Calendar calendar = null;
    private int prevMonthTailOffset;
    private int nextMonthHeadOffset;
    private int currentMonthMaxDate;
    @org.jetbrains.annotations.NotNull()
    private java.util.ArrayList<java.lang.Integer> data;
    public static final int DAYS_OF_WEEK = 7;
    public static final int LOW_OF_CALENDAR = 6;
    public static final com.example.senthil.kotlin_tablayout.BaseCalendar.Companion Companion = null;
    
    public final android.icu.util.Calendar getCalendar() {
        return null;
    }
    
    public final int getPrevMonthTailOffset() {
        return 0;
    }
    
    public final void setPrevMonthTailOffset(int p0) {
    }
    
    public final int getNextMonthHeadOffset() {
        return 0;
    }
    
    public final void setNextMonthHeadOffset(int p0) {
    }
    
    public final int getCurrentMonthMaxDate() {
        return 0;
    }
    
    public final void setCurrentMonthMaxDate(int p0) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<java.lang.Integer> getData() {
        return null;
    }
    
    public final void setData(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<java.lang.Integer> p0) {
    }
    
    /**
     * Init calendar.
     */
    public final void initBaseCalendar(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.icu.util.Calendar, kotlin.Unit> refreshCallback) {
    }
    
    /**
     * Change to prev month.
     */
    public final void changeToPrevMonth(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.icu.util.Calendar, kotlin.Unit> refreshCallback) {
    }
    
    /**
     * Change to next month.
     */
    public final void changeToNextMonth(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super android.icu.util.Calendar, kotlin.Unit> refreshCallback) {
    }
    
    /**
     * make month date.
     */
    private final void makeMonthDate(kotlin.jvm.functions.Function1<? super android.icu.util.Calendar, kotlin.Unit> refreshCallback) {
    }
    
    /**
     * Generate data for the last month displayed before the first day of the current calendar.
     */
    private final void makePrevMonthTail(android.icu.util.Calendar calendar) {
    }
    
    /**
     * Generate data for the current calendar.
     */
    private final void makeCurrentMonth(android.icu.util.Calendar calendar) {
    }
    
    /**
     * Generate data for the next month displayed before the last day of the current calendar.
     */
    private final void makeNextMonthHead() {
    }
    
    public BaseCalendar() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\u0014\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0086T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0006"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/BaseCalendar$Companion;", "", "()V", "DAYS_OF_WEEK", "", "LOW_OF_CALENDAR", "app_release"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}