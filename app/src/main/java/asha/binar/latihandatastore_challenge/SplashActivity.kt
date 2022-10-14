package asha.binar.latihandatastore_challenge

import android.content.Intent
import android.os.Bundle
import android.os.Handler
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.asLiveData

class SplashActivity : AppCompatActivity() {

    lateinit var dataLogin : DataStoreLogin
    lateinit var usernama : String

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)

        dataLogin = DataStoreLogin(this)
        dataLogin.userUsernameFlow.asLiveData().observe(this, {
            usernama = it.toString()
        })

        Handler().postDelayed({
            if (usernama.isNullOrEmpty()){
                startActivity(Intent(this, LoginActivity::class.java))
                finish()
            } else {
                startActivity(Intent(this, MainActivity::class.java))
                finish()
            }
        }, 3000)
    }
}