package weltonvaz.testebackend.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import weltonvaz.testebackend.domain.Equipment_model;

@Repository
public interface Equipment_modelRepository extends JpaRepository<Equipment_model, Integer> {

}
