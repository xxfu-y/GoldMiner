package model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

/**
 * @Author: dogNew0126
 * @Date: 2023-10-03 21:13
 * @Description: AnimalTest
 */
public class AnimalTest {
    private Animal animal;

    @Before
    public void init(){
        animal = new Animal(0.5,0.5,1);
    }

    @After
    public void clear(){
        animal = null;
    }

    /**
     * 测试小猪移动
     * 场景法测试
     * */
    @Test
    public void moveTest(){
        animal.setCaught(true);
        Assert.assertEquals(0.5,animal.getLocation().x,0);
        animal.setCaught(false);
        animal.update();
        Assert.assertEquals(0.502,animal.getLocation().x,0);
        Assert.assertEquals(0.5,animal.getLocation().y,0);
    }

    /**
     * 测试小猪移动到边界时gai'bian'fang'xia
     * 边界值测试
     * */
    @Test
    public void changeDirectionTest(){
        animal.setDirection(-1);
        animal.setLocation(new Location(0.01,0.5));
        animal.update();
        Assert.assertEquals(1,animal.getDirection(),0);
        animal.setDirection(-1);
        animal.setLocation(new Location(0.02,0.5));
        animal.update();
        Assert.assertEquals(1,animal.getDirection(),0);
        animal.setDirection(-1);
        animal.setLocation(new Location(0.03,0.5));
        animal.update();
        Assert.assertEquals(-1,animal.getDirection(),0);
        animal.setDirection(1);
        animal.setLocation(new Location(0.97,0.5));
        animal.update();
        Assert.assertEquals(1,animal.getDirection(),0);
        animal.setDirection(1);
        animal.setLocation(new Location(0.98,0.5));
        animal.update();
        Assert.assertEquals(-1,animal.getDirection(),0);
        animal.setDirection(1);
        animal.setLocation(new Location(0.99,0.5));
        animal.update();
        Assert.assertEquals(-1,animal.getDirection(),0);
    }
}
