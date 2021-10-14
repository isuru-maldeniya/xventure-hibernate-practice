package io.xventure.testing.xventurehibernatepractice.Doctor.Repository;

import io.xventure.testing.xventurehibernatepractice.Doctor.Entity.Doctor;
import org.springframework.data.repository.CrudRepository;

public interface DoctorRepository extends CrudRepository<Doctor, Integer> {
}
