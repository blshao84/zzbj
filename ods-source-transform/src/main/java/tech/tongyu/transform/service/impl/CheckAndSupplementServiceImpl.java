package tech.tongyu.transform.service.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tech.tongyu.core.enums.OperationEnum;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.model.dao.config.BaseElementDbo;
import tech.tongyu.transform.check.CheckAction;
import tech.tongyu.transform.manager.CheckActionManager;
import tech.tongyu.transform.service.CheckAndSupplementService;

import java.util.*;
import java.util.stream.Collectors;

import static tech.tongyu.core.service.base.AgreementService.bizId_field;

/**
 * @author wuyongbin
 * - mailto: wuyongbin@tongyu.tech
 * @description 校验与转换
 **/
@Component
public class CheckAndSupplementServiceImpl implements CheckAndSupplementService {

    private CheckActionManager checkActionManager;

    private static final Logger logger = LoggerFactory.getLogger(CheckAndSupplementServiceImpl.class);

    @Autowired
    public CheckAndSupplementServiceImpl(CheckActionManager checkActionManager) {
        this.checkActionManager = checkActionManager;
    }

    @Override
    public Map<String, Object> checkAndSupplementValue(Map<String, Object> data, List<BaseElementDbo> elements) {
        Map<String, Object> linked = new LinkedHashMap<>();
        Map<String, List<BaseElementDbo>> elementMap = elements.stream().collect(Collectors.groupingBy(BaseElementDbo::getElementName));
        for (Map.Entry<String, Object> entry : data.entrySet()) {
            Optional<BaseElementDbo> elementOptional = elementMap.get(entry.getKey()).stream().findFirst();
            if (elementOptional.isPresent()) {
                BaseElementDbo element = elementOptional.get();
                if (Objects.nonNull(element.getListFlag()) && element.getListFlag()) {
                    List<Map<String, Object>> value = (List<Map<String, Object>>) entry.getValue();
                    value.forEach(v -> {
                        for (Map.Entry<String, Object> innerEntry : v.entrySet()) {
                            Optional<BaseElementDbo> innerElementOptional = elementMap.get(innerEntry.getKey()).stream().findFirst();
                            if (innerElementOptional.isPresent()) {
                                BaseElementDbo innerElement = innerElementOptional.get();
                                String checkedData = null;
                                if (Objects.nonNull(innerElement.getFilterClass()) && !innerElement.getFilterClass().equals("")) {
                                    CheckAction checkAction = checkActionManager.getCheckAction(innerElement.getFilterClass());
                                    checkedData = checkAction.execute(v, innerElement.getElementName()).toString();
                                    linked.put(innerElement.getElementName(), checkedData);
                                } else {
                                    linked.put(innerElement.getElementName(), data.get(innerElement.getElementName()));
                                }
                            }
                        }
                    });
                } else {
                    if (Objects.nonNull(data.get(element.getElementName()))) {
                        String checkedData = null;
                        if (Objects.nonNull(element.getFilterClass()) && !element.getFilterClass().equals("")) {
                            CheckAction checkAction = checkActionManager.getCheckAction(element.getFilterClass());
                            checkedData = checkAction.execute(data, element.getElementName()).toString();
                            linked.put(element.getElementName(), checkedData);
                        } else {
                            linked.put(element.getElementName(), data.get(element.getElementName()));
                        }
                    }
                }
            }
        }
        return linked;
    }

    @Override
    public List<Map<String, Object>> getStandardValue(List<Map<String, Object>> dataList, List<BaseElementDbo> elements) {
        return dataList.stream()
                .map(data -> checkAndSupplementValue(data, elements))
                .collect(Collectors.toList());
    }

    @Override
    public LinkedHashMap<String, Object> validData(LinkedHashMap<String, Object> reportData, OperationEnum operation) {
        if (reportData.isEmpty()) {
            throw new CustomException("报送协议中内容存在无数据情况,请重新确认报送信息");
        }
        if (OperationEnum.ADD.equals(operation)) {
            if (reportData.containsKey(bizId_field)) {
                reportData.remove(bizId_field);
            }
        }
        //去除null
        reportData.entrySet().removeIf(entry -> Objects.isNull(entry.getValue()));
        return reportData;
    }
}
