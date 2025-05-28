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

public class CitasFragmentArgs implements NavArgs {
  private final HashMap arguments = new HashMap();

  private CitasFragmentArgs() {
  }

  @SuppressWarnings("unchecked")
  private CitasFragmentArgs(HashMap argumentsMap) {
    this.arguments.putAll(argumentsMap);
  }

  @NonNull
  @SuppressWarnings("unchecked")
  public static CitasFragmentArgs fromBundle(@NonNull Bundle bundle) {
    CitasFragmentArgs __result = new CitasFragmentArgs();
    bundle.setClassLoader(CitasFragmentArgs.class.getClassLoader());
    if (bundle.containsKey("icon")) {
      int icon;
      icon = bundle.getInt("icon");
      __result.arguments.put("icon", icon);
    } else {
      __result.arguments.put("icon", R.drawable.calendar);
    }
    if (bundle.containsKey("id_cita")) {
      String idCita;
      idCita = bundle.getString("id_cita");
      if (idCita == null) {
        throw new IllegalArgumentException("Argument \"id_cita\" is marked as non-null but was passed a null value.");
      }
      __result.arguments.put("id_cita", idCita);
    } else {
      throw new IllegalArgumentException("Required argument \"id_cita\" is missing and does not have an android:defaultValue");
    }
    return __result;
  }

  @SuppressWarnings("unchecked")
  public int getIcon() {
    return (int) arguments.get("icon");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public String getIdCita() {
    return (String) arguments.get("id_cita");
  }

  @SuppressWarnings("unchecked")
  @NonNull
  public Bundle toBundle() {
    Bundle __result = new Bundle();
    if (arguments.containsKey("icon")) {
      int icon = (int) arguments.get("icon");
      __result.putInt("icon", icon);
    } else {
      __result.putInt("icon", R.drawable.calendar);
    }
    if (arguments.containsKey("id_cita")) {
      String idCita = (String) arguments.get("id_cita");
      __result.putString("id_cita", idCita);
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
    CitasFragmentArgs that = (CitasFragmentArgs) object;
    if (arguments.containsKey("icon") != that.arguments.containsKey("icon")) {
      return false;
    }
    if (getIcon() != that.getIcon()) {
      return false;
    }
    if (arguments.containsKey("id_cita") != that.arguments.containsKey("id_cita")) {
      return false;
    }
    if (getIdCita() != null ? !getIdCita().equals(that.getIdCita()) : that.getIdCita() != null) {
      return false;
    }
    return true;
  }

  @Override
  public int hashCode() {
    int result = 1;
    result = 31 * result + getIcon();
    result = 31 * result + (getIdCita() != null ? getIdCita().hashCode() : 0);
    return result;
  }

  @Override
  public String toString() {
    return "CitasFragmentArgs{"
        + "icon=" + getIcon()
        + ", idCita=" + getIdCita()
        + "}";
  }

  public static class Builder {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    public Builder(CitasFragmentArgs original) {
      this.arguments.putAll(original.arguments);
    }

    @SuppressWarnings("unchecked")
    public Builder(@NonNull String idCita) {
      if (idCita == null) {
        throw new IllegalArgumentException("Argument \"id_cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id_cita", idCita);
    }

    @NonNull
    public CitasFragmentArgs build() {
      CitasFragmentArgs result = new CitasFragmentArgs(arguments);
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
    public Builder setIdCita(@NonNull String idCita) {
      if (idCita == null) {
        throw new IllegalArgumentException("Argument \"id_cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id_cita", idCita);
      return this;
    }

    @SuppressWarnings("unchecked")
    public int getIcon() {
      return (int) arguments.get("icon");
    }

    @SuppressWarnings("unchecked")
    @NonNull
    public String getIdCita() {
      return (String) arguments.get("id_cita");
    }
  }
}
