package com.example.citasfisiocare


import android.os.Bundle
import android.widget.ArrayAdapter
import android.widget.Button
import android.widget.Spinner
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java. util. Calendar
import android.app.DatePickerDialog
import android.widget.Toast
import android. app. Dialog
import android. view. Window
import android.graphics.Color
import android.graphics.drawable.ColorDrawable


//


//===================================== FILTRO Y CITAS DISPONIBLES PRUEBA =============================================================


//class MainActivity : AppCompatActivity() {
//
//    private lateinit var tvFechaPicker: TextView
//    private lateinit var spinnerHora: Spinner
//    private lateinit var spinnerEspecialidad: Spinner
//    private lateinit var spinnerModalidad: Spinner
//    private lateinit var botonGuardar: Button
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_citas_filtro)
//
//        tvFechaPicker = findViewById(R.id.tv_fecha_picker)
//        spinnerHora = findViewById(R.id.spinner_hora)
//        spinnerEspecialidad = findViewById(R.id.spinner_especialidad)
//        spinnerModalidad = findViewById(R.id.spinner_modalidad)
//        botonGuardar = findViewById(R.id.guardar_info)
//
//        // Llenar los Spinners
//        val horas = listOf("8:00 AM", "9:00 AM", "10:00 AM")
//        val especialidades = listOf("Fisioterapia2", "Fisioterapia1", "Fisioterapia3")
//        val modalidades = listOf("Presencial", "Virtual")
//
//        spinnerHora.adapter =
//            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, horas)
//        spinnerEspecialidad.adapter =
//            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, especialidades)
//        spinnerModalidad.adapter =
//            ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, modalidades)
//
//        // Mostrar DatePicker al tocar el TextView
//        tvFechaPicker.setOnClickListener {
//            mostrarDatePicker()
//        }
//
//        // Guardar datos y lanzar Confirmación
//        botonGuardar.setOnClickListener {
//            val fechaSeleccionada = tvFechaPicker.text.toString()
//
//            val intent = Intent(this, ConfirmacionActivity::class.java).apply {
//                putExtra("fecha", fechaSeleccionada)
//                putExtra("hora", spinnerHora.selectedItem.toString())
//                putExtra("especialidad", spinnerEspecialidad.selectedItem.toString())
//                putExtra("modalidad", spinnerModalidad.selectedItem.toString())
//            }
//            startActivity(intent)
//        }
//    }
//
//    private fun mostrarDatePicker() {
//        val calendario = Calendar.getInstance()
//        val año = calendario.get(Calendar.YEAR)
//        val mes = calendario.get(Calendar.MONTH)
//        val dia = calendario.get(Calendar.DAY_OF_MONTH)
//
//        val datePickerDialog = DatePickerDialog(this, { _, añoSel, mesSel, diaSel ->
//            val fechaFormateada = String.format("%02d/%02d/%02d", diaSel, mesSel + 1, añoSel % 100)
//            tvFechaPicker.text = fechaFormateada
//        }, año, mes, dia)
//
//        datePickerDialog.show()
//    }
//}

//
//}









//======================================= POP_UP PRUEBA ===================================================


//class MainActivity : AppCompatActivity(){
//
//
//    override fun onCreate(savedInstanceState: Bundle?) {
//        super.onCreate(savedInstanceState)
//        setContentView(R.layout.fragment_citas_disponibles)
//
//        val btnLogOut: Button = findViewById(R.id.add)
//
//        btnLogOut.setOnClickListener {
//            val message: String? = ""
//            showCustomDialogBox(message)
//        }
//    }
//
//    private fun showCustomDialogBox(message: String?) {
//        val dialog = Dialog(this)
//        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
//        dialog.setCancelable(false)
//        dialog.setContentView(R.layout.layout_costum_dialog)
//        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))
//
//        val tvMessage: TextView = dialog.findViewById(R.id.tvMessage)
//        val btnYes: Button = dialog.findViewById(R.id.btnYes)
//        val btnNo: Button = dialog.findViewById(R.id.btnNo)
//
//        tvMessage.text = message
//
//        btnYes.setOnClickListener {
//            Toast.makeText(this, "Agendar", Toast.LENGTH_LONG).show()
//        }
//
//
//         btnNo.setOnClickListener {
//             dialog.dismiss()
//         }
//        dialog.show()
//    }

//}





//====================================== FUSION ==============================================================



class MainActivity : AppCompatActivity() {

    // UI elementos de fragment_citas_filtro
    private lateinit var tvFechaPicker: TextView
    private lateinit var spinnerHora: Spinner
    private lateinit var spinnerEspecialidad: Spinner
    private lateinit var spinnerModalidad: Spinner
    private lateinit var botonGuardar: Button

    // Elementos de fragment_citas_disponibles
    private lateinit var tvHoraConsulta: TextView
    private lateinit var tvFechaConsulta: TextView
    private lateinit var tvEspecialidadConsulta: TextView
    private lateinit var tvModalidadConsulta: TextView
    private lateinit var btnAgendar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.fragment_citas_filtro)

        // Inicializar vista para ingresar datos (filtro)
        tvFechaPicker = findViewById(R.id.tv_fecha_picker)
        spinnerHora = findViewById(R.id.spinner_hora)
        spinnerEspecialidad = findViewById(R.id.spinner_especialidad)
        spinnerModalidad = findViewById(R.id.spinner_modalidad)
        botonGuardar = findViewById(R.id.guardar_info)

        // Cargar datos en los Spinners
        val horas = listOf("8:00 AM", "9:00 AM", "10:00 AM")
        val especialidades = listOf("Fisioterapia2", "Fisioterapia1", "Fisioterapia3")
        val modalidades = listOf("Presencial", "Virtual")

        spinnerHora.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, horas)
        spinnerEspecialidad.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, especialidades)
        spinnerModalidad.adapter = ArrayAdapter(this, android.R.layout.simple_spinner_dropdown_item, modalidades)

        tvFechaPicker.setOnClickListener {
            mostrarDatePicker()
        }

        botonGuardar.setOnClickListener {
            val fecha = tvFechaPicker.text.toString()
            val hora = spinnerHora.selectedItem.toString()
            val especialidad = spinnerEspecialidad.selectedItem.toString()
            val modalidad = spinnerModalidad.selectedItem.toString()

            // Mostrar fragmento de citas disponibles con los datos filtrados
            mostrarCitaDisponible(fecha, hora, especialidad, modalidad)
        }
    }

    private fun mostrarDatePicker() {
        val calendario = Calendar.getInstance()
        val año = calendario.get(Calendar.YEAR)
        val mes = calendario.get(Calendar.MONTH)
        val dia = calendario.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(this, { _, añoSel, mesSel, diaSel ->
            val fechaFormateada = String.format("%02d/%02d/%02d", diaSel, mesSel + 1, añoSel % 100)
            tvFechaPicker.text = fechaFormateada
        }, año, mes, dia)

        datePickerDialog.show()
    }

    private fun mostrarCitaDisponible(
        fecha: String,
        hora: String,
        especialidad: String,
        modalidad: String
    ) {
        // Cambiar el layout
        setContentView(R.layout.fragment_citas_disponibles)

        // Obtener referencias del layout de citas disponibles
        tvHoraConsulta = findViewById(R.id.tv_hora_consulta)
        tvFechaConsulta = findViewById(R.id.tv_fecha_consulta)
        tvEspecialidadConsulta = findViewById(R.id.tv_especialidad_consulta)
        tvModalidadConsulta = findViewById(R.id.tv_modalidad_consulta)
        btnAgendar = findViewById(R.id.add)

        // Mostrar datos filtrados en la card
        tvHoraConsulta.text = hora
        tvFechaConsulta.text = fecha
        tvEspecialidadConsulta.text = especialidad
        tvModalidadConsulta.text = modalidad

        // Mostrar popup al hacer clic en Agendar
        btnAgendar.setOnClickListener {
            showCustomDialogBox("¿Estas seguro de Agendar cita?")
        }

        // Botón Cancelar también si quieres cerrar la actividad o volver atrás
        findViewById<Button>(R.id.cancel).setOnClickListener {
            finish() // O setContentView(R.layout.fragment_citas_filtro) si quieres volver al filtro
        }
    }

    private fun showCustomDialogBox(message: String?) {
        val dialog = Dialog(this)
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE)
        dialog.setCancelable(false)
        dialog.setContentView(R.layout.fragment_pop_up)
        dialog.window?.setBackgroundDrawable(ColorDrawable(Color.TRANSPARENT))

        val tvMessage: TextView = dialog.findViewById(R.id.tvMessage)
        val btnYes: Button = dialog.findViewById(R.id.btnYes)
        val btnNo: Button = dialog.findViewById(R.id.btnNo)

        tvMessage.text = message

        btnYes.setOnClickListener {
            Toast.makeText(this, "Cita agendada con éxito", Toast.LENGTH_LONG).show()
            dialog.dismiss()
        }

        btnNo.setOnClickListener {
            dialog.dismiss()
        }

        dialog.show()
    }
}
