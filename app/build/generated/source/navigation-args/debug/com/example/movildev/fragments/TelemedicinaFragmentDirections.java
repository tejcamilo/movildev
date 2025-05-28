package com.example.movildev.fragments;

import android.os.Bundle;
import androidx.annotation.NonNull;
import androidx.navigation.NavDirections;
import com.example.movildev.R;
import java.lang.IllegalArgumentException;
import java.lang.Object;
import java.lang.Override;
import java.lang.String;
import java.lang.SuppressWarnings;
import java.util.HashMap;

public class TelemedicinaFragmentDirections {
  private TelemedicinaFragmentDirections() {
  }

  @NonNull
  public static ActionTelemedicinaFragmentToSalaFragment actionTelemedicinaFragmentToSalaFragment(
      @NonNull String cita) {
    return new ActionTelemedicinaFragmentToSalaFragment(cita);
  }

  public static class ActionTelemedicinaFragmentToSalaFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionTelemedicinaFragmentToSalaFragment(@NonNull String cita) {
      if (cita == null) {
        throw new IllegalArgumentException("Argument \"cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("cita", cita);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTelemedicinaFragmentToSalaFragment setIcon(int icon) {
      this.arguments.put("icon", icon);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionTelemedicinaFragmentToSalaFragment setCita(@NonNull String cita) {
      if (cita == null) {
        throw new IllegalArgumentException("Argument \"cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("cita", cita);
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
        __result.putInt("icon", R.drawable.telemedicina);
      }
      if (arguments.containsKey("cita")) {
        String cita = (String) arguments.get("cita");
        __result.putString("cita", cita);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_telemedicinaFragment_to_salaFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionTelemedicinaFragmentToSalaFragment that = (ActionTelemedicinaFragmentToSalaFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getIcon();
      result = 31 * result + (getCita() != null ? getCita().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionTelemedicinaFragmentToSalaFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + ", cita=" + getCita()
          + "}";
    }
  }
}
