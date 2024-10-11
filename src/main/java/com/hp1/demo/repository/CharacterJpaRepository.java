package com.hp1.demo.repository;

import com.hp1.demo.entity.CharacterEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CharacterJpaRepository extends JpaRepository<CharacterEntity, Long> {
}
