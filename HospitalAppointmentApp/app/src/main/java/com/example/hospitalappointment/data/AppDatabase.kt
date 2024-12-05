import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.hospitalappointment.model.User
import com.example.hospitalappointment.model.Doctor
import com.example.hospitalappointment.model.Appointment

@Database(entities = [User::class, Doctor::class, Appointment::class], version = 1)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun userDao(): UserDao
    abstract fun doctorDao(): DoctorDao
    abstract fun appointmentDao(): AppointmentDao
}

