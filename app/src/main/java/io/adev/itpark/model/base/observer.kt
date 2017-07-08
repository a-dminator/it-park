package io.adev.itpark.model.base

import io.reactivex.observers.DisposableObserver

fun <T> observer(onNext: (T) -> Unit = {},
                 onComplete: () -> Unit = {},
                 onError: (Throwable) -> Unit = {}): DisposableObserver<T> {

    return object : DisposableObserver<T>() {
        override fun onNext(t: T) {
            onNext(t)
        }
        override fun onComplete() {
            onComplete()
        }
        override fun onError(e: Throwable) {
            onError(e)
        }
    }

}