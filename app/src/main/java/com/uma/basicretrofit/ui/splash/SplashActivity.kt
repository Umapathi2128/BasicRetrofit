package com.uma.basicretrofit.ui.splash

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.uma.basicretrofit.R
import com.uma.basicretrofit.ui.carlist.CarListActivity
import kotlinx.coroutines.*

class SplashActivity : AppCompatActivity() {

    private lateinit var activityScope : CoroutineScope

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_splash)
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onResume() {
        super.onResume()

        activityScope = CoroutineScope(Dispatchers.Main)

        activityScope.launch {
            delay(3000)
            startActivity(Intent(this@SplashActivity,CarListActivity::class.java))
            finish()
        }
    }

    @ExperimentalCoroutinesApi
    override fun onPause() {
        super.onPause()
        /**
         * need to cancel the background running thread...
         */
       if (activityScope.isActive) activityScope.cancel()
    }

    override fun onRestart() {
        super.onRestart()
    }

    override fun onStop() {
        super.onStop()
    }

    override fun onDestroy() {
        super.onDestroy()
    }
}
