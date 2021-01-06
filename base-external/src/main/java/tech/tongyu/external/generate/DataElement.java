package tech.tongyu.external.generate;

public class DataElement {

    public enum ELEMENT_ENUM {
        STRING,
        //INT,
        //DOUBLE,
        ELEMENT_ITEM
    };

    private String elementName;

    private Object value;

    private ELEMENT_ENUM elementType;

    public DataElement(String elementName, Object value, ELEMENT_ENUM elementType) {
        this.elementName = elementName;
        this.value = value;
        this.elementType = elementType;
    }

    public DataElement(Object value, ELEMENT_ENUM elementType) {
        this.value = value;
        this.elementType = elementType;
    }

    public String getElementName() {
        return elementName;
    }

    public void setElementName(String elementName) {
        this.elementName = elementName;
    }

    public Object getValue() {
        return value;
    }

    public void setValue(Object value) {
        this.value = value;
    }

    public ELEMENT_ENUM getElementType() {
        return elementType;
    }

    public void setElementType(ELEMENT_ENUM elementType) {
        this.elementType = elementType;
    }

    public void setValue(String elementName, Object value, ELEMENT_ENUM elementType) {
        setElementName(elementName);
        setValue(value);
        setElementType(elementType);
    }
}
