package com.gwolf.freshcart.domain.usecase.usecase.validate

import com.gwolf.freshcart.R
import com.gwolf.freshcart.domain.model.ValidationResult
import com.gwolf.freshcart.util.UiText
import com.gwolf.freshcart.util.isRepeatPasswordValid
import javax.inject.Inject

class ValidateRepeatPasswordUseCase @Inject constructor() {
    operator fun invoke(password: String, passwordRepeat: String): ValidationResult {

        if (!isRepeatPasswordValid(password, passwordRepeat)) {
            return ValidationResult(
                successful = false,
                errorMessage = UiText.StringResource(resId = R.string.err_repeat_password_valid),
            )
        }
        return ValidationResult(
            successful = true
        )
    }
}