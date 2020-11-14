package com.library.repository;
import org.springframework.data.repository.CrudRepository;

import com.library.model.UserRecord;

public interface UserRepository extends CrudRepository<UserRecord, String>   
{    
}   