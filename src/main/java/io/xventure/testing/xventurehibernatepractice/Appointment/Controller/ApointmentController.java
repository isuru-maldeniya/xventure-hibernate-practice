package io.xventure.testing.xventurehibernatepractice.Appointment.Controller;

import io.xventure.testing.xventurehibernatepractice.Appointment.dto.AppointmentDTO;
import io.xventure.testing.xventurehibernatepractice.Channel.dto.ChannelDTO;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/appointment")
public class ApointmentController {

    @PostMapping(value = "/addappointment")
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return null;
    }

    @GetMapping(value = "/getappointment/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable int id){
        return null;
    }

    @GetMapping(value = "/getallappointment")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        return null;
    }

    @PutMapping(value = "/updateappointment/{id}")
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO appointmentDTO,@PathVariable int id){
        return null;
    }

    @DeleteMapping(value = "/deleteappointment/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable int id){
        return new ResponseEntity<>(true, HttpStatus.OK);
    }
}
