package com.nemirovsky.dronedispatcher.repository;

import com.nemirovsky.dronedispatcher.model.Load;
import org.springframework.data.jpa.repository.JpaRepository;

public interface LoadJpaRepository extends JpaRepository<Load, String> {
}
