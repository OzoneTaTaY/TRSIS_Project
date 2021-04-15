package trsis.services;

import trsis.db.dao.AppointmentRepository;
import trsis.db.model.Appointment;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class AppointmentServiceImpl implements AppointmentService {


    @Autowired
    private AppointmentRepository appointmentRepository;
    @Override
    public Iterable<Appointment> listAll() {

        return appointmentRepository.findAll();
    }

    @Override
    public void delete(Integer id) {
        appointmentRepository.deleteById(id);
    }

    @Override
    public Appointment add(String doctorName, String patientName, String appointmentTime) {
        return appointmentRepository.save(new Appointment(doctorName, patientName, appointmentTime));
    }

}
