package io.adev.itpark.model

import com.google.gson.JsonParser
import io.adev.itpark.model.base.UseCase
import io.adev.itpark.model.entity.User
import io.reactivex.Observable
import okhttp3.FormBody
import okhttp3.Request

class RegistrationUseCase : UseCase<User, RegistrationUseCase.Criteria>() {

    class Criteria(
            val fName: String,
            val lName: String,
            val login: String,
            val password: String,
            val photo: String)

    override fun buildObservable(criteria: Criteria?): Observable<User> {
        return Observable.create { emitter ->

            val body = FormBody.Builder()
                    .add("fName", criteria!!.fName)
                    .add("lName", criteria.lName)
                    .add("login", criteria.login)
                    .add("password", criteria.password)
                    .add("photo", criteria.photo)
                    .build()

            val request = Request.Builder()
                    .url("http://207.254.71.167:8083/park/users/register")
                    .post(body)
                    .build()

            val response = okHttpClient.newCall(request)
                    .execute()
                    .body().string()

            val responseJson = JsonParser().parse(response).asJsonObject["response"].asJsonObject

            val fName = responseJson["fName"].asString
            val lName = responseJson["lName"].asString
            val login = responseJson["login"].asString
            val photo = responseJson["photo"].asString

            val user = User(
                    fName,
                    lName,
                    login,
                    photo)

            emitter.onNext(user)
        }
    }

}