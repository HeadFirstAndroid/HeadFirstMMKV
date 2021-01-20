package me.yifeiyuan.hf.mmkv

import android.app.Application
import android.util.Log
import com.tencent.mmkv.MMKV
import me.yifeiyuan.adh.DebugConfig
import me.yifeiyuan.adh.DebugHelper


private const val TAG = "App"

/**
 * Created by 程序亦非猿 on 2021/1/19.
 */
class App : Application() {

    override fun onCreate() {
        super.onCreate()
        DebugConfig().apply {
            debuggable = true
            application = this@App
            enableStrictMode = false
            detectActivityLifecycle = true
            detectFragmentLifecycle = true
            logLevel = DebugConfig.LogLevel.I
        }.also {
            DebugHelper.setup(it)
        }

        val rootDir: String = MMKV.initialize(this)
        Log.d(TAG, "onCreate: $rootDir") //   /data/user/0/me.yifeiyuan.hf.mmkv/files/mmkv
    }


}