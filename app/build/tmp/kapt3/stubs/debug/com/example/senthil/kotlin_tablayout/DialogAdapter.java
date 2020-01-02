package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\n\u0002\u0010\b\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0018B1\u0012\u0016\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u0012\u0012\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\u0002\u0010\nJ\b\u0010\u000f\u001a\u00020\u0010H\u0016J\u001c\u0010\u0011\u001a\u00020\t2\n\u0010\u0012\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0013\u001a\u00020\u0010H\u0016J\u001c\u0010\u0014\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0010H\u0016R\u001d\u0010\u0007\u001a\u000e\u0012\u0004\u0012\u00020\u0005\u0012\u0004\u0012\u00020\t0\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR!\u0010\u0003\u001a\u0012\u0012\u0004\u0012\u00020\u00050\u0004j\b\u0012\u0004\u0012\u00020\u0005`\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u0019"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/DialogAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/example/senthil/kotlin_tablayout/DialogAdapter$DialogHolder;", "items", "Ljava/util/ArrayList;", "Lcom/example/senthil/kotlin_tablayout/Consumption;", "Lkotlin/collections/ArrayList;", "click", "Lkotlin/Function1;", "", "(Ljava/util/ArrayList;Lkotlin/jvm/functions/Function1;)V", "getClick", "()Lkotlin/jvm/functions/Function1;", "getItems", "()Ljava/util/ArrayList;", "getItemCount", "", "onBindViewHolder", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "DialogHolder", "app_debug"})
public final class DialogAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.example.senthil.kotlin_tablayout.DialogAdapter.DialogHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.ArrayList<com.example.senthil.kotlin_tablayout.Consumption> items = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlin.jvm.functions.Function1<com.example.senthil.kotlin_tablayout.Consumption, kotlin.Unit> click = null;
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.senthil.kotlin_tablayout.DialogAdapter.DialogHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.DialogAdapter.DialogHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.ArrayList<com.example.senthil.kotlin_tablayout.Consumption> getItems() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlin.jvm.functions.Function1<com.example.senthil.kotlin_tablayout.Consumption, kotlin.Unit> getClick() {
        return null;
    }
    
    public DialogAdapter(@org.jetbrains.annotations.NotNull()
    java.util.ArrayList<com.example.senthil.kotlin_tablayout.Consumption> items, @org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.example.senthil.kotlin_tablayout.Consumption, kotlin.Unit> click) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\b\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011R\u0019\u0010\u0005\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0019\u0010\n\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\tR\u0019\u0010\f\u001a\n \u0007*\u0004\u0018\u00010\u00060\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\t\u00a8\u0006\u0012"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/DialogAdapter$DialogHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "view", "Landroid/view/View;", "(Lcom/example/senthil/kotlin_tablayout/DialogAdapter;Landroid/view/View;)V", "_money", "Landroid/widget/TextView;", "kotlin.jvm.PlatformType", "get_money", "()Landroid/widget/TextView;", "_pm", "get_pm", "_usage", "get_usage", "bind", "", "consumption", "Lcom/example/senthil/kotlin_tablayout/Consumption;", "app_debug"})
    public final class DialogHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        private final android.widget.TextView _usage = null;
        private final android.widget.TextView _money = null;
        private final android.widget.TextView _pm = null;
        
        public final android.widget.TextView get_usage() {
            return null;
        }
        
        public final android.widget.TextView get_money() {
            return null;
        }
        
        public final android.widget.TextView get_pm() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.senthil.kotlin_tablayout.Consumption consumption) {
        }
        
        public DialogHolder(@org.jetbrains.annotations.NotNull()
        android.view.View view) {
            super(null);
        }
    }
}