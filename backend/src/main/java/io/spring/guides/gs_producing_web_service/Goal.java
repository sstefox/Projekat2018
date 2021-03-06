//
// This file was generated by the JavaTM Architecture for XML Binding(JAXB) Reference Implementation, vhudson-jaxb-ri-2.1-2 
// See <a href="http://java.sun.com/xml/jaxb">http://java.sun.com/xml/jaxb</a> 
// Any modifications to this file will be lost upon recompilation of the source schema. 
// Generated on: 2018.08.28 at 05:29:16 AM IST 
//


package io.spring.guides.gs_producing_web_service;

import javax.xml.bind.annotation.XmlEnum;
import javax.xml.bind.annotation.XmlEnumValue;
import javax.xml.bind.annotation.XmlType;


/**
 * <p>Java class for goal.
 * 
 * <p>The following schema fragment specifies the expected content contained within this class.
 * <p>
 * <pre>
 * &lt;simpleType name="goal">
 *   &lt;restriction base="{http://www.w3.org/2001/XMLSchema}string">
 *     &lt;enumeration value="liquibase:diff"/>
 *     &lt;enumeration value="liquibase:update"/>
 *   &lt;/restriction>
 * &lt;/simpleType>
 * </pre>
 * 
 */
@XmlType(name = "goal")
@XmlEnum
public enum Goal {

    @XmlEnumValue("liquibase:diff")
    LIQUIBASE_DIFF("liquibase:diff"),
    @XmlEnumValue("liquibase:update")
    LIQUIBASE_UPDATE("liquibase:update");
    private final String value;

    Goal(String v) {
        value = v;
    }

    public String value() {
        return value;
    }

    public static Goal fromValue(String v) {
        for (Goal c: Goal.values()) {
            if (c.value.equals(v)) {
                return c;
            }
        }
        throw new IllegalArgumentException(v);
    }

}
