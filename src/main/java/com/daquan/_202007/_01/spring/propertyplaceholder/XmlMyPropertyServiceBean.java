package com.daquan._202007._01.spring.propertyplaceholder;


/**
 * 通过xml方式配置bean以及注入
 */
public class XmlMyPropertyServiceBean {
    private int id;
    private String name;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
