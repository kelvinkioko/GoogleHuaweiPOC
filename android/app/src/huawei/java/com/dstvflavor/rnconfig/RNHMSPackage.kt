package com.dstvflavor.rnconfig

import android.view.View
import com.facebook.react.ReactPackage
import com.facebook.react.bridge.NativeModule
import com.facebook.react.bridge.ReactApplicationContext
import com.facebook.react.uimanager.ReactShadowNode
import com.facebook.react.uimanager.ViewManager
import java.util.*
import kotlin.collections.ArrayList

class RNHMSPackage: ReactPackage {
    override fun createNativeModules(reactContext: ReactApplicationContext): MutableList<NativeModule> {
        val modules: MutableList<NativeModule> = ArrayList()
        modules.add(RNHMSAnalytics(reactContext = reactContext))
        return modules
    }

    override fun createViewManagers(reactContext: ReactApplicationContext):
            MutableList<ViewManager<View, ReactShadowNode<*>>> {
        return Collections.emptyList();
    }
}
