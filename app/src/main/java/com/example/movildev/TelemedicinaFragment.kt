package com.example.movildev

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.findNavController
import com.example.movildev.databinding.FragmentTelemedicinaBinding
import com.example.movildev.viewmodel.TelemedicinaViewModel

class TelemedicinaFragment : Fragment() {
    private var _binding: FragmentTelemedicinaBinding? = null
    private val binding get() = _binding!!

    lateinit var viewModel: TelemedicinaViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {
        _binding = FragmentTelemedicinaBinding.inflate(inflater, container, false)
        val view = binding.root

        //ViewModelProvider ensures that a new object only gets created if one doesn't exist already
        viewModel = ViewModelProvider(this).get(TelemedicinaViewModel::class.java)



        binding.accederBtn.setOnClickListener {
            val action = TelemedicinaFragmentDirections // pasar datos de cita a SalaFragment
                .actionTelemedicinaFragmentToSalaFragment(viewModel.cita)
            view.findNavController().navigate(action)
            viewModel.doSomething() // ejemplo de como llamar los métodos del ViewModel
        }

        val frame1 = view.findViewById<LinearLayout>(R.id.frame1)
        frame1.setOnClickListener {
            val text = "El acceso a la cita estará disponible 5 minutos antes de la hora programada"
            Toast.makeText(activity, text, Toast.LENGTH_LONG).show()
        }
        return view
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}