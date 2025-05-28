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

public class HomeFragmentDirections {
  private HomeFragmentDirections() {
  }

  @NonNull
  public static ActionInicioFragmentToTelemedicinaFragment actionInicioFragmentToTelemedicinaFragment(
      ) {
    return new ActionInicioFragmentToTelemedicinaFragment();
  }

  @NonNull
  public static ActionInicioFragmentToHistoriaFragment actionInicioFragmentToHistoriaFragment() {
    return new ActionInicioFragmentToHistoriaFragment();
  }

  @NonNull
  public static ActionInicioFragmentToPerfilFragment actionInicioFragmentToPerfilFragment() {
    return new ActionInicioFragmentToPerfilFragment();
  }

  @NonNull
  public static ActionInicioFragmentToUsuariosFragment actionInicioFragmentToUsuariosFragment() {
    return new ActionInicioFragmentToUsuariosFragment();
  }

  @NonNull
  public static ActionInicioFragmentToConsultarfacturasFragment actionInicioFragmentToConsultarfacturasFragment(
      ) {
    return new ActionInicioFragmentToConsultarfacturasFragment();
  }

  @NonNull
  public static ActionInicioFragmentToTratamientoFragment actionInicioFragmentToTratamientoFragment(
      ) {
    return new ActionInicioFragmentToTratamientoFragment();
  }

  @NonNull
  public static ActionInicioFragmentToCitasFragment actionInicioFragmentToCitasFragment(
      @NonNull String idCita) {
    return new ActionInicioFragmentToCitasFragment(idCita);
  }

  public static class ActionInicioFragmentToTelemedicinaFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionInicioFragmentToTelemedicinaFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToTelemedicinaFragment setIcon(int icon) {
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
      return R.id.action_inicioFragment_to_telemedicinaFragment;
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
      ActionInicioFragmentToTelemedicinaFragment that = (ActionInicioFragmentToTelemedicinaFragment) object;
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
      return "ActionInicioFragmentToTelemedicinaFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionInicioFragmentToHistoriaFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionInicioFragmentToHistoriaFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToHistoriaFragment setIcon(int icon) {
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
        __result.putInt("icon", R.drawable.historia_clinica);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_inicioFragment_to_historiaFragment;
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
      ActionInicioFragmentToHistoriaFragment that = (ActionInicioFragmentToHistoriaFragment) object;
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
      return "ActionInicioFragmentToHistoriaFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionInicioFragmentToPerfilFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionInicioFragmentToPerfilFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToPerfilFragment setIcon(int icon) {
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
        __result.putInt("icon", R.drawable.profile);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_inicioFragment_to_perfilFragment;
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
      ActionInicioFragmentToPerfilFragment that = (ActionInicioFragmentToPerfilFragment) object;
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
      return "ActionInicioFragmentToPerfilFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionInicioFragmentToUsuariosFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionInicioFragmentToUsuariosFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToUsuariosFragment setIcon(int icon) {
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
        __result.putInt("icon", R.drawable.profile);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_inicioFragment_to_usuariosFragment;
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
      ActionInicioFragmentToUsuariosFragment that = (ActionInicioFragmentToUsuariosFragment) object;
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
      return "ActionInicioFragmentToUsuariosFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionInicioFragmentToConsultarfacturasFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionInicioFragmentToConsultarfacturasFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToConsultarfacturasFragment setIcon(int icon) {
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
      return R.id.action_inicioFragment_to_consultarfacturasFragment;
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
      ActionInicioFragmentToConsultarfacturasFragment that = (ActionInicioFragmentToConsultarfacturasFragment) object;
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
      return "ActionInicioFragmentToConsultarfacturasFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionInicioFragmentToTratamientoFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    private ActionInicioFragmentToTratamientoFragment() {
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToTratamientoFragment setIcon(int icon) {
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
        __result.putInt("icon", R.drawable.modalidad);
      }
      return __result;
    }

    @Override
    public int getActionId() {
      return R.id.action_inicioFragment_to_tratamientoFragment;
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
      ActionInicioFragmentToTratamientoFragment that = (ActionInicioFragmentToTratamientoFragment) object;
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
      return "ActionInicioFragmentToTratamientoFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + "}";
    }
  }

  public static class ActionInicioFragmentToCitasFragment implements NavDirections {
    private final HashMap arguments = new HashMap();

    @SuppressWarnings("unchecked")
    private ActionInicioFragmentToCitasFragment(@NonNull String idCita) {
      if (idCita == null) {
        throw new IllegalArgumentException("Argument \"id_cita\" is marked as non-null but was passed a null value.");
      }
      this.arguments.put("id_cita", idCita);
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToCitasFragment setIcon(int icon) {
      this.arguments.put("icon", icon);
      return this;
    }

    @NonNull
    @SuppressWarnings("unchecked")
    public ActionInicioFragmentToCitasFragment setIdCita(@NonNull String idCita) {
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
      return R.id.action_inicioFragment_to_citasFragment;
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
      ActionInicioFragmentToCitasFragment that = (ActionInicioFragmentToCitasFragment) object;
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
      return "ActionInicioFragmentToCitasFragment(actionId=" + getActionId() + "){"
          + "icon=" + getIcon()
          + ", idCita=" + getIdCita()
          + "}";
    }
  }
}
