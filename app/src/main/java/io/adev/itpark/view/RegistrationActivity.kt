package io.adev.itpark.view

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import io.adev.itpark.R
import io.adev.itpark.presenter.RegistrationPresenter
import io.adev.itpark.presenter.contract.RegistrationContract
import kotlinx.android.synthetic.main.activity_registration.*
import org.jetbrains.anko.longToast
import org.jetbrains.anko.sdk15.listeners.onClick

class RegistrationActivity : RegistrationContract.View, AppCompatActivity() {

    private val presenter: RegistrationContract.Presenter = RegistrationPresenter(this, this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_registration)

        registerButton.onClick {
            presenter.onRegistrationClick(
                    fNameEdit.text.toString(),
                    lNameEdit.text.toString(),
                    loginEdit.text.toString(),
                    passwordEdit.text.toString(),
                    photoEdit.text.toString())
        }

    }

    override fun displayError() {
        longToast(R.string.error)
    }

}
