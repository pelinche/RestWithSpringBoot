package br.inf.nedel.restwithspringboot.converter.mocks;

import br.inf.nedel.restwithspringboot.data.model.Person;
import br.inf.nedel.restwithspringboot.data.vo.PersonVO;

import java.util.ArrayList;
import java.util.List;

public class MockPerson {
    public  Person mockEntity(){
        return mockEntity(0);
    }

    public PersonVO mockVO(){
        return mockVO(0);
    }

    public List<Person> mockEntityList(){
        List<Person> persons = new ArrayList<Person>();
        for (int i = 0 ; i<14;i++){
            persons.add(mockEntity(i));
        }
        return persons;
    }

    public List<PersonVO> mockVOList(){
        List<PersonVO> persons = new ArrayList<>();
        for(int i = 0;i<14;i++){
            persons.add(mockVO(i));
        }
        return persons;
    }

    private Person mockEntity(Integer number){
        Person person = new Person();
        person.setAddress("Address Test"+number);
        person.setFirtsName("First Name Test"+number);
        person.setGender(((number%2)==0)?"Male":"Famale");
        person.setId(number.longValue());
        person.setLastName("Last Name Test"+number);
        return person;
    }

    private PersonVO mockVO(Integer number){
        PersonVO person = new PersonVO();
        person.setAddress("Address Test"+number);
        person.setFirtsName("First Name Test"+number);
        person.setGender(((number%2)==0)?"Male":"Famale");
        person.setId(number.longValue());
        person.setLastName("Last Name Test"+number);
        return person;
    }

}
