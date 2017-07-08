package io.adev.itpark.presenter.navigator

import android.app.Activity
import io.adev.itpark.view.NewsActivity
import io.adev.itpark.view.RegistrationActivity
import org.jetbrains.anko.startActivity

class LoginNavigator(
        private val activity: Activity) {

    fun toMain() {
        activity.startActivity<NewsActivity>()
    }

    fun toRegistration() {
        activity.startActivity<RegistrationActivity>()
    }

}