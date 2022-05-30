package ru.gb.lefandoc.springboothw.repository;

import ru.gb.lefandoc.springboothw.data.Role;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends CrudRepository<Role, Long> {
}
