package tech.tongyu.entrance.api;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import tech.tongyu.core.dto.common.BaseElementDTO;
import tech.tongyu.core.dto.common.JsonRequest;
import tech.tongyu.core.service.config.BaseElementService;

import java.util.List;
import java.util.Map;

import static org.springframework.http.MediaType.APPLICATION_JSON_VALUE;

/**
 * @author xiayulin
 * -mailto: xiayulin@tongyu.tech
 * @description 查询BASE_ELEMENT
 */
@RestController
@RequestMapping("base-element")
public class BaseElementApi {

    private BaseElementService baseElementService;

    @Autowired
    public BaseElementApi(BaseElementService baseElementService) {
        this.baseElementService = baseElementService;
    }

    /**
     * 根据code查询BASE_ELEMENT
     *
     * @return
     */
    @PostMapping(value = "search")
    public List<BaseElementDTO> getBaseElementList(@RequestBody JsonRequest jsonRequest) {
        Map<String, Object> params = jsonRequest.getParams();
        return baseElementService.getBaseElementList(params.get("code").toString());
    }

    /**
     * 根据ID更新BASE_ELEMENT表
     *
     * @param jsonRequest 请求数据
     * @return 是否完成
     */
    @PutMapping(value = "update", produces = APPLICATION_JSON_VALUE)
    public Boolean modifyBaseElement(@RequestBody JsonRequest jsonRequest) {
        return baseElementService.updateBaseElement(jsonRequest.getId(), jsonRequest.getParams());
    }

    /**
     * 根据ID删除BASE_ELEMENT表
     *
     * @param id 业务编码
     * @return 是否完成
     */
    @PostMapping(value = "delete")
    public Boolean deleteBaseElement(@RequestParam("id") String id) {
        return baseElementService.deleteBaseElement(id);
    }

    /**
     * 新增BASE_ELEMENT
     *
     * @return
     */
    @PutMapping(value = "add", produces = APPLICATION_JSON_VALUE)
    public Boolean addBaseElement(@RequestBody JsonRequest jsonRequest) {
        return baseElementService.addBaseElement(jsonRequest.getId(), jsonRequest.getParams());
    }
}
