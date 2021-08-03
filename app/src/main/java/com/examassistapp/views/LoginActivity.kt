package com.examassistapp.views

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.provider.ContactsContract.CommonDataKinds.Email
import android.text.TextUtils
import android.util.Log
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.examassistapp.R
import com.examassistapp.databinding.ActivityLoginBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var context: Context

    var ed_email: EditText? = null
    var ed_password:EditText? = null
    var mainProgressBar: ProgressBar? = null
    var auth: FirebaseAuth? = null
    var loginLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        val view = binding.root
        context = this
        setContentView(view)


        ed_email = findViewById(R.id.ed_email)
        ed_password = findViewById(R.id.ed_password)
        mainProgressBar =  findViewById(R.id.mainProgressBar)
        loginLayout =  findViewById(R.id.loginLayout)
        auth = FirebaseAuth.getInstance()

        loginLayout!!.setOnClickListener {

            val Email = ed_email!!.getText().toString()
            val password = ed_password!!.getText().toString()

            if (TextUtils.isEmpty(Email)) {
                Toast.makeText(getApplicationContext(), "Enter email!", Toast.LENGTH_SHORT).show()
            } else if(TextUtils.isEmpty(password)){
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show()
            } else{
                doLogin(Email, password)
            }
        }
    }

    private fun doLogin(email: String, password: String) {
        auth!!.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this@LoginActivity, OnCompleteListener<AuthResult?> { task ->
                    if (!task.isSuccessful) {
                        // there was an error
                        Toast.makeText(this@LoginActivity, "Authentication failed." + task.exception, Toast.LENGTH_LONG).show()
                        Log.e("MyTag", task.exception.toString())
                    } else {
//                        val intent = Intent(this@LoginActivity, Sign_out::class.java)
//                        startActivity(intent)
//                        finish()
                    }
                })
    }
}