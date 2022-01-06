package com.charles.houseutils.controller;

import com.charles.houseutils.constants.ActionType;
import com.charles.houseutils.policy.BrokeragePolicy;
import com.charles.houseutils.policy.BrokeragePolicyFactory;
import org.springframework.web.bind.annotation.GetMapping;
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
public class BrokerageQueryController {

    @GetMapping("/api/calc/brokerage")
    public Long calcBrokerage(@RequestParam ActionType actionType,
                              @RequestParam Long price) {
        BrokeragePolicy policy = BrokeragePolicyFactory.of(actionType);
        return policy.calculate(price);
    }

}
