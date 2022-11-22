package com.ta.operations.Controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.ta.operations.model.DBModel;
import com.ta.operations.repository.DBRepository;

@RestController
@RequestMapping("DB")
public class DBController {
	@Autowired
	DBRepository dbRepository;

	@GetMapping("/test1")
	public ResponseEntity<List<DBModel>> getAlltest(@RequestParam(required = false) String area) {
		List<DBModel> test = new LinkedList<DBModel>();
		System.out.println(test);
		try {

			if (area == null)
				dbRepository.findAll().forEach(test::add);
			else
				dbRepository.findByWorkArea(area).forEach(test::add);

			if (test.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			System.out.println(test);
			return new ResponseEntity<>(test, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/test4/{agentCode}")
	public ResponseEntity<DBModel> getDBModelById(@PathVariable("agentCode") String agentCode) {
		System.out.println(agentCode);
		DBModel DBModel = dbRepository.findByCode(agentCode);

		if (DBModel != null) {
			return new ResponseEntity<>(DBModel, HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

	@PostMapping("/test2")
	public ResponseEntity<String> createDBModel(@RequestBody DBModel DBModel) {
		try {
			dbRepository.save(new DBModel(DBModel.getAgentCode(), DBModel.getAgentName(), DBModel.getWorkArea(),
					DBModel.getPhoneNumber(), DBModel.getCountry()));
			return new ResponseEntity<>("DBModel was created successfully.", HttpStatus.CREATED);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@PutMapping("/test5/{agentCode}")
	public ResponseEntity<String> updateDBModel(@PathVariable("agentCode") String agentCode,
			@RequestBody DBModel DBModel) {
		DBModel Model = dbRepository.findByCode(agentCode);

		if (Model != null) {
			Model.setAgentCode(agentCode);
			Model.setAgentName(DBModel.getAgentName());
			Model.setWorkArea(DBModel.getWorkArea());
			Model.setPhoneNumber(DBModel.getPhoneNumber());
			Model.setCountry(DBModel.getCountry());
			dbRepository.update(Model);
			return new ResponseEntity<>("DBModel was updated successfully.", HttpStatus.OK);
		} else {
			return new ResponseEntity<>("Cannot find DBModel with id=" + agentCode, HttpStatus.NOT_FOUND);
		}
	}

	@DeleteMapping("/test6/{agentCode}")
	public ResponseEntity<String> deleteDBModel(@PathVariable("agentCode") String agentCode) {
		try {
			int result = dbRepository.deleteByCode(agentCode);
			if (result == 0) {
				return new ResponseEntity<>("Cannot find DBModel with agentCode=" + agentCode, HttpStatus.OK);
			}
			return new ResponseEntity<>("DBModel was deleted successfully.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cannot delete DBModel.", HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@RequestMapping(value = "/test3", method = RequestMethod.DELETE)
	public ResponseEntity<String> deleteAlltest() {
		try {
			int numRows = dbRepository.deleteAll();
			return new ResponseEntity<>("Deleted " + numRows + " DBModel(s) successfully.", HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>("Cannot delete test.", HttpStatus.INTERNAL_SERVER_ERROR);
		}

	}

	@GetMapping("/test7/{workArea}")
	public ResponseEntity<List<DBModel>> findByWorkArea(String workArea) {
		try {
			List<DBModel> test = dbRepository.findByWorkArea(workArea);

			if (test.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(test, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("print")
	public ResponseEntity<String> printmethod() {

		return new ResponseEntity<>("hoi", HttpStatus.OK);

	}

}