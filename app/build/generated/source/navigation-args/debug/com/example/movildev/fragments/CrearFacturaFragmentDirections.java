package com.example.movildev.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.movildev.R;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class CrearFacturaFragmentDirections {
  private CrearFacturaFragmentDirections() {
  }

  @NonNull
  public static ActionCrearFacturaFragmentToFacturaElectronicaFragment actionCrearFacturaFragmentToFacturaElectronicaFragment(
      ) {
    return new ActionCrearFacturaFragmentToFacturaElectronicaFragment();
  }

  @NonNull
  public static ActionCrearFacturaFragmentToConsultarFacturasFragment actionCrearFacturaFragmentToConsultarFacturasFragment(
      ) {
    return new ActionCrearFacturaFragmentToConsultarFacturasFragment();
  }

  public static class ActionCrearFacturaFragmentToFacturaElectronicaFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCrearFacturaFragmentToFacturaElectronicaFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCrearFacturaFragmentToFacturaElectronicaFragment setIcon(int icon) {
      this.arguments.put("icon", icon);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_crearFacturaFragment_to_facturaElectronicaFragment;
    }

    @SuppressWarnings("unchecked")
    public int getIcon() {
      return (int) arguments.get("icon");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCrearFacturaFragmentToFacturaElectronicaFragment that = (ActionCrearFacturaFragmentToFacturaElectronicaFragment) object;
      if (arguments.containsKey("icon") != that.arguments.containsKey("icon")) {
        return false;
      }
      if (getIcon() != that.getIcon()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getIcon();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCrearFacturaFragmentToFacturaElectronicaFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionCrearFacturaFragmentToConsultarFacturasFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCrearFacturaFragmentToConsultarFacturasFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCrearFacturaFragmentToConsultarFacturasFragment setIcon(int icon) {
      this.arguments.put("icon", icon);
      return this;
    }

    @Override
    @SuppressWarnings("unchecked")
    @NonNull
    public Bundle getArguments() {
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
    public int getActionId() {
      return R.id.action_crearFacturaFragment_to_consultarFacturasFragment;
    }

    @SuppressWarnings("unchecked")
    public int getIcon() {
      return (int) arguments.get("icon");
    }

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionCrearFacturaFragmentToConsultarFacturasFragment that = (ActionCrearFacturaFragmentToConsultarFacturasFragment) object;
      if (arguments.containsKey("icon") != that.arguments.containsKey("icon")) {
        return false;
      }
      if (getIcon() != that.getIcon()) {
        return false;
      }
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getIcon();
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionCrearFacturaFragmentToConsultarFacturasFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }
}
