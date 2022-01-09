package com.charles.houseutils.controller;

import com.charles.houseutils.constants.ActionType;
import com.charles.houseutils.policy.BrokeragePolicy;
import com.charles.houseutils.policy.BrokeragePolicyFactory;
import com.charles.houseutils.service.ApartmentService;
import lombok.AllArgsConstructor;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
*
* 중개수수료가 얼마인지 조회하는 컨트롤러
*
* @author chars
* @version 1.0.0
* 작성일 2022/01/06
**/
@RestController
@AllArgsConstructor
public class BrokerageQueryController {

    private final ApartmentService apartmentService;

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

    @GetMapping("/api/calc/apartment/{apartmentId}")
    public Long calcBrokerageApartmentId(
            @PathVariable Long apartmentId,
            @RequestParam ActionType actionType
    ) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(apartmentService.getPriceOrThrow(apartmentId));
    }

}
