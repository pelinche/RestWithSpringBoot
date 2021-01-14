package br.inf.nedel.restwithspringboot.services;

import br.inf.nedel.restwithspringboot.model.Person;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;

@Service
public class PersonServices {
    private final AtomicLong counter = new AtomicLong();

    public Person create(Person person){
        return person;
    }

    public Person update(Person person){
        return person;
    }

    public void delete(String id){

    }

    public Person findById(String id){
        Person person = new Person(counter.incrementAndGet(),"Luis Carlos","Eich","Itapiranga","Male");


        return person;
    }

    public List<Person> findAll(){
        List<Person> persons = new ArrayList<>();
        for (int i = 0;i< 8 ; i++){
            Person person = mockPerson(i);
            persons.add(person);
        }
        return persons;
    }


    private Person mockPerson(int i) {
        return new Person(counter.incrementAndGet(),"Person Name "+i,"Last Name "+i,"Some Address "+i,"Undefined "+i);
    }
}
