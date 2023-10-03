package model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class HookTest {
    private Hook hook;
    private Miner miner;

    @Before
    public void init(){
        miner = new Miner(new Location(0.4, 0.1));
        hook = new Hook(new Location(0.4, 0.17), miner);
    }
    @After
    public void clear(){
        miner = null;
        hook = null;
    }

    @Test
    public void initTest(){
        // 测试钩子与矿工的绑定
        Assert.assertEquals(hook.getLocation().x, miner.getHook().getLocation().x, 1e-7);
        Assert.assertEquals(hook.getLocation().y, miner.getHook().getLocation().y, 1e-7);
    }

    @Test
    public void GoldTest(){
        Gold gold = new Gold(1);
    }

}

