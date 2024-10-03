package com.gwolf.freshcart

import androidx.compose.runtime.MutableState
import androidx.compose.runtime.State
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.gwolf.bigcart.data.local.repository.PreferencesKey
import com.gwolf.freshcart.domain.usecase.preference.ReadBooleanPreferenceUseCase
import com.gwolf.freshcart.navigation.Screen
import kotlinx.coroutines.launch
import javax.inject.Inject

class SplashViewModel @Inject constructor(
    private val readBooleanPreference: ReadBooleanPreferenceUseCase,
) : ViewModel() {

    private val _startDestination: MutableState<Screen?> = mutableStateOf(null)
    val startDestination: State<Screen?> = _startDestination

    init {
        viewModelScope.launch {
            readBooleanPreference.invoke(PreferencesKey.onBoardingKey).collect { result ->
                _startDestination.value = if (result) Screen.Auth else Screen.Welcome
            }
        }
    }

}