package cn.tiakon.notepad4j.core;

import org.junit.Assert;
import org.junit.Test;

public class NotepadJFrameTest {

    @Test
    public void getImageTest() {
        Assert.assertNotNull(NotepadJFrame.getImageFromResource("/logo.png"));
    }

}
