package com.cg.controllers;

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
import org.springframework.web.bind.annotation.RestController;

import com.cg.entities.Manager;
import com.cg.exception.CertificationNotFoundException;
import com.cg.exception.PersonNotFoundException;
import com.cg.exception.QualificationNotFoundException;
import com.cg.services.ManagerService;
import com.cg.services.TransactionService;


@RestController
@RequestMapping("/manager")
public class ManagerController {
	
	@Autowired
	private ManagerService managerService;
	
	@Autowired
	private TransactionService transactionService;
	
	@PostMapping("/addManager")
	public String addManagerDetails(@RequestBody Manager manager)
	{
		return managerService.addManager(manager);
	}
	
	@GetMapping("/getAllManager")
	public List<Manager> getAllManagers()
	{
		return managerService.getAll();
	}
	
    @GetMapping("/getManager/{id}")
    public ResponseEntity<Object> getManagerById(@PathVariable("id") int id)
    		throws PersonNotFoundException
    {
		return new ResponseEntity<>(managerService.getManagerById(id),HttpStatus.OK);
    }
	
	@DeleteMapping("/delManager/{id}")
	public String deleteManagerById(@PathVariable("id") int id)
	{
		return managerService.deleteManagerInfo(id);
	}
	
	@PutMapping("/updateManagerList")
	public List<Manager> updateManagerList(@RequestBody Manager manager)
	{
		return managerService.updateManagerData(manager);
	}
	
	// http://localhost:8081/updateManagerDetails/68/ScrumMaster
	@PutMapping("/updateManagerDetails/{id}/{certification}")
	public List<Manager> updateManagerDetails(@PathVariable("id") int id,@PathVariable("certification") String cdertification)
	{
		return managerService.updateManagerCertification(id, cdertification);
	}
	
	@GetMapping("/getManagerDOJ/{id}")
	public String getManagerDOJById(@PathVariable("id") long id)
	{
		return managerService.getDOJById(id);
	}
	
	@GetMapping("/getManagerByQualification/{qualification}")
	public List<Manager> getManagerByQualification(@PathVariable("qualification") String qualification) 
			throws QualificationNotFoundException
	{
		return managerService.getByQualification(qualification);
	}
	
	@GetMapping("/getManagerByCertification/{certification}")
	public List<Manager> getManagerByCertification(@PathVariable("certification") String certification) 
			throws CertificationNotFoundException
	{
		return managerService.getByCertification(certification);
	}
	
	@GetMapping("/getAllMoney")
	public double getAllMoney()
	{
		return transactionService.getAllMoney();
	}
	
	@GetMapping("/getAllRentMoney")
	public double getAllRentMoney()
	{
		return transactionService.getAllRentMoney();
	}

}
