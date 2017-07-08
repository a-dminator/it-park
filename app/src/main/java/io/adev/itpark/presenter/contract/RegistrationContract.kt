package io.adev.itpark.presenter.contract

interface RegistrationContract {
    interface View {
        fun displayError()
    }
    interface Presenter {
        fun onRegistrationClick(fName: String, lName: String, login: String, password: String, photo: String)
    }
}