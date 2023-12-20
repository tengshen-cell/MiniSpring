package com.minis.beans.factory.xml;

import com.minis.beans.BeanDefinition;
import com.minis.beans.SimpleBeanFactory;
import com.minis.context.Resource;
import com.minis.core.ConstructorArgumentValue;
import com.minis.core.ConstructorArgumentValues;
import com.minis.core.PropertyValue;
import com.minis.core.PropertyValues;
import org.dom4j.Element;

import java.util.ArrayList;
import java.util.List;

/**
 * @author 滕广银
 * @description TODO
 * @date 2023/11/30 17:42
 */
public class XmlBeanDefinitionReader {

    SimpleBeanFactory simpleBeanFactory;

    public XmlBeanDefinitionReader(SimpleBeanFactory simpleBeanFactory) {
        this.simpleBeanFactory = simpleBeanFactory;
    }

    public void loadBeanDefinitions(Resource resource) {
        while (resource.hasNext()) {
            Element element = (Element) resource.next();
            String beanID = element.attributeValue("id");
            String beanClassName = element.attributeValue("class");
            BeanDefinition beanDefinition = new BeanDefinition(beanID, beanClassName);
            this.simpleBeanFactory.registerBeanDefinition(beanDefinition);

            List<Element> propertyElements = element.elements("property");
            PropertyValues propertyValues = new PropertyValues();
            List refs = new ArrayList<>();
            for (Element e : propertyElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                String pRef = e.attributeValue("ref");
                String pV = "";
                Boolean isRef = false;
                if (pValue != null && !pValue.equals("")) {
                    isRef = false;
                    pV = pValue;
                } else if (pRef != null && !pRef.equals("")) {
                    isRef = true;
                    pV = pRef;
                    refs.add(pRef);
                }
                propertyValues.addPropertyValue(new PropertyValue(pType, pName, pValue, isRef));

            }
            beanDefinition.setPropertyValues(propertyValues);

            String[] refArray = (String[]) refs.toArray(new String[0]);
            beanDefinition.setDependsOn(refArray);

            //处理构造器参数
            List<Element> constructorElements = element.elements("constructor-arg");
            ConstructorArgumentValues AVS = new ConstructorArgumentValues();
            for (Element e : constructorElements) {
                String aType = e.attributeValue("type");
                String aName = e.attributeValue("name");
                String aValue = e.attributeValue("value");
                AVS.addArgumentValue(new ConstructorArgumentValue(aType, aName, aValue));
            }
            beanDefinition.setConstructorArgumentValues(AVS);
            this.simpleBeanFactory.registerBeanDefinition(beanID, beanDefinition);


        }
    }
}
