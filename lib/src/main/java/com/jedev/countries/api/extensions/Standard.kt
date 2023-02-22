package com.jedev.countries.api.extensions

fun <T> T.alsoIf(cacheEnabled: Boolean, function: (T) -> Unit) = also {
    if (cacheEnabled) {
        function(this)
    }
}
