package com.rodriguesalex.commoms.extensions

import java.security.MessageDigest

fun String.md5() =
    MessageDigest.getInstance("MD5").digest(this.toByteArray()).toHex()

fun ByteArray.toHex() =
    joinToString("") { "%02x".format(it) }
