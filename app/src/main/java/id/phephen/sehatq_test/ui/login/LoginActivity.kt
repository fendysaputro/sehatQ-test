package id.phephen.sehatq_test.ui.login

import android.content.Intent
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.AppCompatEditText
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.GraphRequest
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.facebook.login.widget.LoginButton
import com.google.android.gms.auth.api.signin.GoogleSignIn
import com.google.android.gms.auth.api.signin.GoogleSignInAccount
import com.google.android.gms.auth.api.signin.GoogleSignInOptions
import com.google.android.gms.common.SignInButton
import com.google.android.gms.tasks.Task
import com.google.android.material.textfield.TextInputLayout
import id.phephen.sehatq_test.R
import id.phephen.sehatq_test.databinding.ActivityLoginBinding
import id.phephen.sehatq_test.helpers.Constants.Companion.RC_SIGN_IN
import id.phephen.sehatq_test.helpers.GenerateHash
import id.phephen.sehatq_test.ui.main.MainActivity
import java.lang.Exception


@Suppress("DEPRECATION")
class LoginActivity : AppCompatActivity() {

    private lateinit var binding: ActivityLoginBinding
    private lateinit var tvLogin: TextView
    private lateinit var ilUsername: TextInputLayout
    private lateinit var ilPassword: TextInputLayout
    private lateinit var etUsername: AppCompatEditText
    private lateinit var etPassword: AppCompatEditText
    private lateinit var btnGoogle: SignInButton
    private lateinit var btnFacebook: LoginButton
    private lateinit var btnRegister: Button
    private lateinit var progressBar: ProgressBar
    private lateinit var tvDividerOr: TextView

    lateinit var callbackManager: CallbackManager
    private val EMAIL = "email"

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)
        setContentView(binding.root)
        supportActionBar?.hide()
        initView()
        onBtnRegisterClick()
        onBtnFacebookClick()

//        GenerateHash.printHashKey(this)

        val gso = GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN)
            .requestEmail()
            .build()

        val mGoogleSignInClient = GoogleSignIn.getClient(this, gso);

        btnGoogle.visibility = View.VISIBLE
        btnGoogle.setSize(SignInButton.SIZE_STANDARD)

        btnGoogle.setOnClickListener {
            val signInIntent: Intent = mGoogleSignInClient.getSignInIntent()
            startActivityForResult(signInIntent, RC_SIGN_IN)
        }
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

    private fun gotoMain() {
        val intent = Intent(this, MainActivity::class.java)
        startActivity(intent)
    }

    private fun onBtnFacebookClick () {
        btnFacebook.setOnClickListener {
//            val intent = Intent(this, MainActivity::class.java)
//            startActivity(intent)
            btnFacebook.setReadPermissions(listOf(EMAIL))
            callbackManager = CallbackManager.Factory.create()
            LoginManager.getInstance().registerCallback(callbackManager, object :FacebookCallback<LoginResult>{
                override fun onSuccess(result: LoginResult?) {
                    gotoMain()
                }

                override fun onCancel() {

                }

                override fun onError(error: FacebookException?) {
                    Toast.makeText(this@LoginActivity, error!!.message, Toast.LENGTH_SHORT).show()
                }

            })
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (requestCode == RC_SIGN_IN) {
            val intent = Intent(this, MainActivity::class.java)
            startActivity(intent)
        }

         callbackManager.onActivityResult(requestCode, resultCode, data)
    }
}