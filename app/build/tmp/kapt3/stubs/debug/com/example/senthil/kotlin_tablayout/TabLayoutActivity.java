package com.example.senthil.kotlin_tablayout;

import java.lang.System;

@kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\u0018\u00002\u00020\u0001:\u0001\nB\u0005\u00a2\u0006\u0002\u0010\u0002J\u0012\u0010\u0003\u001a\u00020\u00042\b\u0010\u0005\u001a\u0004\u0018\u00010\u0006H\u0014J\u0010\u0010\u0007\u001a\u00020\u00042\u0006\u0010\b\u001a\u00020\tH\u0002\u00a8\u0006\u000b"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/TabLayoutActivity;", "Landroidx/appcompat/app/AppCompatActivity;", "()V", "onCreate", "", "savedInstanceState", "Landroid/os/Bundle;", "setupViewPager", "viewPager", "Landroidx/viewpager/widget/ViewPager;", "ViewPagerAdapter", "app_debug"})
public final class TabLayoutActivity extends androidx.appcompat.app.AppCompatActivity {
    private java.util.HashMap _$_findViewCache;
    
    @java.lang.Override()
    protected void onCreate(@org.jetbrains.annotations.Nullable()
    android.os.Bundle savedInstanceState) {
    }
    
    private final void setupViewPager(androidx.viewpager.widget.ViewPager viewPager) {
    }
    
    public TabLayoutActivity() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 1, 13}, bv = {1, 0, 3}, k = 1, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0010\r\n\u0000\b\u0080\u0004\u0018\u00002\u00020\u0001B\r\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\u0006\u0010\r\u001a\u00020\tJ\b\u0010\u000e\u001a\u00020\u000fH\u0016J\u0010\u0010\u0010\u001a\u00020\u00072\u0006\u0010\u0011\u001a\u00020\u000fH\u0016J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0011\u001a\u00020\u000fH\u0016R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\b\u001a\b\u0012\u0004\u0012\u00020\t0\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0014"}, d2 = {"Lcom/example/senthil/kotlin_tablayout/TabLayoutActivity$ViewPagerAdapter;", "Landroidx/fragment/app/FragmentPagerAdapter;", "manager", "Landroidx/fragment/app/FragmentManager;", "(Lcom/example/senthil/kotlin_tablayout/TabLayoutActivity;Landroidx/fragment/app/FragmentManager;)V", "mFragmentList", "Ljava/util/ArrayList;", "Landroidx/fragment/app/Fragment;", "mFragmentTitleList", "", "addFragment", "", "fragment", "title", "getCount", "", "getItem", "position", "getPageTitle", "", "app_debug"})
    public final class ViewPagerAdapter extends androidx.fragment.app.FragmentPagerAdapter {
        private final java.util.ArrayList<androidx.fragment.app.Fragment> mFragmentList = null;
        private final java.util.ArrayList<java.lang.String> mFragmentTitleList = null;
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public androidx.fragment.app.Fragment getItem(int position) {
            return null;
        }
        
        @java.lang.Override()
        public int getCount() {
            return 0;
        }
        
        public final void addFragment(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.Fragment fragment, @org.jetbrains.annotations.NotNull()
        java.lang.String title) {
        }
        
        @org.jetbrains.annotations.NotNull()
        @java.lang.Override()
        public java.lang.CharSequence getPageTitle(int position) {
            return null;
        }
        
        public ViewPagerAdapter(@org.jetbrains.annotations.NotNull()
        androidx.fragment.app.FragmentManager manager) {
            super(null);
        }
    }
}