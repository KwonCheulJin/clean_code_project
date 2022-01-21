package com.charles.houseutils.policy;

import com.charles.houseutils.exception.ErrorCode;
import com.charles.houseutils.exception.HouseUtilsException;
import java.util.List;

/**
 * @author chars
 * @version 1.0.0 작성일 2022/01/06
 **/
public interface BrokeragePolicy {

    List<BrokerageRule> getRules();

    default Long calculate(Long price) {
        BrokerageRule brokerageRule = getRules().stream()
            .filter(rule -> price < rule.getLessThan())
            .findFirst().orElseThrow(() -> new HouseUtilsException(ErrorCode.INTERNAL_ERROR));
        return brokerageRule.calcMaxBrokerage(price);
    }

}
