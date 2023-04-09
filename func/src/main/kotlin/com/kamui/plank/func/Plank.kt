@file:Suppress("Unused", "MemberVisibilityCanBePrivate")
package com.kamui.plank.func

import android.app.Application
import android.util.Log

/**
 * Enumeration of log message types.
 *
 * @see log
 * @see PlankConfig
 */
enum class Plank(internal val priority: Int) {
    /**
     * Use to send a [Log.DEBUG] message.
     *
     */
    DEBUG(Log.DEBUG),
    /**
     * Use to send a [Log.ERROR] message.
     *
     */
    ERROR(Log.ERROR),
    /**
     * Use to send a [Log.INFO] message.
     *
     */
    INFO(Log.INFO),
    /**
     * Use to send a [Log.VERBOSE] message.
     *
     */
    VERBOSE(Log.VERBOSE),
    /**
     * Use to send a [Log.WARN] message.
     *
     */
    WARN(Log.WARN)
}

/**
 * Object containing logging configuration.
 *
 * @see PlankConfig.mute
 */
object PlankConfig {
    internal var isMuted = false

    /**
     * Mute all messages.
     *
     */
    context(Application)
    fun mute() {
        isMuted = true
    }
}


/**
 * Send a log message.
 *
 * @param message The message you would like logged.
 * @param type Used to specify the type of a message.
 * @param tag Used to identify the source of a log message.
 *            Inferred from caller class by default.
 *
 */
context(Any)
fun log(message: String, type: Plank = Plank.DEBUG, tag: String = this@Any.javaClass.simpleName) {

    if(!PlankConfig.isMuted) Log.println(
        type.priority, tag, message)
}
