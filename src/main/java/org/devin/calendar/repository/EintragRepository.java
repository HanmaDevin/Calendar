package org.devin.calendar.repository;

import org.devin.calendar.model.Eintrag;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface EintragRepository extends JpaRepository<Eintrag, Long> {
}
