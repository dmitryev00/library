package org.learn.bookrental.repositories;

import org.learn.bookrental.entitys.RentalEntity;
import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.expression.spel.ast.Projection;

import java.util.List;

public interface RentalRepository extends JpaRepository<RentalEntity, Long>
{
	@Override
	@EntityGraph(attributePaths = {"book"})
	List<RentalEntity> findAll();
}
