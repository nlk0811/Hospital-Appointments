import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.hospitalappointment.data.AppointmentDao
import com.example.hospitalappointment.model.Appointment
import kotlinx.coroutines.launch
import java.util.Date
import java.util.UUID

class AppointmentBookingViewModel(private val appointmentDao: AppointmentDao) : ViewModel() {

    private val _bookingResult = MutableLiveData<Boolean>()
    val bookingResult: LiveData<Boolean> = _bookingResult

    fun bookAppointment(doctorId: String, date: String) {
        viewModelScope.launch {
            try {
                val appointment = Appointment(
                    UUID.randomUUID().toString(),
                    doctorId,
                    "current_user_id", // Replace with actual user ID
                    Date(), // Parse the date string to a Date object
                    false // Assuming it's not a virtual appointment
                )
                appointmentDao.insertAppointment(appointment)
                _bookingResult.value = true
            } catch (e: Exception) {
                _bookingResult.value = false
            }
        }
    }
}

