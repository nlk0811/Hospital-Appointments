import java.util.Date

data class Appointment(
    val id: String,
    val doctorId: String,
    val userId: String,
    val date: Date,
    val isVirtual: Boolean
)

