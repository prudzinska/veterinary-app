package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;

import pl.veterinary.model.Animal;

@Transactional
public interface AnimalDAO extends JpaRepository<Animal, Long> {

}
