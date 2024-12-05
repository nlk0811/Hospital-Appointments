import androidx.room.*
import com.example.hospitalappointment.model.Appointment

@Dao
interface AppointmentDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAppointment(appointment: Appointment)

    @Query("SELECT * FROM appointment WHERE userId = :userId")
    suspend fun getAppointmentsForUser(userId: String): List<Appointment>
}

