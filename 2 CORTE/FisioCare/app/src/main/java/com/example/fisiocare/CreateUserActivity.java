package com.example.fisiocare;

import android.app.Activity;

public class CreateUserActivity extends Activity {
    val fullName = findViewById<EditText>(R.id.etFullName).text.toString()
    val documentType = findViewById<Spinner>(R.id.spinnerDocumentType).selectedItem.toString()
    val documentNumber = findViewById<EditText>(R.id.etDocumentNumber).text.toString()
    val birthDate = findViewById<EditText>(R.id.etBirthDate).text.toString()
    val email = findViewById<EditText>(R.id.etEmail).text.toString()

}
