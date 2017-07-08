package io.adev.itpark.presenter.contract

interface LoginContract {
    interface View {
        fun displayError()
    }
    interface Presenter {
        fun onLoginClick(login: String, password: String)
        fun onRegistrationClick()
    }
}