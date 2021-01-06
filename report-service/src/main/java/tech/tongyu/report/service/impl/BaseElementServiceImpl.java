package tech.tongyu.report.service.impl;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import tech.tongyu.core.dto.common.BaseElementDTO;
import tech.tongyu.core.exceptions.CustomException;
import tech.tongyu.core.exceptions.TradeCommonException;
import tech.tongyu.core.service.config.BaseElementService;
import tech.tongyu.core.utils.common.JsonUtils;
import tech.tongyu.model.dao.BaseElementRepo;
import tech.tongyu.model.dao.config.BaseElementDbo;

import java.util.Comparator;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.stream.Collectors;

import static tech.tongyu.core.exceptions.TradeReturnMessage.Errors.DATA_ALREADY_EXISTS;

@Service
public class BaseElementServiceImpl implements BaseElementService {

    private BaseElementRepo baseElementRepo;

    @Autowired
    public BaseElementServiceImpl(BaseElementRepo baseElementRepo) {
        this.baseElementRepo = baseElementRepo;
    }

    @Override
    public List<BaseElementDTO> getBaseElementList(String code) {
        List<BaseElementDbo> baseElementList = baseElementRepo.findAllByCode(code);
        return baseElementList.stream()
                .map(baseElement -> JsonUtils.mapper.convertValue(baseElement, BaseElementDTO.class))
                .sorted(Comparator.comparing(BaseElementDTO::getSort))
                .collect(Collectors.toList());
    }

    @Override
    public Boolean updateBaseElement(String id, Map<String, Object> data) {
        Optional<BaseElementDbo> baseElementDbo = baseElementRepo.findById(id);
        if (baseElementDbo.isPresent()) {
            BaseElementDbo baseElement = baseElementDbo.get();
            BaseElementDTO dataDTO = JsonUtils.mapper.convertValue(data, BaseElementDTO.class);
            BeanUtils.copyProperties(dataDTO, baseElement);
            baseElement.setId(id);
            baseElementRepo.save(baseElement);
            return true;
        } else {
            throw new CustomException("未查找到该id的数据");
        }
    }

    @Override
    public Boolean deleteBaseElement(String id) {
        baseElementRepo.deleteById(id);
        return true;
    }

    @Override
    public Boolean addBaseElement(String id, Map<String, Object> data) {
        Optional<BaseElementDbo> baseElementDbo = baseElementRepo.findById(id);
        if (!baseElementDbo.isPresent()) {
            BaseElementDbo baseElement = new BaseElementDbo();
            BaseElementDTO dataDTO = JsonUtils.mapper.convertValue(data, BaseElementDTO.class);
            BeanUtils.copyProperties(dataDTO, baseElement);
            // TODO 修改uuid;
//            baseElementRepo.save(baseElement);
            return true;
        } else {
            throw new TradeCommonException(DATA_ALREADY_EXISTS, id);
        }
    }

}