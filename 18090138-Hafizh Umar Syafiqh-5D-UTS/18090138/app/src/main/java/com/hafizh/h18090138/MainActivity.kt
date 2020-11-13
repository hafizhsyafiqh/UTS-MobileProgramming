package com.hafizh.h18090138

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.hafizh.h18090138.hafizh.Constant
import com.hafizh.h18090138.hafizh.PreferencesHelper
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.system.exitProcess

class MainActivity : AppCompatActivity() {
    lateinit var  sharedPreferences: PreferencesHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPreferences = PreferencesHelper(this)

        buttonLogin.setOnClickListener {
            if(editUsername.text.isNotEmpty() && editUsername.text.isNotEmpty()){
                saveSession(editUsername.text.toString(), editPassword.text.toString())
                showMessage("Berhasil Masuk")
                moveIntent()
            }
        }
        buttonLogout.setOnClickListener{
            finish();
            moveTaskToBack(true)
            exitProcess(-1)
        }
    }

    override fun onStart() {
        super.onStart()
        if (sharedPreferences.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private  fun moveIntent(){
        startActivity(Intent(this, UserActivity::class.java))
        finish()
    }

    private  fun saveSession( username: String, password: String){
        sharedPreferences.put(Constant.PREF_USERNAME, username)
        sharedPreferences.put(Constant.PREF_PASSWORD, password)
        sharedPreferences.put(Constant.PREF_IS_LOGIN, true)
    }

    private fun showMessage(message: String){
        Toast.makeText(applicationContext, message, Toast.LENGTH_SHORT).show()
    }
}