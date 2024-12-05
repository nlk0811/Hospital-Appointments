import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitalappointment.data.UserDao
import com.example.hospitalappointment.model.User
import kotlinx.coroutines.launch
import java.util.UUID

class RegistrationViewModel(private val userDao: UserDao) : ViewModel() {

    private val _registrationResult = MutableLiveData<Boolean>()
    val registrationResult: LiveData<Boolean> = _registrationResult

    fun registerUser(name: String, email: String, phone: String) {
        viewModelScope.launch {
            try {
                val user = User(UUID.randomUUID().toString(), name, email, phone)
                userDao.insertUser(user)
                _registrationResult.value = true
            } catch (e: Exception) {
                _registrationResult.value = false
            }
        }
    }
}

