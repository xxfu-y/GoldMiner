package model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

import java.util.ArrayList;


/**
 * @Author: dogNew0126
 * @Date: 2023-10-03 21:56
 * @Description: LocationTest
 */
public class LocationTest {
    private ArrayList<Location> historyLoc = new ArrayList<>();

    @Before
    public void init(){
        historyLoc.add(new Location(0.3,0.7));
        historyLoc.add(new Location(0.7,0.3));
        historyLoc.add(new Location(0.3,0.3));
        historyLoc.add(new Location(0.7,0.7));
        Location.setHistoryLoc(historyLoc);
    }

    @After
    public void clear(){
        historyLoc = null;
    }

    /**
     * 测试Location中tooClose方法，其中两个double相减有误差问题，二进制系统无法精确表示十分之一
     * 边界值测试
     * */
    @Test
    public void tooCloseTest(){
        Assert.assertFalse(Location.tooClose(new Location(0.6,0.8),new Location(0.4,0.3)));
        Assert.assertFalse(Location.tooClose(new Location(0.6,0.8),new Location(0.5,0.3)));
        Assert.assertFalse(Location.tooClose(new Location(0.5,0.8),new Location(0.5,0.3)));
        Assert.assertFalse(Location.tooClose(new Location(0.8,0.6),new Location(0.3,0.4)));
        Assert.assertFalse(Location.tooClose(new Location(0.8,0.6),new Location(0.3,0.5)));
        Assert.assertFalse(Location.tooClose(new Location(0.8,0.5),new Location(0.3,0.5)));
        Assert.assertFalse(Location.tooClose(new Location(0.5,0.6),new Location(0.5,0.4)));
        Assert.assertTrue(Location.tooClose(new Location(0.5,0.6),new Location(0.5,0.5)));
        Assert.assertFalse(Location.tooClose(new Location(0.6,0.5),new Location(0.4,0.5)));
        Assert.assertTrue(Location.tooClose(new Location(0.6,0.5),new Location(0.5,0.5)));
        Assert.assertTrue(Location.tooClose(new Location(0.5,0.5),new Location(0.5,0.5)));
    }

    /**
     * 测试物体能否在刚生成的随机位置生成
     * 等价类测试、边界值测试
     * */
    @Test
    public void isGoodTest(){
        Assert.assertFalse(Location.isGood(new Location(0.35,0.7)));
        Assert.assertFalse(Location.isGood(new Location(0.3,0.7)));
        Assert.assertFalse(Location.isGood(new Location(0.25,0.7)));
        Assert.assertFalse(Location.isGood(new Location(0.7,0.25)));
        Assert.assertFalse(Location.isGood(new Location(0.7,0.3)));
        Assert.assertFalse(Location.isGood(new Location(0.7,0.35)));
        Assert.assertFalse(Location.isGood(new Location(0.3,0.25)));
        Assert.assertFalse(Location.isGood(new Location(0.3,0.3)));
        Assert.assertFalse(Location.isGood(new Location(0.3,0.35)));
        Assert.assertFalse(Location.isGood(new Location(0.7,0.65)));
        Assert.assertFalse(Location.isGood(new Location(0.7,0.7)));
        Assert.assertFalse(Location.isGood(new Location(0.7,0.75)));
        Assert.assertFalse(Location.isGood(new Location(0.98,0.5)));
        Assert.assertTrue(Location.isGood(new Location(0.95,0.5)));
        Assert.assertTrue(Location.isGood(new Location(0.92,0.5)));
        Assert.assertFalse(Location.isGood(new Location(0.02,0.5)));
        Assert.assertTrue(Location.isGood(new Location(0.05,0.5)));
        Assert.assertTrue(Location.isGood(new Location(0.08,0.5)));
        Assert.assertFalse(Location.isGood(new Location(0.5,0.98)));
        Assert.assertTrue(Location.isGood(new Location(0.5,0.95)));
        Assert.assertTrue(Location.isGood(new Location(0.5,0.92)));
    }
}
