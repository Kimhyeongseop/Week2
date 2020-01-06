package com.example.senthil.kotlin_tablayout

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.util.Patterns
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.facebook.AccessToken
import com.facebook.CallbackManager
import com.facebook.FacebookCallback
import com.facebook.FacebookException
import com.facebook.login.LoginManager
import com.facebook.login.LoginResult
import com.google.firebase.auth.FacebookAuthProvider
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import kotlinx.android.synthetic.main.activity_main.*
import java.util.*
import java.util.regex.Pattern


class MainActivity : Activity() {
    override fun onPause() {
        super.onPause()
    }

    private lateinit var callbackManager: CallbackManager
    // 파이어베이스 인증 객체 생성
    private var firebaseAuth: FirebaseAuth? = null
    // 이메일과 비밀번호
    private var editTextEmail: EditText? = null
    private var editTextPassword: EditText? = null
    private var email = ""
    private var password = ""

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        callbackManager = CallbackManager.Factory.create()

        facebookLoginBtn.setOnClickListener {
            facebookLogin()
        }

        // 파이어베이스 인증 객체 선언
        firebaseAuth= FirebaseAuth.getInstance()
        editTextEmail = findViewById(R.id.et_eamil)
        editTextPassword = findViewById(R.id.et_password)
    }

    fun singUp(view: View?) {
        email = editTextEmail!!.text.toString()
        password = editTextPassword!!.text.toString()
        if (isValidEmail && isValidPasswd) {
            createUser(email, password)
        }
    }

    fun signIn(view: View?) {
        email = editTextEmail!!.text.toString()
        password = editTextPassword!!.text.toString()
        if (isValidEmail && isValidPasswd) {
            loginUser(email, password)
        }
    }// 이메일 형식 불일치// 이메일 공백

    // 이메일 유효성 검사
    private val isValidEmail: Boolean
        private get() = if (email.isEmpty()) { // 이메일 공백
            false
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) { // 이메일 형식 불일치
            false
        } else {
            true
        }// 비밀번호 형식 불일치// 비밀번호 공백

    // 비밀번호 유효성 검사
    private val isValidPasswd: Boolean
        private get() {
            return if (password.isEmpty()) { // 비밀번호 공백
                false
            } else if (!PASSWORD_PATTERN.matcher(password).matches()) { // 비밀번호 형식 불일치
                false
            } else {
                true
            }
        }

    // 회원가입
    private fun createUser(email: String, password: String) {
        firebaseAuth!!.createUserWithEmailAndPassword(email, password).addOnCompleteListener(this
                ) { task ->
                    if (task.isSuccessful) { // 회원가입 성공
                        Toast.makeText(this@MainActivity, R.string.success_signup, Toast.LENGTH_SHORT).show()
                    } else { // 회원가입 실패
                        Toast.makeText(this@MainActivity, R.string.failed_signup, Toast.LENGTH_SHORT).show()
                    }
                }
    }

    // 로그인
    private fun loginUser(email: String, password: String) {
        firebaseAuth!!.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener(
                        this
                ) { task ->
                    if (task.isSuccessful) { // 로그인 성공
                        Toast.makeText(this@MainActivity, R.string.success_login, Toast.LENGTH_SHORT).show()

                        startActivity(Intent(this, TabLayoutActivity::class.java))
                        finish()
                    } else { // 로그인 실패
                        Toast.makeText(this@MainActivity, R.string.failed_login, Toast.LENGTH_SHORT).show()

                    }
                }
    }

    companion object {
        // 비밀번호 정규식
        private val PASSWORD_PATTERN: Pattern = Pattern.compile("^[a-zA-Z0-9!@.#$%^&*?_~]{4,16}$")
    }
    private fun facebookLogin() {
        LoginManager.getInstance().logInWithReadPermissions(this, Arrays.asList("public_profile", "email"))
        LoginManager.getInstance().registerCallback(callbackManager, object : FacebookCallback<LoginResult> {

            override fun onSuccess(result: LoginResult?) {
                //페이스북 로그인 성공
                handleFacebookAccessToken(result?.accessToken)
                //toast("로그인 성공")
            }
            override fun onCancel() {
                //페이스북 로그인 취소
                updateUI(null)
            }

            override fun onError(error: FacebookException?) {
                //페이스북 로그인 실패
                updateUI(null)
            }
        })
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        callbackManager?.onActivityResult(requestCode, resultCode, data)
        //onActivityResult에서는 callbackManager에 로그인 결과를 넘겨줍니다
        //여기에 callbackManager?.onAcitivyResult가 있어야 onSuccess를 호출할 수 있습니다.
    }

    private fun handleFacebookAccessToken(token: AccessToken?) {
        Log.d("MainActivity", "handleFacebookAccessToken:$token")
        if (token != null) {
            val credential = FacebookAuthProvider.getCredential(token.token)
            firebaseAuth!!.signInWithCredential(credential)
                    .addOnCompleteListener(this) { task ->
                        if (task.isSuccessful) {
                            // Sign in success, update UI with the signed-in user's information
                            Log.d("MainActivity", "signInWithCredential:success")
                            val user = firebaseAuth!!.currentUser
                            updateUI(user)
                            startActivity(Intent(this, TabLayoutActivity::class.java))
                            finish()
                        } else {
                            // If sign in fails, display a message to the user.
                            Log.w("MainActivity", "signInWithCredential:failure", task.exception)
                            //toast("Authentication failed.")
                            updateUI(null)
                        }
                    }
        }
    }

    override fun onStart() { //로그인유저되있는 유저를 확인함
        super.onStart()
        val currentUser =firebaseAuth!!.currentUser
        updateUI(currentUser)
    }

    private fun updateUI(user: FirebaseUser?) {
        if (user != null) {
            status.text = user.displayName
            detail.text = user.photoUrl.toString()
        } else {
            status.setText("로그인 안됨")
            detail.text = "photoURL"
        }
    }

}