package asha.binar.latihandatastore_challenge

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_register.*
import kotlinx.coroutines.GlobalScope
import kotlinx.coroutines.launch

class RegisterActivity : AppCompatActivity() {
    lateinit var dataLogin : DataStoreLogin
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        dataLogin = DataStoreLogin(this)

        btnRegister.setOnClickListener {
            val rUsername = etRegistUsername.text.toString()
            val rPassword = etRegistPassword.text.toString()
            GlobalScope.launch {
                dataLogin.saveData(rUsername, rPassword)
                startActivity(Intent(this@RegisterActivity, LoginActivity::class.java))
                finish()
            }
            finish()
        }
    }
}