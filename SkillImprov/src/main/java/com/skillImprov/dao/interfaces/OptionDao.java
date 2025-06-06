package com.skillImprov.dao.interfaces;

import com.skillImprov.entity.Option;
import com.skillImprov.entity.Question;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface OptionDao extends JpaRepository<Option, Long> {
    List<Option> findByQuestion(Question question);
}
