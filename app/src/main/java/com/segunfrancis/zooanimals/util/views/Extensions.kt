package com.segunfrancis.zooanimals.util.views

import android.os.Bundle
import androidx.navigation.NavType
import com.google.gson.Gson
import com.segunfrancis.zooanimals.data.BaseZooResponseItem

class AssetParamType : NavType<BaseZooResponseItem>(isNullableAllowed = false) {
    override fun get(bundle: Bundle, key: String): BaseZooResponseItem? {
        return bundle.getParcelable(key)
    }

    override fun parseValue(value: String): BaseZooResponseItem {
        return Gson().fromJson(value, BaseZooResponseItem::class.java)
    }

    override fun put(bundle: Bundle, key: String, value: BaseZooResponseItem) {
        bundle.putParcelable(key, value)
    }
}
