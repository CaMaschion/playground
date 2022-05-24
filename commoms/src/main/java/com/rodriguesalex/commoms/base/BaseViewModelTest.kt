/*
 * Copyright (c)
 * 2018-2022 XP Inc
 * All Rights Reserved
 */
package com.rodriguesalex.commoms.base

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import androidx.lifecycle.Observer
import com.rodriguesalex.commoms.di.AppSchedulers
import io.mockk.verify
import io.reactivex.schedulers.Schedulers
import org.junit.Rule

open class BaseViewModelTest {

    @Rule
    @JvmField
    var instantExecutorRule = InstantTaskExecutorRule()

    protected val appSchedulers = AppSchedulers(
        io = Schedulers.trampoline(),
        main = Schedulers.trampoline(),
        computation = Schedulers.trampoline()
    )
}

infix fun <T> Observer<T>.emitted(value: T) {
    verify { this@emitted.onChanged(value) }
}

fun <T> Observer<T>.emittedNull() {
    verify { this@emittedNull.onChanged(null) }
}

infix fun <T> Observer<T>.emittedOnce(value: T) {
    verify(exactly = ONCE) { this@emittedOnce.onChanged(value) }
}

infix fun <T> Observer<T>.emittedTwice(value: T) {
    verify(exactly = TWICE) { this@emittedTwice.onChanged(value) }
}

infix fun <T> Observer<T>.notEmitted(value: T) {
    verify(exactly = NONE) { this@notEmitted.onChanged(value) }
}

infix fun <T> T.called(block: T.() -> Unit) {
    verify { this@called.block() }
}

private const val TWICE = 2
private const val ONCE = 1
private const val NONE = 0
