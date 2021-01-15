package br.inf.nedel.restwithspringboot.converter.custom;

import br.inf.nedel.restwithspringboot.data.model.Person;
import br.inf.nedel.restwithspringboot.data.vo.v2.PersonVOV2;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class PersonConverter {

    public PersonVOV2 convertEntityToVO(Person person){
        PersonVOV2 vo = new PersonVOV2();
        vo.setId(person.getId());
        vo.setAddress(person.getAddress());
        vo.setBirthDay(new Date());
        vo.setFirtsName(person.getFirtsName());
        vo.setLastName(person.getLastName());
        vo.setGender(person.getGender());
        return vo;
    }

    public Person convertVOToEntity(PersonVOV2 person){
        Person entity = new Person();
        entity.setId(person.getId());
        entity.setAddress(person.getAddress());
        entity.setFirtsName(person.getFirtsName());
        entity.setLastName(person.getLastName());
        entity.setGender(person.getGender());
        return entity;
    }


}
