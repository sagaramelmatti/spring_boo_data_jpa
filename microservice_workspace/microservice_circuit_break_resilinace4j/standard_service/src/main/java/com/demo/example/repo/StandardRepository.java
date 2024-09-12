package com.demo.example.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.demo.example.entity.StandardDetail;

public interface StandardRepository extends JpaRepository<StandardDetail, Integer> {

}
