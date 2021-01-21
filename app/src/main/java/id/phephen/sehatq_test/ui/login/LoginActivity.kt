package id.phephen.sehatq_test.ui.login

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import androidx.appcompat.widget.AppCompatEditText
import com.google.android.material.textfield.TextInputLayout
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.databinding.ActivityLoginBinding
import id.phephen.sehatq_test.ui.main.MainActivity

class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var tvLogin: TextView
    private lateinit var ilUsername: TextInputLayout
    private lateinit var ilPassword: TextInputLayout
    private lateinit var etUsername: AppCompatEditText
    private lateinit var etPassword: AppCompatEditText
    private lateinit var btnGoogle: Button
    private lateinit var btnFacebook: Button
    private lateinit var btnRegister: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvDividerOr: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
        onBtnRegisterClick()
        onBtnFacebookClick()
        onBtnGoogleClick()
    }

    private fun initView() {
        tvLogin = binding.tvLogin
        ilUsername = binding.ilUsername
        ilPassword = binding.ilPassword
        etUsername = binding.etUsername
        etPassword = binding.etPassword
        btnGoogle = binding.btnGoogle
        btnFacebook = binding.btnFacebook
        btnRegister = binding.btnRegister
        tvDividerOr = binding.tvDividerOr
        progressBar = binding.progressBar
    }

    private fun onBtnRegisterClick () {
        btnRegister.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onBtnFacebookClick () {
        btnFacebook.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }

    private fun onBtnGoogleClick () {
        btnGoogle.setOnClickListener {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }
    }
}