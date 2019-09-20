package com.ninhttd.devtest.utils

import io.reactivex.disposables.CompositeDisposable
import io.reactivex.disposables.Disposable

fun Disposable.addToCompose(compo: CompositeDisposable) {
    compo.add(this)
}
