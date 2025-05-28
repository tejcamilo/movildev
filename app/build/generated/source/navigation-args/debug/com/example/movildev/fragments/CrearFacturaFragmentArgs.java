package com.example.movildev.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.example.movildev.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CrearFacturaFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CrearFacturaFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CrearFacturaFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CrearFacturaFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CrearFacturaFragmentArgs __result = new CrearFacturaFragmentArgs();
    bundle.setClassLoader(CrearFacturaFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("icon")) {
      int icon;
      icon = bundle.getInt("icon");
      __result.arguments.put("icon", icon);
    } else {
      __result.arguments.put("icon", R.drawable.ic_factura);
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getIcon() {
    return (int) arguments.get("icon");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("icon")) {
      int icon = (int) arguments.get("icon");
      __result.putInt("icon", icon);
    } else {
      __result.putInt("icon", R.drawable.ic_factura);
    }
    return __result;
  }

  @Override
  public boolean equals(Object object) {
    if (this == object) {
        return true;
    }
    if (object == null || getClass() != object.getClass()) {
        return false;
    }
    CrearFacturaFragmentArgs that = (CrearFacturaFragmentArgs) object;
    if (arguments.containsKey("icon") != that.arguments.containsKey("icon")) {
      return false;
    }
    if (getIcon() != that.getIcon()) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getIcon();
    return result;
  }

  @Override
  public String toString() {
    return "CrearFacturaFragmentArgs{"
        + "icon=" + getIcon()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(CrearFacturaFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    public Builder() {
    }

    @NonNull
    public CrearFacturaFragmentArgs build() {
      CrearFacturaFragmentArgs result = new CrearFacturaFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setIcon(int icon) {
      this.arguments.put("icon", icon);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getIcon() {
      return (int) arguments.get("icon");
    }
  }
}
