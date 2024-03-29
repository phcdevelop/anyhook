package com.phcdevelop.preview_hook_api.utils

import android.app.Application


/**
 * 基于PreviewActivity中代码，通过放射进行调用
 */
object PreviewHookCheck {

    /**
     * 在app onCreate方法中调用，防止previewHook被别的框架替换掉Handler中的callback
     */
    @JvmStatic
    fun checkOnAppOnCreate(app: Application) {
        kotlin.runCatching {
            val previewHookClass = Class.forName("com.phcdevelop.anyhook.preview_hook.hook.PreviewHook")
            previewHookClass.getMethod("getInstance").invoke(null)?.let { instance ->
                previewHookClass.getMethod("init", Application::class.java).invoke(instance, app)
            }
        }
    }
}