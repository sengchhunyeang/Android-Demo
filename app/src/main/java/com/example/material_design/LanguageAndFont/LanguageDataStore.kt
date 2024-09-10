package com.example.material_design.LanguageAndFont

import android.content.Context
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.runtime.livedata.observeAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import androidx.lifecycle.*
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.material_design.R
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.launch
import java.util.*

val Context.ds: DataStore<Preferences> by preferencesDataStore("language")

class LanguageDataStore(private val context: Context) {

    companion object {
        val LANG_KEY = stringPreferencesKey("language")
    }

    suspend fun setLanguage(lang: String) {
        context.ds.edit { language -> language[LANG_KEY] = lang }
    }

    val getLanguage: Flow<String> = context.ds.data.map { preferences ->
        preferences[LANG_KEY] ?: "NO DATA"
    }
}

class LanguageViewModel(private val dataStore: LanguageDataStore) : ViewModel() {
    private val _language = MutableLiveData("en")
    val language: LiveData<String> = _language

    init {
        viewModelScope.launch {
            dataStore.getLanguage.collect {
                _language.value = it
            }
        }
    }

    suspend fun saveLanguage(lang: String) {
        dataStore.setLanguage(lang)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun Homescreen(
    viewModel: LanguageViewModel = viewModel(
        factory = DataStoreViewModelFactory(
            LanguageDataStore(LocalContext.current)
        )
    )
) {
    val scope = rememberCoroutineScope()
    val currentLanguage = viewModel.language.observeAsState().value

    SetLanguage(lang = currentLanguage ?: "en")
    Scaffold(
        topBar = {
            TopAppBar(
                colors = TopAppBarDefaults.topAppBarColors(
                    containerColor = MaterialTheme.colorScheme.primaryContainer,
                    titleContentColor = MaterialTheme.colorScheme.primary,
                ),
                title = { Text("Small Top App Bar") }
            )
        }
    ) { innerPadding ->
        Column(modifier = Modifier.padding(innerPadding)) {
            Row {
                Text(text = "Khmer", modifier = Modifier.clickable {
                    scope.launch {
                        viewModel.saveLanguage("km")
                    }
                })
                Spacer(modifier = Modifier.size(10.dp))
                Text(text = "English", modifier = Modifier.clickable {
                    scope.launch {
                        viewModel.saveLanguage("en")
                    }
                })
            }

            Spacer(modifier = Modifier.size(10.dp))

            Text(text = stringResource(id = R.string.welcome))
        }
    }
}

@Composable
fun SetLanguage(lang: String) {
    val locale = Locale(if (lang == "km") "km" else "en")
    val configuration = LocalConfiguration.current
    configuration.setLocale(locale)
    val resources = LocalContext.current.resources
    resources.updateConfiguration(configuration, resources.displayMetrics)
}

class DataStoreViewModelFactory(private val dataStorePreferenceRepository: LanguageDataStore) :
    ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(LanguageViewModel::class.java)) {
            return LanguageViewModel(dataStorePreferenceRepository) as T
        }
        throw IllegalStateException()
    }
}
