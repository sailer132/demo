package com.demo.csp.repository;

import com.demo.csp.entity.Storage;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface StorageRepository extends JpaRepository<Storage,Long> {

    Storage findByProductId(Long productId);
}
