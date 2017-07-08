package io.adev.itpark.presenter

import android.app.Activity
import io.adev.itpark.model.LoginUseCase
import io.adev.itpark.model.base.observer
import io.adev.itpark.model.entity.User
import io.adev.itpark.presenter.contract.LoginContract
import io.adev.itpark.presenter.navigator.LoginNavigator

class LoginPresenter(
        private val view: LoginContract.View,
        activity: Activity) : LoginContract.Presenter {

    private val navigator = LoginNavigator(activity)

    private val loginUseCase = LoginUseCase()
    private fun createLoginObserver() = observer<User>(
            onNext = { user ->
                navigator.toMain()
            },
            onComplete = {

            },
            onError = {
                view.displayError()
            })

    override fun onLoginClick(login: String, password: String) {
        loginUseCase.execute(createLoginObserver(), LoginUseCase.Criteria(login, password))
    }

    override fun onRegistrationClick() {
        navigator.toRegistration()
    }

}