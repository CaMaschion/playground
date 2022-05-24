package com.rodriguesalex.commoms.di

import io.reactivex.Scheduler
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.schedulers.Schedulers

data class AppSchedulers(
    val io: Scheduler = Schedulers.io(),
    val main: Scheduler = AndroidSchedulers.mainThread(),
    val computation: Scheduler = Schedulers.computation()
)
