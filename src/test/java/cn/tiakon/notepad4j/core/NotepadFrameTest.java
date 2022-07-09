package cn.tiakon.notepad4j.core;

import org.junit.Assert;
import org.junit.Test;

public class NotepadFrameTest {

    @Test
    public void getImageTest() {
        Assert.assertNotNull(NotepadFrame.getImageFromResource("/logo.png"));
    }

}
