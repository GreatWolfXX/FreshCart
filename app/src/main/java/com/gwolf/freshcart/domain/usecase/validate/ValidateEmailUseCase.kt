package com.gwolf.freshcart.domain.usecase.validate

import com.gwolf.freshcart.R
import com.gwolf.freshcart.domain.model.ValidationResult
import com.gwolf.freshcart.util.UiText
import com.gwolf.freshcart.util.isEmailValid
import javax.inject.Inject

class ValidateEmailUseCase @Inject constructor() {
    operator fun invoke(input: String): ValidationResult {
        if (input.isBlank()) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.err_field_empty)
            )
        }
        if (!isEmailValid(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.err_email_valid)
            )
        }
        return ValidationResult(
            successful = true,
            errorMessage = null
        )
    }
}