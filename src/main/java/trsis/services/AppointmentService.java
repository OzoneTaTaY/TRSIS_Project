package trsis.services;

import trsis.db.model.Appointment;

public interface AppointmentService {
    Iterable<Appointment> listAll();
    void delete(Integer id);
    Appointment add(String doctorName, String patientName, String appointmentTime);
}
