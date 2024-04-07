package com.abhishek.masterslave.repositories;

import com.abhishek.masterslave.config.db.datasourceutil.DataSourceAnnotation;
import com.abhishek.masterslave.config.db.datasourceutil.DataSourceType;
import com.abhishek.masterslave.entities.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;


@Repository
public interface UserRepository extends JpaRepository<User, Long> {

    @DataSourceAnnotation(value=DataSourceType.SLAVE)
    List<User> findAllBy();
}
