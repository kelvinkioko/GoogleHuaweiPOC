package com.dstvflavor.rnconfig

import android.os.Bundle
import android.util.Log
import android.widget.Toast
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.bridge.ReactContextBaseJavaModule
import com.facebook.react.bridge.ReactMethod
import com.huawei.hms.analytics.HiAnalytics
import com.huawei.hms.analytics.HiAnalyticsInstance
import com.huawei.hms.analytics.HiAnalyticsTools
import com.dstvflavor.utils.JsonUtils

class RNHMSAnalytics(reactContext: ReactApplicationContext): ReactContextBaseJavaModule(reactContext) {

    override fun getName(): String = "HMSAnalytics"

    private var instance: HiAnalyticsInstance

    init {
        HiAnalyticsTools.enableLog()
        instance = HiAnalytics.getInstance(reactContext)
        Log.i(RNHMSConstants.ANALYTICS_TAG, instance.toString())
    }

    @ReactMethod
    fun logEvent(eventName: String, bundleString: String) {
        var bundle = Bundle()
        JsonUtils.jsonStringToBundle(bundleString)?.let { bundle = it }
        Toast.makeText(
            reactApplicationContext,
            "eventName: $eventName bundle: $bundleString", Toast.LENGTH_SHORT
        ).show()
        instance.onEvent(eventName, bundle)
    }

    @ReactMethod
    fun setUserProfile(name: String, value: String) {
        Toast.makeText(
            reactApplicationContext,
            "name: $name value: $value", Toast.LENGTH_SHORT
        ).show()
        instance.setUserProfile(name, value)
    }
}
