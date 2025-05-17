package com.example.movildev.fragments

import android.app.DatePickerDialog
import android.app.TimePickerDialog
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.movildev.databinding.FragmentAddCitaBinding
import com.example.movildev.model.CitaDatabase
import com.example.movildev.viewmodel.CitaViewModel
import com.example.movildev.viewmodel.CitaViewModelFactory
import java.util.Calendar

class AddCitaFragment : Fragment() {
    private var _binding: FragmentAddCitaBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: CitaViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        _binding = FragmentAddCitaBinding.inflate(inflater, container, false)
        val view = binding.root

        val application = requireNotNull(this.activity).application
        val dao = CitaDatabase.getInstance(application).citaDao
        val viewModelFactory = CitaViewModelFactory(dao)
        val viewModel = ViewModelProvider(this, viewModelFactory).get(CitaViewModel::class.java)
        binding.viewModel = viewModel

        binding.etFecha.setOnClickListener {
            showDatePicker(binding.etFecha)
        }

        binding.etHora.setOnClickListener {
            showTimePicker(binding.etHora)
        }
        return view
    }

    private fun showDatePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        val datePickerDialog = DatePickerDialog(
            requireContext(),
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = "${selectedDay}/${selectedMonth + 1}/${selectedYear}"
                editText.setText(formattedDate)
            },
            year, month, day
        )
        datePickerDialog.show()
    }

    private fun showTimePicker(editText: EditText) {
        val calendar = Calendar.getInstance()
        val hour = calendar.get(Calendar.HOUR_OF_DAY)
        val minute = calendar.get(Calendar.MINUTE)

        val timePickerDialog = TimePickerDialog(
            requireContext(),
            { _, selectedHour, selectedMinute ->
                val formattedTime = String.format("%02d:%02d", selectedHour, selectedMinute)
                editText.setText(formattedTime)
            },
            hour, minute, true
        )
        timePickerDialog.show()
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}