package io.adev.itpark.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.adev.itpark.R
import io.adev.itpark.presenter.LoginPresenter
import io.adev.itpark.presenter.contract.LoginContract
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk15.listeners.onClick

class LoginActivity : LoginContract.View, AppCompatActivity() {

    private val presenter: LoginContract.Presenter = LoginPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        loginButton.onClick {
            presenter.onLoginClick(
                    loginEdit.text.toString(),
                    passwordEdit.text.toString())
        }

        registerButton.onClick {
            presenter.onRegistrationClick()
        }

    }

    override fun displayError() {
        longToast(R.string.error)
    }

}
