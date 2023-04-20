package com.example.androidpermission

import android.content.Context
import android.net.wifi.WifiManager
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.example.androidpermission.databinding.ActivityMainBinding

@Suppress("DEPRECATION")
class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    lateinit var wifiManager: WifiManager
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        wifiManager = applicationContext.getSystemService(Context.WIFI_SERVICE) as WifiManager

        binding.buttonEnable.setOnClickListener {
            wifiEnable()
        }

        binding.btnDisabled.setOnClickListener {
            wifiDisabled()
        }
    }

    fun wifiEnable(){
        wifiManager.isWifiEnabled = true
        Toast.makeText(this, "Wifi enabled", Toast.LENGTH_SHORT).show()
    }

    fun wifiDisabled(){
        wifiManager.isWifiEnabled = false
        Toast.makeText(this, "Wifi disabled", Toast.LENGTH_SHORT).show()
    }

}