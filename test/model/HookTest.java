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
        // 测试钩子与不同金子的钩中判断
        // size: small = 0, middle = 1, big = 2
        // 采用随机坐标
        Gold smallGold = new Gold(0);
        Gold middleGold = new Gold(1);
        Gold bigGold = new Gold(2);

        // 钩子位置与金子位置重合测试
        hook.setLoc(smallGold.getLocation());
        Assert.assertTrue(hook.canCatch(smallGold));
        hook.setLoc(middleGold.getLocation());
        Assert.assertTrue(hook.canCatch(middleGold));
        hook.setLoc(bigGold.getLocation());
        Assert.assertTrue(hook.canCatch(bigGold));

        // 钩子在金子半径边缘，1201是为了让钩子往内侧偏移
        hook.setLoc(new Location(smallGold.getLocation().x + smallGold.getRadius() / 1201, smallGold.getLocation().y));
        Assert.assertTrue(hook.canCatch(smallGold));
        hook.setLoc(new Location(middleGold.getLocation().x + middleGold.getRadius() / 1201, middleGold.getLocation().y));
        Assert.assertTrue(hook.canCatch(middleGold));
        hook.setLoc(new Location(bigGold.getLocation().x + bigGold.getRadius() / 1201, bigGold.getLocation().y));
        Assert.assertTrue(hook.canCatch(bigGold));
        // 1199处于金子半径外
        hook.setLoc(new Location(smallGold.getLocation().x + smallGold.getRadius() / 1199, smallGold.getLocation().y));
        Assert.assertFalse(hook.canCatch(smallGold));
        hook.setLoc(new Location(middleGold.getLocation().x + middleGold.getRadius() / 1199, middleGold.getLocation().y));
        Assert.assertFalse(hook.canCatch(middleGold));
        hook.setLoc(new Location(bigGold.getLocation().x + bigGold.getRadius() / 1199, bigGold.getLocation().y));
        Assert.assertFalse(hook.canCatch(bigGold));

    }

    @Test
    public void StoneTest(){
        // 随机坐标
        Stone stone = new Stone();
        hook.setLoc(stone.getLocation());
        Assert.assertTrue(hook.canCatch(stone));
        hook.setLoc(new Location(stone.getLocation().x + stone.getRadius() / 1201, stone.getLocation().y));
        Assert.assertTrue(hook.canCatch(stone));
        hook.setLoc(new Location(stone.getLocation().x + stone.getRadius() / 1199, stone.getLocation().y));
        Assert.assertFalse(hook.canCatch(stone));
    }

    @Test
    public void AnimalTest(){
        Animal animal = new Animal();
        hook.setLoc(animal.getLocation());
        Assert.assertTrue(hook.canCatch(animal));
        hook.setLoc(new Location(animal.getLocation().x + animal.getRadius() / 1201, animal.getLocation().y));
        Assert.assertTrue(hook.canCatch(animal));
        hook.setLoc(new Location(animal.getLocation().x + animal.getRadius() / 1199, animal.getLocation().y));
        Assert.assertFalse(hook.canCatch(animal));
    }

    @Test
    public void RandomBagTest(){
        RandomBag rBag = new RandomBag();
        hook.setLoc(rBag.getLocation());
        Assert.assertTrue(hook.canCatch(rBag));
        hook.setLoc(new Location(rBag.getLocation().x + rBag.getRadius()/ 1201, rBag.getLocation().y));
        Assert.assertTrue(hook.canCatch(rBag));
        hook.setLoc(new Location(rBag.getLocation().x + rBag.getRadius()/ 1199, rBag.getLocation().y));
        Assert.assertFalse(hook.canCatch(rBag));
    }

    @Test
    public void EdgeTest(){
        // 采用确定坐标
        Gold smallGold = new Gold(0.5, 0.5, 0);
        Gold middleGold = new Gold(0.5, 0.5, 1);
        Gold bigGold = new Gold(0.5, 0.5, 2);
        Stone stone = new Stone(0.5, 0.5);
        RandomBag rBag = new RandomBag(0.5, 0.5, 1, 1);
        // 由于除法运算会有偏移，处于边缘切线处的测试具有不确定性
        hook.setLoc(new Location(smallGold.getLocation().x + smallGold.getRadius() / 1200, smallGold.getLocation().y));
        Assert.assertFalse(hook.canCatch(smallGold));
        hook.setLoc(new Location(middleGold.getLocation().x + middleGold.getRadius() / 1200, middleGold.getLocation().y));
        Assert.assertFalse(hook.canCatch(middleGold));
        hook.setLoc(new Location(bigGold.getLocation().x + bigGold.getRadius() / 1200, bigGold.getLocation().y));
        Assert.assertFalse(hook.canCatch(bigGold));
        hook.setLoc(new Location(stone.getLocation().x + stone.getRadius() / 1200, stone.getLocation().y));
        Assert.assertFalse(hook.canCatch(stone));
        hook.setLoc(new Location(rBag.getLocation().x + rBag.getRadius() / 1200, rBag.getLocation().y));
        Assert.assertFalse(hook.canCatch(rBag));
    }

}

