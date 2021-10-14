package io.xventure.testing.xventurehibernatepractice.Appointment.Controller;

import io.swagger.v3.oas.annotations.Operation;
import io.xventure.testing.xventurehibernatepractice.Appointment.Service.AppointmentService;
import io.xventure.testing.xventurehibernatepractice.Appointment.dto.AppointmentDTO;
import io.xventure.testing.xventurehibernatepractice.Channel.dto.ChannelDTO;
import io.xventure.testing.xventurehibernatepractice.Error.ErrorSelector;
import io.xventure.testing.xventurehibernatepractice.Error.GenaricException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/appointment")
public class ApointmentController {

    @Autowired
    private AppointmentService service;

    @PostMapping(value = "/addappointment")
    public ResponseEntity<AppointmentDTO> addAppointment(@RequestBody AppointmentDTO appointmentDTO){
        return new ResponseEntity<>(service.addAppointment(appointmentDTO),HttpStatus.OK);
    }

    @GetMapping(value = "/getappointment/{id}")
    public ResponseEntity<AppointmentDTO> getAppointmentById(@PathVariable int id){
        AppointmentDTO appointmentById = service.getAppointmentById(id);
        if(appointmentById==null){
            throw new GenaricException(ErrorSelector.APPOINTMENT_NOT_FOUND);
        }else{
            return new ResponseEntity<>(appointmentById,HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getallappointment")
    public ResponseEntity<List<AppointmentDTO>> getAllAppointments(){
        List<AppointmentDTO> allAppointment = service.getAllAppointment();
        if(allAppointment.isEmpty()){
            throw new GenaricException(ErrorSelector.APPOINTMENT_LIST_IS_EMPTY);
        }else {
            return new ResponseEntity<>(allAppointment,HttpStatus.OK);
        }
    }

    @PutMapping(value = "/updateappointment/{id}")
    @Operation(hidden = true)
    public ResponseEntity<AppointmentDTO> updateAppointment(@RequestBody AppointmentDTO appointmentDTO,@PathVariable int id){
        return null;
    }

    @DeleteMapping(value = "/deleteappointment/{id}")
    public ResponseEntity<Boolean> deleteAppointment(@PathVariable int id){
        if(!service.deleteAppointment(id)){
            throw new GenaricException(ErrorSelector.APPOINTMENT_NOT_FOUND);
        }else{
            return new ResponseEntity<>(true,HttpStatus.OK);
        }
    }
}
