package io.adev.itpark.presenter

import android.app.Activity
import io.adev.itpark.model.RegistrationUseCase
import io.adev.itpark.model.base.observer
import io.adev.itpark.model.entity.User
import io.adev.itpark.presenter.contract.RegistrationContract
import io.adev.itpark.presenter.navigator.RegistrationNavigator

class RegistrationPresenter(
        private val view: RegistrationContract.View,
        activity: Activity) : RegistrationContract.Presenter {

    private val navigator = RegistrationNavigator(activity)

    private val registrationUseCase = RegistrationUseCase()
    private fun createRegistrationObserver() = observer<User>(
            onNext = { user ->
                navigator.toLogin()
            },
            onComplete = {

            },
            onError = {
                view.displayError()
            })

    override fun onRegistrationClick(fName: String, lName: String, login: String, password: String, photo: String) {
        registrationUseCase.execute(createRegistrationObserver(), RegistrationUseCase.Criteria(fName, lName, login, password, photo))
    }

}