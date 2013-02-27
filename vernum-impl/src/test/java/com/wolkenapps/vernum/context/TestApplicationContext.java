package com.wolkenapps.vernum.context;

import junit.framework.Assert;
import totalcross.ui.Container;
import totalcross.unit.TestCase;
import totalcross.util.Vector;

import com.wolkenapps.vernum.context.ApplicationContext;
import com.wolkenapps.vernum.context.DefaultApplicationContext;
import com.wolkenapps.vernum.factory.config.BeanDefinition;

public class TestApplicationContext extends TestCase {

    public void testApplicationContextMustInstantiate() {
        ApplicationContext context = new DefaultApplicationContext();
        Assert.assertNotNull(context);
    }

    public void testSingletonMustBeSameObject() {

        ApplicationContext context = new DefaultApplicationContext();
        context.register(new BeanDefinition("container-for-test", BeanDefinition.SCOPE_SINGLETON, Container.class));
        context.start();

        Object one = context.getBean("container-for-test");
        Object other = context.getBean("container-for-test");

        Assert.assertNotNull(one);
        Assert.assertNotNull(other);
        Assert.assertEquals(one, other);

    }

    public void testPrototypeMustNotBeTheSameObject() {
        ApplicationContext context = new DefaultApplicationContext();
        context.register(new BeanDefinition("container-for-test", BeanDefinition.SCOPE_PROTOTYPE, Container.class));
        context.start();
        
        Object one = context.getBean("container-for-test");
        Object other = context.getBean("container-for-test");
        Assert.assertNotNull(one);
        Assert.assertNotNull(other);
        Assert.assertTrue(one != other);
    }

    public void testGetAllBeansOfType() {

        ApplicationContext context = new DefaultApplicationContext();
        context.register(new BeanDefinition("container-for-test1", BeanDefinition.SCOPE_SINGLETON, Container.class));
        context.register(new BeanDefinition("container-for-test2", BeanDefinition.SCOPE_SINGLETON, Container.class));
        context.start();
        
        Vector beansOfType = context.getBeansOfType(Container.class);

        Assert.assertEquals(beansOfType.size(), 2);

    }

    public void testRun() {
        // TODO Auto-generated method stub
    }

}
