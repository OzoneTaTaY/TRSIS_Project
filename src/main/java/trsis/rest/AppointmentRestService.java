package trsis.rest;

import trsis.services.AppointmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.core.annotation.AuthenticationPrincipal;
import org.springframework.web.bind.annotation.*;

import java.security.Principal;

@RestController
@RequestMapping("public/rest/appointment")
public class AppointmentRestService {
    @Autowired
    private AppointmentService appointmentService;

    @RequestMapping(value = "", method = RequestMethod.GET)
    public ResponseEntity<Object> browse() {
        return ResponseEntity.ok(appointmentService.listAll());
    }

    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public void delete(@PathVariable("id") Integer id, @AuthenticationPrincipal Principal principal) {

        if (principal == null) {
            throw new ForbiddenException();
        }
        appointmentService.delete(id);
    }

    @RequestMapping(value = "/{doctorname}/{patientname}/{time}", method = RequestMethod.POST)
    public ResponseEntity<Object> add(@PathVariable("doctorname") String doctorName, @PathVariable("patientname") String patientName, @PathVariable("time") String time, @AuthenticationPrincipal Principal principal) {
        if (principal == null) {
            throw new ForbiddenException();
        }
        return ResponseEntity.ok(appointmentService.add(doctorName, patientName, time));
    }

}
