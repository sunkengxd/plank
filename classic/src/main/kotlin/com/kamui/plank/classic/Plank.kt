@file:Suppress("Unused", "MemberVisibilityCanBePrivate")
package com.kamui.plank.classic

import android.app.Application
import android.util.Log

/**
 * Logger with context receivers.
 *
 * @see Plank.mute
 * @see Plank.d
 * @see Plank.e
 * @see Plank.i
 * @see Plank.v
 * @see Plank.w
 */
object Plank {

    private var isMuted = false

    /**
     * Mute all messages.
     *
     */
    context(Application)
    fun mute() {
        isMuted = true
    }

    /**
     * Send a [Log.DEBUG] message.
     * @param message The message you would like logged.
     * @param tag Used to identify the source of a log message.
     *            Inferred from caller class by default
     */
    context(Any)
    fun d(message: String, tag: String = this@Any.javaClass.simpleName) {
        if(!isMuted) Log.println(Log.DEBUG, tag, message)
    }

    /**
     * Send a [Log.ERROR] message.
     * @param message The message you would like logged.
     * @param tag Used to identify the source of a log message.
     *            Inferred from caller class by default
     */
    context(Any)
    fun e(message: String, tag: String = this@Any.javaClass.simpleName) {
        if(!isMuted) Log.println(Log.ERROR, tag, message)
    }

    /**
     * Send a [Log.INFO] message.
     * @param message The message you would like logged.
     * @param tag Used to identify the source of a log message.
     *            Inferred from caller class by default
     */
    context(Any)
    fun i(message: String, tag: String = this@Any.javaClass.simpleName) {
        if(!isMuted) Log.println(Log.INFO, tag, message)
    }

    /**
     * Send a [Log.VERBOSE] message.
     * @param message The message you would like logged.
     * @param tag Used to identify the source of a log message.
     *            Inferred from caller class by default
     */
    context(Any)
    fun v(message: String, tag: String = this@Any.javaClass.simpleName) {
        if(!isMuted) Log.println(Log.VERBOSE, tag, message)
    }

    /**
     * Send a [Log.WARN] message.
     * @param message The message you would like logged.
     * @param tag Used to identify the source of a log message.
     *            Inferred from caller class by default
     */
    context(Any)
    fun w(message: String, tag: String = this@Any.javaClass.simpleName) {
        if(!isMuted) Log.println(Log.WARN, tag, message)
    }
}
