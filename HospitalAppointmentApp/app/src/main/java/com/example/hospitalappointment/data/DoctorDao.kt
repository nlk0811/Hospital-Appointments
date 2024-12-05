import androidx.room.*
import com.example.hospitalappointment.model.Doctor

@Dao
interface DoctorDao {
    @Query("SELECT * FROM doctor")
    suspend fun getAllDoctors(): List<Doctor>

    @Query("SELECT * FROM doctor WHERE specialty = :specialty")
    suspend fun getDoctorsBySpecialty(specialty: String): List<Doctor>
}

