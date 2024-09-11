import android.util.Log
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.material_design.Retorfit.API.RetrofitClient
import com.example.material_design.Retorfit.Model.UserResponse
import kotlinx.coroutines.launch

class MainViewModel: ViewModel() {
    private val apiService = RetrofitClient.api
    val posts: MutableState < List < UserResponse >> = mutableStateOf(emptyList())
    fun getPosts() {
        viewModelScope.launch {
            try {
                val response = apiService.getUser()
                if (response.isNotEmpty()) {
                    posts.value = response
//                    Log.d("GetPost", "getPosts: ${response}")
                }
            } catch (e: Exception) {
                // Handle errors here
            }
        }
    }
}
