package weltonvaz.testebackend.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import weltonvaz.testebackend.domain.Equipment;
import weltonvaz.testebackend.domain.Equipment_state_history;
import weltonvaz.testebackend.repository.EquipmentRepository;
import weltonvaz.testebackend.repository.Equipment_state_historyRepository;

@Service
public class EquipmentService {
	
	@Autowired
	private EquipmentRepository repo;
	
	@Autowired
	private Equipment_state_historyRepository repo1;
	
	public List<Equipment> listAll(){
		return repo.findAll();
	}
	
	public void save(Equipment equipment) {
		repo.save(equipment);
	}
	
	public Equipment get(Integer id) {
		return repo.findById(id).get();
	}
	
	public void delete(Integer id) {
		repo.deleteById(id);
	}
	
}
