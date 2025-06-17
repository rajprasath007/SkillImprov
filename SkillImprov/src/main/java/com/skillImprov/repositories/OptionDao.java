package com.skillImprov.repositories;

import com.skillImprov.entity.Option;
import com.skillImprov.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OptionDao extends JpaRepository<Option, Long> {
    List<Option> findByQuestion(Question question);
}
