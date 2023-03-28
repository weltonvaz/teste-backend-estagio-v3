package weltonvaz.testebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weltonvaz.testebackend.domain.Equipment_state_history;
import weltonvaz.testebackend.repository.Equipment_state_historyRepository;

@Service
public class Equipment_state_historyService {
	
	@Autowired
	private Equipment_state_historyRepository repo;
		
	public List<Equipment_state_history> findByOrderByDateDesc(){
		return repo.findByOrderByDateDesc();
	}
	
	public List<Equipment_state_history> listaTodos(){
		return (List<Equipment_state_history>) repo.findAll();
	}

	public void save(Equipment_state_history equipment) {
		repo.save(equipment);
	}
	
	public Equipment_state_history get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}