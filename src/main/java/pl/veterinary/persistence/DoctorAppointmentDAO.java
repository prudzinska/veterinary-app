package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.veterinary.model.DoctorAppointment;

@Transactional
@Repository
public interface DoctorAppointmentDAO extends JpaRepository<DoctorAppointment, Long> {

}
