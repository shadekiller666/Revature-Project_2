package com.revature.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.revature.beans.WorkOrder;
import com.revature.services.WorkOrderService;

@RestController
@RequestMapping(path="/workorders")
public class WorkOrderController {
	private WorkOrderService wos;
	
	@Autowired
	public WorkOrderController(WorkOrderService wos) {
		this.wos = wos;
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping
	public List<WorkOrder> getAll() {
		return this.wos.getAll();
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@GetMapping("/{id}")
	public WorkOrder getById(@PathVariable("id") int id) {
		return this.wos.get(id);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PostMapping("/add")
	public WorkOrder add(@RequestBody WorkOrder c) {
		return this.wos.add(c);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@PutMapping("/update")
	public WorkOrder update(@RequestBody WorkOrder c) {
		return this.wos.update(c);
	}
	
	@CrossOrigin(origins = "http://localhost:4200/")
	@DeleteMapping("/delete/{id}")
	public void delete(@PathVariable("id") int id) {
		this.wos.delete(id);
	}
}