package in.ashokit.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import in.ashokit.entity.Student;
import in.ashokit.repository.StudentRepository;

@RestController
public class StudentRestController 
{
	@Autowired
	private StudentRepository repo;
	
	@PostMapping(value= {"/addMystudnet"},consumes= {"application/xml","application.json"})
	public ResponseEntity<String> addStudent(@RequestBody Student student)
	{
		String msg=null;
		Student stud = repo.save(student);
		if(stud.getSid()!=null)
		{
			msg="Student record saved sucessfully";
		}
		else
		{
			msg="Student record failed to insert";
		}
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}

}
