package com.charles.houseutils.repository;

import com.charles.houseutils.entity.Apartment;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * @author chars
 */
public interface ApartmentRepository extends JpaRepository<Apartment, Long> {

}
