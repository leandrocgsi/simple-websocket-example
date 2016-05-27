package br.com.erudio.services.implementations;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import br.com.erudio.models.Person;
import br.com.erudio.repository.interfaces.IPersonRepository;
import br.com.erudio.services.PersonService;

@Service
public class PersonServiceImpl implements PersonService {
	
	private static final Logger logger = Logger.getLogger(PersonServiceImpl.class);
	
	@Autowired
	private IPersonRepository personRepository;
    
    @Override
    @Transactional
    public Person create(Person person) {
    	try {
    		logger.info("Creating a person");
			person = personRepository.save(person);
		} catch (Exception e) {
			logger.error(e);
		}
		return person;
    }

    @Override
    public Person findById(String personId) {
    	logger.info("Finding a person by ID");
    	Person person = new Person();
		try {
    		logger.info("Finding all persons");
    		person = personRepository.findOne(Long.parseLong(personId));
		} catch (Exception e) {
			logger.error(e);
		}
        return person;
    }
    
    @Override
    public List<Person> findByName(String name) {
    	logger.info("Finding persons by name");
    	List<Person> persons = new ArrayList<>();
    	try {
    		logger.info("Finding all persons");
    		persons = personRepository.findByName(name);
    	} catch (Exception e) {
    		logger.error(e);
    	}
    	return persons;
    }
    
    @Override
    public List<Person> findByNameLike(String name) {
    	logger.info("Finding persons by name with like");
    	List<Person> persons = new ArrayList<>();
    	try {
    		logger.info("Finding all persons");
    		persons = personRepository.findByNameLike("%" + name + "%");
    	} catch (Exception e) {
    		logger.error(e);
    	}
    	return persons;
    }

    @Override
    public List<Person> findAll() {
        ArrayList<Person> persons = new ArrayList<>();
    	try {
    		logger.info("Finding all persons");
            persons = (ArrayList<Person>) personRepository.findAll();
		} catch (Exception e) {
			logger.error(e);
		}
        return persons;
    }
    
    @Override
    @Transactional
    public Person update(Person person) {
    	try {
    		logger.info("Updating a person");
			person = personRepository.save(person);
		} catch (Exception e) {
			logger.error(e);
		}
		return person;
    }

    @Override
    @Transactional
    public void delete(Person person) {
		try {
			logger.info("Deleting a person");
			personRepository.delete(person);
		} catch (Exception ex) {
			logger.error(ex);
		}
    }
}
