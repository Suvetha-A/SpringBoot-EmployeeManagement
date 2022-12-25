package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping()

public class EmpController {
	

	@Autowired emp_repo ob;

	@PostMapping("/addEmployee")
	
	public String saveEmp(@RequestBody Employee emp)
	{
	Employee a= new Employee();
	
	int id= emp.getEmployeeId();
	String name = emp.getEmpName();
	String email= emp.getEmpEmail();
	String dept= emp.getDept();
	
	a.setEmployeeId(id);
	a.setEmpName(name);
	a.setEmpEmail(email);
	a.setDept(dept);
	
	Employee first = new Employee(id,name,email,dept);
	ob.save(first);
	
return "Added successfully";

	}
	
	@GetMapping("/getEmp")
    public List<Employee> getAllEmployee()
    {

        return ob.findAll();

    }
    
    @GetMapping("Emp/{id}")
    public List<Employee> getEmployeeById(@PathVariable("id") int id){
    

    	return ob.findById(id);

        
    }
    
	
	@DeleteMapping("delete/{id}")
    public String deleteById(@PathVariable("id") int id)
    {
	 
		ob.deleteAllByIdInBatch(id);
		
		return "deleted successfully";
}

}
