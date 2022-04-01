package com.hyperscale.crudmaster.repositories;

import com.hyperscale.crudmaster.models.Person;
import org.springframework.data.jpa.repository.JpaRepository;

public interface PersonRepository extends JpaRepository<Person, Long> {
}
