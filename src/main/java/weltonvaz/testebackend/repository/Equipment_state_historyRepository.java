package weltonvaz.testebackend.repository;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import weltonvaz.testebackend.domain.Equipment_state_history;

@Repository
public interface Equipment_state_historyRepository extends JpaRepository<Equipment_state_history, Integer> {
	
	public List<Equipment_state_history> findByOrderByDateDesc();
	
}
