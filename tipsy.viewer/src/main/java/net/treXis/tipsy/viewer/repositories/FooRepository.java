package net.treXis.tipsy.viewer.repositories;

import net.treXis.tipsy.viewer.model.Foo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface FooRepository extends JpaRepository<Foo, Long> {
}
