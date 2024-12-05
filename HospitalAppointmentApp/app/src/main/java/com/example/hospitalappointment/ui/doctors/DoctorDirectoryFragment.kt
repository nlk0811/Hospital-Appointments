import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.hospitalappointment.R

class DoctorDirectoryFragment : Fragment() {

    private lateinit var viewModel: DoctorDirectoryViewModel
    private lateinit var doctorAdapter: DoctorAdapter

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        return inflater.inflate(R.layout.fragment_doctor_directory, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(DoctorDirectoryViewModel::class.java)

        val recyclerView: RecyclerView = view.findViewById(R.id.doctorRecyclerView)
        doctorAdapter = DoctorAdapter()
        recyclerView.adapter = doctorAdapter
        recyclerView.layoutManager = LinearLayoutManager(context)

        viewModel.doctors.observe(viewLifecycleOwner) { doctors ->
            doctorAdapter.submitList(doctors)
        }

        viewModel.loadDoctors()
    }
}

