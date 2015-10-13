package com.angelectro.zt.repository;

import com.angelectro.zt.entity.Student;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Created by Zahit Talipov on 10.10.2015.
 */
@Repository
public interface UserRepository extends JpaRepository<Student, Integer> {

}
