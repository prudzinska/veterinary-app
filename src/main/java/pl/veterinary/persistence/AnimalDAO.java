package pl.veterinary.persistence;

import javax.transaction.Transactional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import pl.veterinary.model.Animal;

@Transactional
@Repository
public interface AnimalDAO extends JpaRepository<Animal, Long> {

}
