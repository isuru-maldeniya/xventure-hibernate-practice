package io.xventure.testing.xventurehibernatepractice.Doctor.Controller;

import io.xventure.testing.xventurehibernatepractice.Doctor.Services.DoctorServices;
import io.xventure.testing.xventurehibernatepractice.Doctor.dto.DoctorDTO;
import io.xventure.testing.xventurehibernatepractice.Error.ErrorSelector;
import io.xventure.testing.xventurehibernatepractice.Error.GenaricException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/doctor")
public class DoctorController {

    @Autowired
    private DoctorServices services;

    @PostMapping(value = "/adddoctor")
    public ResponseEntity<DoctorDTO> addDoctor(@RequestBody DoctorDTO doctorDTO){
        return new ResponseEntity<>(services.addDoctor(doctorDTO),HttpStatus.OK);
    }

    @GetMapping(value = "/getdoctor/{id}")
    public ResponseEntity<DoctorDTO> getDoctorById(@PathVariable int id){
        DoctorDTO doctorDTO= services.getDoctorById(id);
        if(doctorDTO==null){
            throw new GenaricException(ErrorSelector.DOCTOR_NOT_FOUND);
        }else{
            return new ResponseEntity<>(doctorDTO,HttpStatus.OK);
        }
    }

    @GetMapping(value = "/getalldoctors")
    public ResponseEntity<List<DoctorDTO>> getAllDoctors(){
        List<DoctorDTO> doctorDTOS=services.getAllDoctors();
        if(doctorDTOS.isEmpty()){
            throw new GenaricException(ErrorSelector.DOCTOR_LIST_IS_EMPTY);
        }else{
            return new ResponseEntity<>(doctorDTOS,HttpStatus.OK);
        }
    }

    @PutMapping(value = "/updatedoctor/{id}")
    public ResponseEntity<DoctorDTO> updateDoctor(@RequestBody DoctorDTO doctorDTO,@PathVariable int id){
        DoctorDTO dto= services.updateDoctor(doctorDTO, id);
        if(dto==null){
            throw new GenaricException(ErrorSelector.DOCTOR_NOT_FOUND);
        }else{
            return new ResponseEntity<>(dto,HttpStatus.OK);
        }
    }

    @DeleteMapping(value = "/deletedoctor/{id}")
    public ResponseEntity<Boolean> deleteDoctor(@PathVariable int id){
        if(!services.deleteDoctor(id)){
            throw new GenaricException(ErrorSelector.DOCTOR_NOT_FOUND);
        }else{
            return new ResponseEntity<>(true, HttpStatus.OK);
        }
    }
}
