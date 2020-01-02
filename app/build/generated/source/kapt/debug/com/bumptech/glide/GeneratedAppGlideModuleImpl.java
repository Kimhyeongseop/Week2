package com.bumptech.glide;

import android.content.Context;
import android.support.annotation.NonNull;
import android.util.Log;
import com.example.senthil.kotlin_tablayout.Fragment.MyGlideApp;
import java.lang.Class;
import java.lang.Override;
import java.lang.SuppressWarnings;
import java.util.Collections;
import java.util.Set;

@SuppressWarnings("deprecation")
final class GeneratedAppGlideModuleImpl extends GeneratedAppGlideModule {
  private final MyGlideApp appGlideModule;

  GeneratedAppGlideModuleImpl() {
    appGlideModule = new MyGlideApp();
    if (Log.isLoggable("Glide", Log.DEBUG)) {
      Log.d("Glide", "Discovered AppGlideModule from annotation: com.example.senthil.kotlin_tablayout.Fragment.MyGlideApp");
    }
  }

  @Override
  public void applyOptions(@NonNull Context context, @NonNull GlideBuilder builder) {
    appGlideModule.applyOptions(context, builder);
  }

  @Override
  public void registerComponents(@NonNull Context context, @NonNull Glide glide,
      @NonNull Registry registry) {
    appGlideModule.registerComponents(context, glide, registry);
  }

  @Override
  public boolean isManifestParsingEnabled() {
    return appGlideModule.isManifestParsingEnabled();
  }

  @Override
  @NonNull
  public Set<Class<?>> getExcludedModuleClasses() {
    return Collections.emptySet();
  }

  @Override
  @NonNull
  GeneratedRequestManagerFactory getRequestManagerFactory() {
    return new GeneratedRequestManagerFactory();
  }
}
