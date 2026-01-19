package org.learn.bookrental.repositories;

import org.learn.bookrental.entitys.RentalEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface RentalRepository extends JpaRepository<RentalEntity, Long>
{

}
