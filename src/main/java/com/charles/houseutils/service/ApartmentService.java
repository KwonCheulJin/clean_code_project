package com.charles.houseutils.service;

import com.charles.houseutils.exception.ErrorCode;
import com.charles.houseutils.exception.HouseUtilsException;
import com.charles.houseutils.repository.ApartmentRepository;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

/**
 * @author chars
 */
@Service
@AllArgsConstructor
public class ApartmentService {
    private final ApartmentRepository apartmentRepository;

    @Transactional
    public Long getPriceOrThrow(Long apartmentId) {
        return apartmentRepository.findById(apartmentId)
            .orElseThrow(() -> new HouseUtilsException(ErrorCode.ENTITY_NOT_FOUND))
            .getPrice();
    }
}
