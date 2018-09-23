package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.veterinary.model.DoctorAppointment;

@Transactional
public interface DoctorAppointmentDAO extends JpaRepository<DoctorAppointment, Long> {

}
