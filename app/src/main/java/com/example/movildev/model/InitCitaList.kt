import com.example.movildev.model.Cita
import java.util.UUID

class InitCitaList {
    companion object {
        fun init(): List<Cita> {
            return listOf(
                Cita(
                    id = UUID.randomUUID().toString(),
                    fecha = "2025-06-10",
                    hora = "10:00 AM",
                    tipo = "Consulta",
                    modalidad = "Telemedicina",
                    profesional = "Cathalina Cañon",
                    disponible = false
                ),
                Cita(
                    id = UUID.randomUUID().toString(),
                    fecha = "2025-06-30",
                    hora = "11:30 AM",
                    tipo = "Control",
                    modalidad = "Telemedicina",
                    profesional = "Cathalina Cañon",
                    disponible = false
                ),
                Cita(
                    id = UUID.randomUUID().toString(),
                    fecha = "2025-07-05",
                    hora = "09:00 AM",
                    tipo = "Consulta",
                    modalidad = "Presencial",
                    profesional = "Cathalina Cañon",
                    disponible = true
                ),
                Cita(
                    id = UUID.randomUUID().toString(),
                    fecha = "2025-07-12",
                    hora = "02:00 PM",
                    tipo = "Revisión",
                    modalidad = "Telemedicina",
                    profesional = "Cathalina Cañon",
                    disponible = true
                ),
                Cita(
                    id = UUID.randomUUID().toString(),
                    fecha = "2025-07-20",
                    hora = "04:30 PM",
                    tipo = "Control",
                    modalidad = "Presencial",
                    profesional = "Cathalina Cañon",
                    disponible = false
                ),
                Cita(
                    id = UUID.randomUUID().toString(),
                    fecha = "2025-08-01",
                    hora = "08:15 AM",
                    tipo = "Consulta",
                    modalidad = "Telemedicina",
                    profesional = "Cathalina Cañon",
                    disponible = true
                ),
                Cita(
                    id = UUID.randomUUID().toString(),
                    fecha = "2025-08-10",
                    hora = "03:45 PM",
                    tipo = "Control",
                    modalidad = "Presencial",
                    profesional = "Cathalina Cañon",
                    disponible = true
                )
            )
        }
    }
}