package com.example.androidpermission

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.bumptech.glide.Glide
import com.example.androidpermission.databinding.ActivityNormalPermissionBinding

class NormalPermissionActivity : AppCompatActivity() {
    private lateinit var binding:ActivityNormalPermissionBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityNormalPermissionBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnShowImg.setOnClickListener {
            Glide.with(this).load("https://cdn.antaranews.com/cache/800x533/2020/05/02/WhatsApp-Image-2020-05-02-at-11.44.23.jpeg")
                .circleCrop()
                .into(binding.imgView)
        }


    }
}