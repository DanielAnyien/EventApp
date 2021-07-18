package com.jetpack.eventapp

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.text.Editable
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.jetpack.eventapp.databinding.ActivityHomeBinding

class HomeActivity : AppCompatActivity() {

    private lateinit var binding: ActivityHomeBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityHomeBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val name = binding.tvNama

        binding.btnNext.setOnClickListener {
                var name1 = name.text.toString()
                val i = Intent(this@HomeActivity, MainActivity::class.java)
            i.putExtra(MainActivity.EXTRA_NAME, name1)
                if(isPalindrome(name1) == 0) {
                    AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                            .setMessage("isPalindrome")
                            .setPositiveButton("OKE") { _,_ ->
                                startActivity(i)
                            }
                            .show()
                } else {
                    AlertDialog.Builder(this, R.style.MyAlertDialogStyle)
                            .setMessage("not Palindrome")
                            .setPositiveButton("OKE") { _,_ ->
                                startActivity(i)
                            }
                            .show()
                }
            }
    }

    private fun isPalindrome(string: String): Int {
        if (string.length != 0) {
            var i = string.length - 1
            val n = string.substring(0..i/2)
            val r = string.substring(i/2 .. i).reversed()
            var check = n.compareTo(r, true)
            return check
        }
        else {
            return 1
        }
    }

}


