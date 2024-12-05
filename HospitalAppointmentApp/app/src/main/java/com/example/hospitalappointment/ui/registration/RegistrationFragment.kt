import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.example.hospitalappointment.R

class RegistrationFragment : Fragment() {

    private lateinit var viewModel: RegistrationViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_registration, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(RegistrationViewModel::class.java)

        val nameEditText: EditText = view.findViewById(R.id.nameEditText)
        val emailEditText: EditText = view.findViewById(R.id.emailEditText)
        val phoneEditText: EditText = view.findViewById(R.id.phoneEditText)
        val registerButton: Button = view.findViewById(R.id.registerButton)

        registerButton.setOnClickListener {
            val name = nameEditText.text.toString()
            val email = emailEditText.text.toString()
            val phone = phoneEditText.text.toString()

            if (name.isNotEmpty() && email.isNotEmpty() && phone.isNotEmpty()) {
                viewModel.registerUser(name, email, phone)
            } else {
                Toast.makeText(context, "Please fill all fields", Toast.LENGTH_SHORT).show()
            }
        }

        viewModel.registrationResult.observe(viewLifecycleOwner) { success ->
            if (success) {
                Toast.makeText(context, "Registration successful", Toast.LENGTH_SHORT).show()
                // Navigate to login or main screen
            } else {
                Toast.makeText(context, "Registration failed", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

