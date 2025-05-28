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

public class CitasFragmentDirections {
  private CitasFragmentDirections() {
  }

  @NonNull
  public static ActionCitasFragmentToTelemedicinaFragment actionCitasFragmentToTelemedicinaFragment(
      ) {
    return new ActionCitasFragmentToTelemedicinaFragment();
  }

  @NonNull
  public static ActionCitasFragmentToAgendarCitasFragment actionCitasFragmentToAgendarCitasFragment(
      ) {
    return new ActionCitasFragmentToAgendarCitasFragment();
  }

  public static class ActionCitasFragmentToTelemedicinaFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCitasFragmentToTelemedicinaFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCitasFragmentToTelemedicinaFragment setIcon(int icon) {
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
        __result.putInt("icon", R.drawable.telemedicina);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_citasFragment_to_telemedicinaFragment;
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
      ActionCitasFragmentToTelemedicinaFragment that = (ActionCitasFragmentToTelemedicinaFragment) object;
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
      return "ActionCitasFragmentToTelemedicinaFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionCitasFragmentToAgendarCitasFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionCitasFragmentToAgendarCitasFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionCitasFragmentToAgendarCitasFragment setIcon(int icon) {
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
        __result.putInt("icon", R.drawable.calendar);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_citasFragment_to_agendarCitasFragment;
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
      ActionCitasFragmentToAgendarCitasFragment that = (ActionCitasFragmentToAgendarCitasFragment) object;
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
      return "ActionCitasFragmentToAgendarCitasFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }
}
