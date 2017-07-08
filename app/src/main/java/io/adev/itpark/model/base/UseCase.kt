package io.adev.itpark.model.base

import io.reactivex.Observable
import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers.mainThread
import io.reactivex.disposables.Disposable
import io.reactivex.observers.DisposableObserver
import io.reactivex.schedulers.Schedulers.io

abstract class UseCase<T, in C>(
        private val subscribeScheduler: Scheduler = io(),
        private val observeScheduler: Scheduler = mainThread()) {

    private var disposable: Disposable? = null
    fun execute(observer: DisposableObserver<T>, criteria: C? = null) {
        disposable = buildObservable(criteria)
                .subscribeOn(subscribeScheduler)
                .observeOn(observeScheduler)
                .subscribeWith(observer)
    }

    abstract fun buildObservable(criteria: C?): Observable<T>

}