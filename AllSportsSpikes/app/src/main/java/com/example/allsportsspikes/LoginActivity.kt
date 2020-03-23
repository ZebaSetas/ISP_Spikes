package com.example.allsportsspikes

import android.app.Activity
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.firebase.ui.auth.AuthUI
import com.firebase.ui.auth.IdpResponse
import com.google.firebase.auth.FirebaseAuth
import kotlinx.android.synthetic.main.activity_login.*
import java.util.*

class LoginActivity : AppCompatActivity() {

    val MY_REQUEST_CODE: Int = 7117
    lateinit var providers:List<AuthUI.IdpConfig>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        providers = Arrays.asList<AuthUI.IdpConfig>(
            AuthUI.IdpConfig.EmailBuilder().build(),
            AuthUI.IdpConfig.FacebookBuilder().build(),
            AuthUI.IdpConfig.GoogleBuilder().build(),
            AuthUI.IdpConfig.PhoneBuilder().build()
        )
        showSingnInOptions()
        btn_sign_out.setOnClickListener{
            AuthUI.getInstance().signOut(this@LoginActivity)
                .addOnCompleteListener{
                    btn_sign_out.isEnabled = false
                    showSingnInOptions()
                }
                .addOnFailureListener{
                    e->Toast.makeText(this@LoginActivity,e.message,Toast.LENGTH_SHORT).show()
                }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if(requestCode == MY_REQUEST_CODE){
            val response = IdpResponse.fromResultIntent(data)
            if(resultCode== Activity.RESULT_OK){
                val user = FirebaseAuth.getInstance().currentUser
                Toast.makeText(this,""+user!!.email, Toast.LENGTH_SHORT).show()
                btn_sign_out.isEnabled = true
            }
            else{
                Toast.makeText(this,""+response!!.error!!.message,Toast.LENGTH_SHORT).show()
            }
        }

    }


    private fun showSingnInOptions() {
        startActivityForResult(AuthUI.getInstance().createSignInIntentBuilder()
            .setAvailableProviders(providers)
            .setTheme(R.style.AppTheme)
            .build(), MY_REQUEST_CODE)
    }
}

