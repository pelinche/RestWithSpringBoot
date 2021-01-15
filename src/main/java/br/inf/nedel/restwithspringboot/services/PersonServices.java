package br.inf.nedel.restwithspringboot.services;

import br.inf.nedel.restwithspringboot.converter.DozerConverter;
import br.inf.nedel.restwithspringboot.data.model.Person;
import br.inf.nedel.restwithspringboot.data.vo.PersonVO;
import br.inf.nedel.restwithspringboot.exception.ResourceNotFoundException;
import br.inf.nedel.restwithspringboot.repository.PersonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


import java.util.List;

@Service
public class PersonServices {

    @Autowired
    PersonRepository repository;

    public PersonVO create(PersonVO person){
        person.setId(null);
        var entity = DozerConverter.parseObject(person, Person.class);
        var vo = DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public List<PersonVO> findAll(){
        return DozerConverter.parseListObjects(repository.findAll(),PersonVO.class);
    }

    public PersonVO findById(Long id){
        var entity =  repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No record found for this ID"));
        return DozerConverter.parseObject(entity, PersonVO.class);
    }

    public PersonVO update(PersonVO person){
        var entity = repository.findById(person.getId())
                .orElseThrow(()->new ResourceNotFoundException("No record found for this ID"));

        entity.setFirtsName(person.getFirtsName());
        entity.setLastName(person.getLastName());
        entity.setAddress(person.getAddress());
        entity.setGender(person.getGender());


        var vo =  DozerConverter.parseObject(repository.save(entity), PersonVO.class);
        return vo;
    }

    public void delete(Long id){
        Person entity = repository.findById(id)
                .orElseThrow(()->new ResourceNotFoundException("No record found for this ID"));
        repository.delete(entity);

    }







}
