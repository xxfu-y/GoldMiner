package model;

import org.junit.After;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import resource.GMImage;

import javax.sound.sampled.*;
import javax.swing.*;
import java.io.*;

/**
 * @Author: dogNew0126
 * @Date: 2023-10-03 22:21
 * @Description: GetResourceTest
 */
public class GetResourceTest {
    private GMImage image;
    private InputStream inputStream;
    private InputStream bufferedInputStream;
    private AudioInputStream in;
    private AudioFormat outFormat;

    @Before
    public void init(){
        image = new GMImage();
    }

    @After
    public void clear(){
        image = null;
        inputStream = null;
        bufferedInputStream = null;
        in = null;
        outFormat = null;
    }

    /**
     * 加载图片资源测试
     * 场景法
     * */
    @Test
    public void getImageResourceTest(){
        Assert.assertNotNull(new ImageIcon(image.getClass().getResource(  "/res/image/game_background.png")));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/miner1.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/miner2.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/gold.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/stone_1.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/zz.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/hook.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/animal_left.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/animal_right.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/random_bag.png"));
        Assert.assertNotNull(image.getClass().getResource( "/res/image/dialog-frame-yellow.png"));
    }

    @Test
    public void getSoundResourceTest() throws IOException, UnsupportedAudioFileException {
        inputStream = getClass().getResourceAsStream("/res/sound/dig.wav");
        bufferedInputStream = new BufferedInputStream(inputStream);
        in = AudioSystem.getAudioInputStream(bufferedInputStream);
        outFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, in.getFormat().getSampleRate(),
                16, in.getFormat().getChannels(), in.getFormat().getChannels() * 2,
                in.getFormat().getSampleRate(), false);
        Assert.assertNotNull(outFormat);

        inputStream = getClass().getResourceAsStream("/res/sound/high-value.wav");
        bufferedInputStream = new BufferedInputStream(inputStream);
        in = AudioSystem.getAudioInputStream(bufferedInputStream);
        outFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, in.getFormat().getSampleRate(),
                16, in.getFormat().getChannels(), in.getFormat().getChannels() * 2,
                in.getFormat().getSampleRate(), false);
        Assert.assertNotNull(outFormat);

        inputStream = getClass().getResourceAsStream("/res/sound/normal-value.wav");
        bufferedInputStream = new BufferedInputStream(inputStream);
        in = AudioSystem.getAudioInputStream(bufferedInputStream);
        outFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, in.getFormat().getSampleRate(),
                16, in.getFormat().getChannels(), in.getFormat().getChannels() * 2,
                in.getFormat().getSampleRate(), false);
        Assert.assertNotNull(outFormat);

        inputStream = getClass().getResourceAsStream("/res/sound/pull.wav");
        bufferedInputStream = new BufferedInputStream(inputStream);
        in = AudioSystem.getAudioInputStream(bufferedInputStream);
        outFormat = new AudioFormat(
                AudioFormat.Encoding.PCM_SIGNED, in.getFormat().getSampleRate(),
                16, in.getFormat().getChannels(), in.getFormat().getChannels() * 2,
                in.getFormat().getSampleRate(), false);
        Assert.assertNotNull(outFormat);
    }

}
