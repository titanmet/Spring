package com.ratnikov.beanslifecycleexercise.lifecycle;

import com.ratnikov.beanslifecycleexercise.domain.FriendPhoneNumber;
import com.ratnikov.beanslifecycleexercise.domain.GirlfriendPhoneNumber;
import org.springframework.beans.BeanMetadataAttribute;
import org.springframework.beans.BeansException;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;
import org.springframework.context.annotation.ScannedGenericBeanDefinition;

public class CustomBeanFactoryPostProcessor implements BeanFactoryPostProcessor {
    @Override
    public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {

        if (beanFactory.containsBean("customLifeCycleBean")) {
            System.out.println("Шаг #1: BeanFactoryPostProcessor.postProcessBeanFactory\n");
        }


//        for (String beanName : beanFactory.getBeanDefinitionNames()) {
//            BeanDefinition d = beanFactory.getBeanDefinition(beanName);
//            if (GirlfriendPhoneNumber.class.getName().equalsIgnoreCase(d.getBeanClassName())) {
//                d.setBeanClassName(FriendPhoneNumber.class.getName());
//                ((ScannedGenericBeanDefinition) d).addMetadataAttribute(new BeanMetadataAttribute("className", FriendPhoneNumber.class.getName()));
//                d.setAutowireCandidate(true);
//            }
//        }

    }
}
