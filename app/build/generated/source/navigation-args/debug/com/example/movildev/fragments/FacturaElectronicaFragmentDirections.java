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

public class FacturaElectronicaFragmentDirections {
  private FacturaElectronicaFragmentDirections() {
  }

  @NonNull
  public static ActionFacturaElectronicaFragmentToConsultarFacturasFragment actionFacturaElectronicaFragmentToConsultarFacturasFragment(
      ) {
    return new ActionFacturaElectronicaFragmentToConsultarFacturasFragment();
  }

  @NonNull
  public static ActionFacturaElectronicaFragmentToCrearFacturaFragment actionFacturaElectronicaFragmentToCrearFacturaFragment(
      ) {
    return new ActionFacturaElectronicaFragmentToCrearFacturaFragment();
  }

  public static class ActionFacturaElectronicaFragmentToConsultarFacturasFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionFacturaElectronicaFragmentToConsultarFacturasFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFacturaElectronicaFragmentToConsultarFacturasFragment setIcon(int icon) {
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
      return R.id.action_facturaElectronicaFragment_to_consultarFacturasFragment;
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
      ActionFacturaElectronicaFragmentToConsultarFacturasFragment that = (ActionFacturaElectronicaFragmentToConsultarFacturasFragment) object;
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
      return "ActionFacturaElectronicaFragmentToConsultarFacturasFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionFacturaElectronicaFragmentToCrearFacturaFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionFacturaElectronicaFragmentToCrearFacturaFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionFacturaElectronicaFragmentToCrearFacturaFragment setIcon(int icon) {
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
      return R.id.action_facturaElectronicaFragment_to_crearFacturaFragment;
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
      ActionFacturaElectronicaFragmentToCrearFacturaFragment that = (ActionFacturaElectronicaFragmentToCrearFacturaFragment) object;
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
      return "ActionFacturaElectronicaFragmentToCrearFacturaFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }
}
