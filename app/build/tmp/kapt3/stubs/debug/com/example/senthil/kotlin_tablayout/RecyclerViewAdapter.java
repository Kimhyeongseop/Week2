package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0003\u0018\u00002\f\u0012\b\u0012\u00060\u0002R\u00020\u00000\u0001:\u0001\u0013B\u0013\u0012\f\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\u0002\u0010\u0006J\b\u0010\t\u001a\u00020\nH\u0016J\u001c\u0010\u000b\u001a\u00020\f2\n\u0010\r\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u000e\u001a\u00020\nH\u0016J\u001c\u0010\u000f\u001a\u00060\u0002R\u00020\u00002\u0006\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\nH\u0016R\u0017\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\b\u00a8\u0006\u0014"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/RecyclerViewAdapter;", "Landroid/support/v7/widget/RecyclerView$Adapter;", "Lcom/example/senthil/kotlin_tablayout/RecyclerViewAdapter$ViewHolder;", "addressList", "", "Lcom/example/senthil/kotlin_tablayout/Address;", "(Ljava/util/List;)V", "getAddressList", "()Ljava/util/List;", "getItemCount", "", "onBindViewHolder", "", "holder", "position", "onCreateViewHolder", "parent", "Landroid/view/ViewGroup;", "viewType", "ViewHolder", "app_debug"})
public final class RecyclerViewAdapter extends android.support.v7.widget.RecyclerView.Adapter<com.example.senthil.kotlin_tablayout.RecyclerViewAdapter.ViewHolder> {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.example.senthil.kotlin_tablayout.Address> addressList = null;
    
    @org.jetbrains.annotations.NotNull()
    @java.lang.Override()
    public com.example.senthil.kotlin_tablayout.RecyclerViewAdapter.ViewHolder onCreateViewHolder(@org.jetbrains.annotations.NotNull()
    android.view.ViewGroup parent, int viewType) {
        return null;
    }
    
    @java.lang.Override()
    public int getItemCount() {
        return 0;
    }
    
    @java.lang.Override()
    public void onBindViewHolder(@org.jetbrains.annotations.NotNull()
    com.example.senthil.kotlin_tablayout.RecyclerViewAdapter.ViewHolder holder, int position) {
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.example.senthil.kotlin_tablayout.Address> getAddressList() {
        return null;
    }
    
    public RecyclerViewAdapter(@org.jetbrains.annotations.NotNull()
    java.util.List<com.example.senthil.kotlin_tablayout.Address> addressList) {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u000e\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\b\u00a8\u0006\u000f"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/RecyclerViewAdapter$ViewHolder;", "Landroid/support/v7/widget/RecyclerView$ViewHolder;", "itemView", "Landroid/view/View;", "(Lcom/example/senthil/kotlin_tablayout/RecyclerViewAdapter;Landroid/view/View;)V", "_name", "Landroid/widget/TextView;", "get_name", "()Landroid/widget/TextView;", "_phoneNumber", "get_phoneNumber", "bind", "", "address", "Lcom/example/senthil/kotlin_tablayout/Address;", "app_debug"})
    public final class ViewHolder extends android.support.v7.widget.RecyclerView.ViewHolder {
        @org.jetbrains.annotations.Nullable()
        private final android.widget.TextView _name = null;
        @org.jetbrains.annotations.Nullable()
        private final android.widget.TextView _phoneNumber = null;
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView get_name() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final android.widget.TextView get_phoneNumber() {
            return null;
        }
        
        public final void bind(@org.jetbrains.annotations.NotNull()
        com.example.senthil.kotlin_tablayout.Address address) {
        }
        
        public ViewHolder(@org.jetbrains.annotations.NotNull()
        android.view.View itemView) {
            super(null);
        }
    }
}