package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u0011\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\u0010B\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\t\u001a\u00020\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\fH\u0014J\u0010\u0010\r\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\u000fH\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082D\u00a2\u0006\u0002\n\u0000R\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0004\n\u0002\u0010\b\u00a8\u0006\u0011"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/TabLayoutActivity;", "Landroid/support/v7/app/AppCompatActivity;", "()V", "multiplePermissionsCode", "", "requiredPermissions", "", "", "[Ljava/lang/String;", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViewPager", "viewPager", "Landroid/support/v4/view/ViewPager;", "ViewPagerAdapter", "app_release"})
public final class TabLayoutActivity extends android.support.v7.app.AppCompatActivity {
    private final int multiplePermissionsCode = 100;
    private final java.lang.String[] requiredPermissions = null;
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewPager(android.support.v4.view.ViewPager viewPager) {
    }
    
    public TabLayoutActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 16}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/TabLayoutActivity$ViewPagerAdapter;", "Landroid/support/v4/app/FragmentPagerAdapter;", "manager", "Landroid/support/v4/app/FragmentManager;", "(Lcom/example/senthil/kotlin_tablayout/TabLayoutActivity;Landroid/support/v4/app/FragmentManager;)V", "mFragmentList", "Ljava/util/ArrayList;", "Landroid/support/v4/app/Fragment;", "mFragmentTitleList", "", "addFragment", "", "fragment", "title", "getCount", "", "getItem", "position", "getPageTitle", "", "app_release"})
    public final class ViewPagerAdapter extends android.support.v4.app.FragmentPagerAdapter {
        private final java.util.ArrayList<android.support.v4.app.Fragment> mFragmentList = null;
        private final java.util.ArrayList<java.lang.String> mFragmentTitleList = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public android.support.v4.app.Fragment getItem(int position) {
            return null;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        public final void addFragment(@org.jetbrains.annotations.NotNull()
        android.support.v4.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.CharSequence getPageTitle(int position) {
            return null;
        }
        
        public ViewPagerAdapter(@org.jetbrains.annotations.NotNull()
        android.support.v4.app.FragmentManager manager) {
            super(null);
        }
    }
}