package weltonvaz.testebackend.resources;

import java.util.List;
import java.util.NoSuchElementException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import weltonvaz.testebackend.domain.Equipment;
import weltonvaz.testebackend.domain.Equipment_state_history;
import weltonvaz.testebackend.repository.Equipment_state_historyRepository;
import weltonvaz.testebackend.service.EquipmentService;
import weltonvaz.testebackend.service.Equipment_stateService;
import weltonvaz.testebackend.service.Equipment_state_historyService;

@RestController
public class EquipmentController {

	@Autowired
	private EquipmentService service;
	
	@GetMapping("/equipments")
	public List<Equipment> list(){
		return service.listAll();
	}
	
	@GetMapping("/equipments/{id}")
	public ResponseEntity<Equipment> get(@PathVariable Integer id) {
		try {
			Equipment equipment = service.get(id);
			return new ResponseEntity<Equipment>(equipment, HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<Equipment>(HttpStatus.NOT_FOUND);
		}
	}
	
	@PostMapping("/equipments")
	public void add(@RequestBody Equipment equipment) {
		service.save(equipment);
	}
	
	@PutMapping("/equipments/{id}")
	public ResponseEntity<?> update(@RequestBody Equipment equipment, @PathVariable Integer id) {
		try {
			Equipment existEquipment = service.get(id);
			service.save(equipment);
			
			return new ResponseEntity<>(HttpStatus.OK);
		}catch(NoSuchElementException e) {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	
	@DeleteMapping("/equipments/{id}")
	public void delete(@PathVariable Integer id) {
		service.delete(id);
	}
		
}
