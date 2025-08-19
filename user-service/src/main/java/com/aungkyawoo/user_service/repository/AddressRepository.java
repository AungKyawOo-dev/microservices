package com.aungkyawoo.user_service.repository;

import com.aungkyawoo.user_service.entity.Address;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

/**
 * Address Repository Interface
 * Author : Aung Kyaw Oo
 */
@Repository
public interface AddressRepository extends JpaRepository<Address, String> {
}
