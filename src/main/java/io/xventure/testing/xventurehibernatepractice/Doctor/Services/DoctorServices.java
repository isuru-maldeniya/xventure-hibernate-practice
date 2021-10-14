package io.xventure.testing.xventurehibernatepractice.Doctor.Services;

import io.xventure.testing.xventurehibernatepractice.Doctor.Entity.Doctor;
import io.xventure.testing.xventurehibernatepractice.Doctor.Repository.DoctorRepository;
import io.xventure.testing.xventurehibernatepractice.Doctor.dto.DoctorDTO;
import io.xventure.testing.xventurehibernatepractice.Error.ErrorSelector;
import io.xventure.testing.xventurehibernatepractice.Error.GenaricException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.LinkedList;
import java.util.List;

@Service
public class DoctorServices {
    @Autowired
    private DoctorRepository repository;

    public DoctorDTO addDoctor(DoctorDTO doctorDTO){
        Doctor save = repository.save(new Doctor(doctorDTO.getName(), doctorDTO.getSpecialization(), doctorDTO.getHospital()));
        return new DoctorDTO(save.getId(), save.getName(), save.getSpecialization(), save.getHospital());
    }


    public DoctorDTO updateDoctor(DoctorDTO doctorDTO, int id){
        if(!repository.existsById(id)){
            return null;
        }else{
            Doctor doctor = repository.findById(id).get();
            if(doctorDTO.getName()!="" &&doctorDTO.getName()!=null){
                doctor.setName(doctorDTO.getName());
            }
            if(doctorDTO.getHospital()!="" && doctorDTO.getHospital()!=null){
                doctor.setHospital(doctor.getHospital());
            }
            if(doctorDTO.getSpecialization()!="" && doctorDTO.getSpecialization()!=null){
                doctor.setSpecialization(doctorDTO.getSpecialization());
            }
            Doctor save = repository.save(doctor);
            return new DoctorDTO(save.getId(), doctor.getName(), doctor.getSpecialization(), doctor.getHospital());
        }
    }


    public DoctorDTO getDoctorById(int id){
        if(!repository.existsById(id)){
            return null;
        }else{
            Doctor doctor = repository.findById(id).get();
            return new DoctorDTO(doctor.getId(), doctor.getName(), doctor.getSpecialization(), doctor.getHospital());
        }
    }

    public List<DoctorDTO> getAllDoctors(){
        List<DoctorDTO> doctorDTOS=new LinkedList<>();
        Iterable<Doctor> all = repository.findAll();
        all.forEach(s->doctorDTOS.add(new DoctorDTO(s.getId(),s.getName(),s.getSpecialization(),s.getHospital())));
        return doctorDTOS;
    }

    public boolean deleteDoctor(int id){
        if(!repository.existsById(id)){
            return false;
        }else{
            repository.deleteById(id);
            return true;
        }
    }
}
