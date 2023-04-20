package com.example.androidpermission

import android.content.ActivityNotFoundException
import android.content.Intent
import android.graphics.Bitmap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.provider.MediaStore
import com.example.androidpermission.databinding.ActivityReadWriteGalleryBinding

class ReadWriteGalleryActivity : AppCompatActivity() {
    private lateinit var binding: ActivityReadWriteGalleryBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityReadWriteGalleryBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.btnGallery.setOnClickListener {
            intentGallery()
        }

        binding.btnCapture.setOnClickListener {
            intentCamera()
        }


    }

    private fun intentCamera() {
        val cameraIntent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
        try {
            startActivityForResult(cameraIntent, 1)
        } catch (exception: ActivityNotFoundException) {
            // some error to be shown here
        }
    }

    private fun intentGallery() {
        val galleryIntent = Intent(
            Intent.ACTION_GET_CONTENT, MediaStore.Images.Media.EXTERNAL_CONTENT_URI
        )
        startActivityForResult(galleryIntent, 2)
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        if (requestCode == 1 && resultCode == RESULT_OK) {
            val bitmap = data?.extras?.get("data") as Bitmap
            binding.imgGallery.setImageBitmap(bitmap)
        } else if (requestCode == 2 && resultCode == RESULT_OK) {
            binding.imgGallery.setImageURI(data?.data)
        } else {
            // some error to be shown here
        }
    }
}