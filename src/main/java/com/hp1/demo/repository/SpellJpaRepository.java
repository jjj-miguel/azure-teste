package com.hp1.demo.repository;

import com.hp1.demo.entity.SpellsEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface SpellJpaRepository extends JpaRepository<SpellsEntity, Long> {
}
