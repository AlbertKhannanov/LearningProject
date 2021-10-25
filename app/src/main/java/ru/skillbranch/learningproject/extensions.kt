package ru.skillbranch.learningproject

import androidx.constraintlayout.motion.widget.MotionLayout
import androidx.constraintlayout.motion.widget.TransitionAdapter
import kotlinx.coroutines.CancellationException
import kotlinx.coroutines.TimeoutCancellationException
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withTimeout
import kotlin.coroutines.resume

suspend fun MotionLayout.awaitTransitionComplete(transitionId: Int, timeout: Long = 10000L) {

    var listener: MotionLayout.TransitionListener? = null

    try {
        withTimeout(timeout) {
            suspendCancellableCoroutine<Unit> { continuation ->
                val l = object : TransitionAdapter() {
                    override fun onTransitionCompleted(motionLayout: MotionLayout, currentId: Int) {
                        if (currentId == transitionId) {
                            removeTransitionListener(this)
                            continuation.resume(Unit)
                        }
                    }
                }
                continuation.invokeOnCancellation {
                    removeTransitionListener(l)
                }
                addTransitionListener(l)
                listener = l
            }
        }
    } catch (tex: TimeoutCancellationException) {
        listener?.let(::removeTransitionListener)
        throw CancellationException("Transition to state with id: $transitionId did not" +
                " complete in timeout.", tex)
    }
}
