package com.example.movildev.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavArgs;
import com.example.movildev.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class SalaFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private SalaFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private SalaFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static SalaFragmentArgs fromBundle(@NonNull Bundle bundle) {
    SalaFragmentArgs __result = new SalaFragmentArgs();
    bundle.setClassLoader(SalaFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("icon")) {
      int icon;
      icon = bundle.getInt("icon");
      __result.arguments.put("icon", icon);
    } else {
      __result.arguments.put("icon", R.drawable.telemedicina);
    }
    if (bundle.containsKey("cita")) {
      String cita;
      cita = bundle.getString("cita");
      if (cita == null) {
        throw new IllegalArgumentException("Argument \"cita\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("cita", cita);
    } else {
      throw new IllegalArgumentException("Required argument \"cita\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getIcon() {
    return (int) arguments.get("icon");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getCita() {
    return (String) arguments.get("cita");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("icon")) {
      int icon = (int) arguments.get("icon");
      __result.putInt("icon", icon);
    } else {
      __result.putInt("icon", R.drawable.telemedicina);
    }
    if (arguments.containsKey("cita")) {
      String cita = (String) arguments.get("cita");
      __result.putString("cita", cita);
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
    SalaFragmentArgs that = (SalaFragmentArgs) object;
    if (arguments.containsKey("icon") != that.arguments.containsKey("icon")) {
      return false;
    }
    if (getIcon() != that.getIcon()) {
      return false;
    }
    if (arguments.containsKey("cita") != that.arguments.containsKey("cita")) {
      return false;
    }
    if (getCita() != null ? !getCita().equals(that.getCita()) : that.getCita() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getIcon();
    result = 31 * result + (getCita() != null ? getCita().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "SalaFragmentArgs{"
        + "icon=" + getIcon()
        + ", cita=" + getCita()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(SalaFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String cita) {
      if (cita == null) {
        throw new IllegalArgumentException("Argument \"cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("cita", cita);
    }

    @NonNull
    public SalaFragmentArgs build() {
      SalaFragmentArgs result = new SalaFragmentArgs(arguments);
      return result;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setIcon(int icon) {
      this.arguments.put("icon", icon);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public Builder setCita(@NonNull String cita) {
      if (cita == null) {
        throw new IllegalArgumentException("Argument \"cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("cita", cita);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getIcon() {
      return (int) arguments.get("icon");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getCita() {
      return (String) arguments.get("cita");
    }
  }
}
