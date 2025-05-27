package com.skillImprov.dao.interfaces;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Component;

import com.skillImprov.entity.User;
@Component
public interface UserRepo extends CrudRepository<User,Integer>  {

}
