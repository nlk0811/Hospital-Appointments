import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitalappointment.data.DoctorDao
import com.example.hospitalappointment.model.Doctor
import kotlinx.coroutines.launch

class DoctorDirectoryViewModel(private val doctorDao: DoctorDao) : ViewModel() {

    private val _doctors = MutableLiveData<List<Doctor>>()
    val doctors: LiveData<List<Doctor>> = _doctors

    fun loadDoctors() {
        viewModelScope.launch {
            _doctors.value = doctorDao.getAllDoctors()
        }
    }
}

