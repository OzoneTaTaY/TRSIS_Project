package trsis.db.model;

import lombok.AllArgsConstructor;
import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;

@Entity
@Table(name = "appointment")
@Data
@AllArgsConstructor
public class Appointment  implements Serializable {
    private static final long serialVersionUID = 1L;

    public Appointment(String inputDoctorName, String inputPatientName, String inputAppointmentTime){
        this.doctorName = inputDoctorName;
        this.patientName = inputPatientName;
        this.appointmentTime = inputAppointmentTime;
    }

    @Id
    @Column(name = "appointment_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer id;

    @Column(name = "appointment_doctorname")
    private String doctorName;

    @Column(name = "appointment_patientname")
    private String patientName;

    @Column(name = "appointment_appointmenttime")
    private String appointmentTime;

    public Appointment() {

    }
}
