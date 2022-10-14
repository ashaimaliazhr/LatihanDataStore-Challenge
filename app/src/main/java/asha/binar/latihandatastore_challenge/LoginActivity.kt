package asha.binar.latihandatastore_challenge

import android.content.Intent
import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData
import kotlinx.android.synthetic.main.activity_login.*

class LoginActivity : AppCompatActivity() {

    lateinit var dataLogin : DataStoreLogin
    lateinit var usernama : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        dataLogin = DataStoreLogin(this)
        dataLogin.userUsernameFlow.asLiveData().observe(this,{
            usernama = it.toString()
        })

        tvRegister.setOnClickListener {
            startActivity(Intent(this, RegisterActivity::class.java))
        }

        btnLogin.setOnClickListener {
            val username = etUsernama.text.toString()
            val password = etPassword.text.toString()

            if (username.isEmpty()){
                etUsernama.setError("Isi Username")
             } else if (password.isEmpty()){
                 etPassword.setError("Isi Password")
            } else  if (username == username){
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            } else {
                Toast.makeText(this, "Username Salah", Toast.LENGTH_SHORT).show()
            }
        }
    }
}