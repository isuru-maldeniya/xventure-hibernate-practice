package io.xventure.testing.xventurehibernatepractice.Appointment.Repository;

import io.xventure.testing.xventurehibernatepractice.Appointment.Entity.Appointment;
import org.springframework.data.repository.CrudRepository;

public interface AppointmentRepository extends CrudRepository<Appointment, Integer> {
}
