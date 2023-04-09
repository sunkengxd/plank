@file:Suppress("Unused", "ClassName")

package com.kamui.plank.seal

import android.app.Application
import android.util.Log

/**
 * Supertype of log message types.
 *
 * @see log
 * @see Plank.muteAll
 * @see Plank.mute
 */
sealed class Plank(
    internal val priority: Int,
    internal var isMuted: Boolean = areAllMuted
) {

    /**
     * Companion object containing logging configuration.
     *
     * @see Plank.mute
     */
    companion object Config {

        internal var areAllMuted: Boolean = false

        /**
         * Mute all messages of all types.
         *
         */
        context(Application)
        fun muteAll() {
            areAllMuted = true
        }

//        context(Application)
//        inline operator fun invoke(block: Parameters.() -> Unit) = block(Parameters)
    }

    /**
     * Mute all messages of a type.
     *
     */
    context(Application)
    fun mute() {
        isMuted = true
    }
}

/**
 * Use to send a [Log.DEBUG] message.
 *
 */
object debug : Plank(priority = Log.DEBUG)

/**
 * Use to send a [Log.ERROR] message.
 *
 */
object error : Plank(priority = Log.ERROR)

/**
 * Use to send a [Log.INFO] message.
 *
 */
object info : Plank(priority = Log.INFO)

/**
 * Use to send a [Log.VERBOSE] message.
 *
 */
object verbose : Plank(priority = Log.VERBOSE)

/**
 * Use to send a [Log.WARN] message.
 *
 */
object warn : Plank(priority = Log.WARN)

/**
 * Send a log message.
 *
 * @receiver The message to be logged
 *
 * @param type Used to specify the type of a message.
 *
 * @see debug
 * @see error
 * @see info
 * @see verbose
 * @see warn
 */
context(Any)
infix fun String.log(type: Plank) {
    if(!type.isMuted || !Plank.areAllMuted) Log.println(
        type.priority, this@Any.javaClass.simpleName, this)
}
