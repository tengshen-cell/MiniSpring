package com.minis.context;

import com.minis.beans.BeanDefinition;
import com.minis.beans.SimpleBeanFactory;
import com.minis.core.ArgumentValue;
import com.minis.core.ArgumentValues;
import com.minis.core.PropertyValue;
import com.minis.core.PropertyValues;
import org.dom4j.Element;

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
            for (Element e : propertyElements) {
                String pType = e.attributeValue("type");
                String pName = e.attributeValue("name");
                String pValue = e.attributeValue("value");
                String ref = e.attributeValue("ref");
                
                propertyValues.addPropertyValue(new PropertyValue(pType, pName, pValue));

            }
            beanDefinition.setPropertyValues(propertyValues);

            //处理构造器参数
            List<Element> constructorElements = element.elements("constructor-arg");
            ArgumentValues AVS = new ArgumentValues();
            for (Element e : constructorElements) {
                String aType = e.attributeValue("type");
                String aName = e.attributeValue("name");
                String aValue = e.attributeValue("value");
                AVS.addArgumentValue(new ArgumentValue(aType, aName, aValue));
            }
            beanDefinition.setConstructorArgumentValues(AVS);
            this.simpleBeanFactory.registerBeanDefinition(beanID, beanDefinition);



        }
    }
}
