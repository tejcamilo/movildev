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

public class AgendarCitasFragmentDirections {
  private AgendarCitasFragmentDirections() {
  }

  @NonNull
  public static ActionAgendarCitasFragmentToCitasFragment actionAgendarCitasFragmentToCitasFragment(
      @NonNull String idCita) {
    return new ActionAgendarCitasFragmentToCitasFragment(idCita);
  }

  public static class ActionAgendarCitasFragmentToCitasFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionAgendarCitasFragmentToCitasFragment(@NonNull String idCita) {
      if (idCita == null) {
        throw new IllegalArgumentException("Argument \"id_cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id_cita", idCita);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAgendarCitasFragmentToCitasFragment setIcon(int icon) {
      this.arguments.put("icon", icon);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionAgendarCitasFragmentToCitasFragment setIdCita(@NonNull String idCita) {
      if (idCita == null) {
        throw new IllegalArgumentException("Argument \"id_cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id_cita", idCita);
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
        __result.putInt("icon", R.drawable.calendar);
      }
      if (arguments.containsKey("id_cita")) {
        String idCita = (String) arguments.get("id_cita");
        __result.putString("id_cita", idCita);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_agendarCitasFragment_to_citasFragment;
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

    @Override
    public boolean equals(Object object) {
      if (this == object) {
          return true;
      }
      if (object == null || getClass() != object.getClass()) {
          return false;
      }
      ActionAgendarCitasFragmentToCitasFragment that = (ActionAgendarCitasFragmentToCitasFragment) object;
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
      if (getActionId() != that.getActionId()) {
        return false;
      }
      return true;
    }

    @Override
    public int hashCode() {
      int result = 1;
      result = 31 * result + getIcon();
      result = 31 * result + (getIdCita() != null ? getIdCita().hashCode() : 0);
      result = 31 * result + getActionId();
      return result;
    }

    @Override
    public String toString() {
      return "ActionAgendarCitasFragmentToCitasFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + ", idCita=" + getIdCita()
          + "}";
    }
  }
}
