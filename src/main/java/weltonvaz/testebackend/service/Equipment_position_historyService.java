package weltonvaz.testebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weltonvaz.testebackend.domain.Equipment_position_history;
import weltonvaz.testebackend.domain.Equipment_state_history;
import weltonvaz.testebackend.repository.Equipment_position_historyRepository;

@Service
public class Equipment_position_historyService {
	
	@Autowired
	private Equipment_position_historyRepository repo;
	
	public List<Equipment_position_history> findByOrderByDateDesc(){
		return repo.findByOrderByDateDesc();
	}
	
	public void save(Equipment_position_history equipment) {
		repo.save(equipment);
	}
	
	public Equipment_position_history get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
