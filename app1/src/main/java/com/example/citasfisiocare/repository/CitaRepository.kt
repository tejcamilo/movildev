package com.example.citasfisiocare.repository


import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore
import com.example.citasfisiocare.model.Cita1

class CitaRepository {

    private val db = FirebaseFirestore.getInstance()
    private val auth = FirebaseAuth.getInstance()

    fun guardarCita(cita: Cita1, onSuccess: () -> Unit, onFailure: (Exception) -> Unit) {
        val userId = auth.currentUser?.uid ?: return
        val citaConUsuario = cita.copy(idUsuario = userId)

        db.collection("citas")
            .add(citaConUsuario)
            .addOnSuccessListener { onSuccess() }
            .addOnFailureListener { onFailure(it) }
    }

    fun obtenerCitasUsuario(onResult: (List<Cita1>) -> Unit, onFailure: (Exception) -> Unit) {
        val userId = auth.currentUser?.uid ?: return

        db.collection("citas")
            .whereEqualTo("idUsuario", userId)
            .get()
            .addOnSuccessListener { snapshot ->
                val lista = snapshot.toObjects(Cita1::class.java)
                onResult(lista)
            }
            .addOnFailureListener { onFailure(it) }
    }
}
