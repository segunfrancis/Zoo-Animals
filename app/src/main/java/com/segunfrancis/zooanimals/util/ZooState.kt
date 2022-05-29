package com.segunfrancis.zooanimals.util

import com.segunfrancis.zooanimals.data.BaseZooResponse

sealed class ZooState {
    data class Success(val data: BaseZooResponse): ZooState()
    data class Error(val error: Throwable): ZooState()
    object Loading : ZooState()
}
