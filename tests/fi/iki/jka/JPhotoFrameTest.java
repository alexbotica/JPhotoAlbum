package fi.iki.jka;

import org.junit.Test;

import java.awt.event.ActionEvent;

import static org.hamcrest.CoreMatchers.equalTo;
import static org.junit.Assert.assertThat;

public class JPhotoFrameTest {

    @Test(expected = NullPointerException.class)
    public void testStartSlideShowIfPhotosAndListAreNull() {
        JPhotoShow show = new JPhotoShow(null, 5000, null);
    }

    @Test
    public void testGetSlideShowInterval() throws Exception {

        String frameName = "test1";
        JPhotoCollection photos = new JPhotoCollection();

        JPhotoFrame frame = new JPhotoFrame()
        {
            @Override
            public void setTitle()
            { }

            @Override
            void handleStartSlideshow(int interval)
            {
                assertThat(interval, equalTo(JPhotoFrame.DEFAULT_SLIDE_SHOW_INTERVAL));
            }
        };

        frame.actionPerformed(new ActionEvent(this, 0, JPhotoMenu.A_SLIDESHOW));
    }

    @Test
    public void testSetSlideShowInterval() throws Exception {

        JPhotoFrame frame = new JPhotoFrame()
        {
            @Override
            public void setTitle()
            { }

            @Override
            void handleStartSlideshow(int interval)
            {
                assertThat(interval, equalTo(JPhotoFrame.DEFAULT_SLIDE_SHOW_INTERVAL / 2));
            }
        };

        frame.actionPerformed(new ActionEvent(this, 0, JPhotoMenu.A_SLIDESHOW_2XF));
    }
}