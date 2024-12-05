import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.DatePicker
import android.widget.Spinner
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hospitalappointment.R

class AppointmentBookingFragment : Fragment() {

    private lateinit var viewModel: AppointmentBookingViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_appointment_booking, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(AppointmentBookingViewModel::class.java)

        val doctorSpinner: Spinner = view.findViewById(R.id.doctorSpinner)
        val datePicker: DatePicker = view.findViewById(R.id.datePicker)
        val bookButton: Button = view.findViewById(R.id.bookButton)

        bookButton.setOnClickListener {
            val selectedDoctor = doctorSpinner.selectedItem.toString()
            val selectedDate = "${datePicker.year}-${datePicker.month + 1}-${datePicker.dayOfMonth}"
            viewModel.bookAppointment(selectedDoctor, selectedDate)
        }

        viewModel.bookingResult.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(context, "Appointment booked successfully", Toast.LENGTH_SHORT).show()
                // Navigate back to the appointments list or home screen
            } else {
                Toast.makeText(context, "Failed to book appointment", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

