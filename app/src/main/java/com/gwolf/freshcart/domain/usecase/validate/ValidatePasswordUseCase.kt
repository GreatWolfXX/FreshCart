package com.gwolf.freshcart.domain.usecase.validate

import com.gwolf.freshcart.R
import com.gwolf.freshcart.domain.model.ValidationResult
import com.gwolf.freshcart.util.MIN_PASSWORD_LENGTH
import com.gwolf.freshcart.util.UiText
import com.gwolf.freshcart.util.isPasswordValid
import javax.inject.Inject

class ValidatePasswordUseCase @Inject constructor() {
    operator fun invoke(input: String): ValidationResult {
        if (input.length < MIN_PASSWORD_LENGTH) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.err_password_length),
            )
        }

        if (!isPasswordValid(input)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.err_password_valid),
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}