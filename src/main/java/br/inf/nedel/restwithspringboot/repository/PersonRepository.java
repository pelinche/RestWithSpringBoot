package br.inf.nedel.restwithspringboot.repository;

import br.inf.nedel.restwithspringboot.model.Person;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PersonRepository extends JpaRepository<Person,Long> {
}
