package com.gwolf.freshcart.domain.model

import com.gwolf.freshcart.util.UiText

data class ValidationResult(
    val successful: Boolean,
    val errorMessage: UiText? = null
)