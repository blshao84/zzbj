package tech.tongyu.external.generate;

import java.util.ArrayList;
import java.util.List;

public class ElementItem {
    /**
     * 字段列表
     */
    private List<DataElement> dataElementList = new ArrayList<>();

    public List<DataElement> getElementList() {
        return dataElementList;
    }

    public void setElementList(List<DataElement> dataElementList) {
        this.dataElementList = dataElementList;
    }

    public void addElement(DataElement dataElement) {
        this.dataElementList.add(dataElement);
    }
}
