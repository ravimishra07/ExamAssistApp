package com.examassistapp.views

import android.R.attr
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.text.TextUtils
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.LinearLayout
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.examassistapp.R
import com.examassistapp.databinding.ActivitySignUpBinding
import com.google.android.gms.tasks.OnCompleteListener
import com.google.firebase.auth.AuthResult
import com.google.firebase.auth.FirebaseAuth
//import dagger.hilt.android.AndroidEntryPoint

//@AndroidEntryPoint
class SignUpActivity : AppCompatActivity() {
    private lateinit var binding: ActivitySignUpBinding
    private lateinit var context: Context

    var email: EditText? = null
    var pass:EditText? = null
    var username:EditText? = null
    var userid: String? = null
    var Email:kotlin.String? = null
    var auth: FirebaseAuth? = null
    var mainProgressBar: ProgressBar? = null
    var loginFacebookLayout: LinearLayout? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivitySignUpBinding.inflate(layoutInflater)
        val view = binding.root
        context = this
        setContentView(view)

        email = findViewById(R.id.ed_email);
        pass = findViewById(R.id.ed_password);
        username = findViewById(R.id.ed_name);
        mainProgressBar = findViewById(R.id.mainProgressBar)
        loginFacebookLayout = findViewById(R.id.loginFacebookLayout)

        auth = FirebaseAuth.getInstance()

        loginFacebookLayout!!.setOnClickListener {

            val emailInput = email!!.getText().toString()
            val password = pass!!.getText().toString()
            val user = username!!.getText().toString()

            if (TextUtils.isEmpty(user)) {
                Toast.makeText(getApplicationContext(), "Enter username!", Toast.LENGTH_SHORT).show()
            } else if(TextUtils.isEmpty(emailInput)){
                Toast.makeText(getApplicationContext(), "Enter email!", Toast.LENGTH_SHORT).show()
            } else if(TextUtils.isEmpty(password)){
                Toast.makeText(getApplicationContext(), "Enter password!", Toast.LENGTH_SHORT).show()
            } else{
                doSignUp(user, emailInput, password)
            }
        }

    }

    private fun doSignUp(user: String, emailInput: String, password: String) {
        mainProgressBar!!.setVisibility(View.VISIBLE);
        auth!!.createUserWithEmailAndPassword(emailInput, password)
                .addOnCompleteListener(this@SignUpActivity, OnCompleteListener<AuthResult?> { task ->
                    Toast.makeText(this@SignUpActivity, "createUserWithEmail:onComplete:" + task.isSuccessful, Toast.LENGTH_SHORT).show()
                    mainProgressBar!!.setVisibility(View.GONE)

                    if (!task.isSuccessful) {
                        Toast.makeText(this@SignUpActivity, "Authentication failed." + task.exception, Toast.LENGTH_LONG).show()
                        Log.e("MyTag", task.exception.toString())
                    } else {
//                        startActivity(Intent(this@SignUpActivity, Sign_out::class.java))
//                        finish()
                    }
                })

    }


}