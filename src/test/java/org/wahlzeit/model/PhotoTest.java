package org.wahlzeit.model;


import org.junit.Before;
import org.junit.Test;
import org.wahlzeit.services.EmailAddress;
import org.wahlzeit.services.Language;



import java.net.MalformedURLException;
import java.net.URL;

import static org.junit.Assert.*;
import static org.junit.Assert.assertTrue;


public class PhotoTest {

    private Photo testPhoto;


    @Before
    public void initPhoto() {
        PhotoId id = PhotoId.getRandomId();
        testPhoto = new Photo(id);
        assertNotNull(testPhoto);
    }

    /**
     *
     */
    @Test
    public void testConstructor() {

        //testing the different constructors

        //Constructor 1
        Photo testPhoto1 = new Photo();
        assertNotNull(testPhoto1);

        assertEquals(PhotoId.getCurrentIdAsInt(), testPhoto1.getId().asInt());
        assertEquals(0, testPhoto1.getOwnerId());
        assertFalse(testPhoto1.ownerNotifyAboutPraise);
        assertEquals(EmailAddress.EMPTY, testPhoto1.getOwnerEmailAddress());
        assertEquals(Language.ENGLISH, testPhoto1.getOwnerLanguage());
        assertEquals(PhotoSize.MEDIUM, testPhoto1.getMaxPhotoSize());
        assertEquals(Tags.EMPTY_TAGS, testPhoto1.getTags());
        assertEquals(PhotoStatus.VISIBLE, testPhoto1.getStatus());


        //Constructor 2
        PhotoId id = PhotoId.getNextId();
        Photo testPhoto2 = new Photo(id);
        assertNotNull(testPhoto2);

        assertEquals(id, testPhoto2.getId());
        assertEquals(0, testPhoto2.getOwnerId());
        assertFalse(testPhoto1.ownerNotifyAboutPraise);
        assertEquals(EmailAddress.EMPTY, testPhoto2.getOwnerEmailAddress());
        assertEquals(Language.ENGLISH, testPhoto2.getOwnerLanguage());
        assertEquals(PhotoSize.MEDIUM, testPhoto2.getMaxPhotoSize());
        assertEquals(Tags.EMPTY_TAGS, testPhoto2.getTags());
        assertEquals(PhotoStatus.VISIBLE, testPhoto2.getStatus());

    }

    /**
     *
     */
    @Test
    public void testStaticProperties() {

        assertEquals("image", Photo.IMAGE);
        assertEquals("thumb", Photo.THUMB);
        assertEquals("link", Photo.LINK);
        assertEquals("praise", Photo.PRAISE);
        assertEquals("noVotes", Photo.NO_VOTES);
        assertEquals("caption", Photo.CAPTION);

        assertEquals("description", Photo.DESCRIPTION);
        assertEquals("keywords", Photo.KEYWORDS);
        assertEquals("tags", Photo.TAGS);
        assertEquals("status", Photo.STATUS);
        assertEquals("isInvisible", Photo.IS_INVISIBLE);
        assertEquals("uploadedOn", Photo.UPLOADED_ON);


        assertEquals(420, Photo.MAX_PHOTO_WIDTH);
        assertEquals(600, Photo.MAX_PHOTO_HEIGHT);
        assertEquals(105, Photo.MAX_THUMB_PHOTO_WIDTH);
        assertEquals(150, Photo.MAX_THUMB_PHOTO_HEIGHT);

    }

    /**
     *
     */
    @Test
    public void testGetterAndSetter() {

        //test owner id
        testPhoto.setOwnerId(1);
        assertEquals(1, testPhoto.getOwnerId());

        //test location
        double x = 1.5, y = 24.8, z = 20.9;
        Coordinate coordinate = new Coordinate(x, y, z);
        Location location = new Location(coordinate);
        testPhoto.setLocation(location);
        assertEquals(location, testPhoto.getLocation());

        //test ownerName
        testPhoto.setOwnerName("Tester");
        assertEquals("Tester", testPhoto.getOwnerName());

        //test EmailAddress
        EmailAddress emailAddress = EmailAddress.getFromString("test@test.de");
        testPhoto.setOwnerEmailAddress(emailAddress);
        assertEquals(emailAddress, testPhoto.getOwnerEmailAddress());

        //test notifyAboutPraise
        testPhoto.setOwnerNotifyAboutPraise(true);
        assertTrue(testPhoto.getOwnerNotifyAboutPraise());

        //test ownerLanguage
        testPhoto.setOwnerLanguage(Language.JAPANESE);
        assertEquals(Language.JAPANESE, testPhoto.getOwnerLanguage());

        //test OwnerHomePage
        URL url = null;
        try {
            url = new URL("www.test.de");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
        testPhoto.setOwnerHomePage(url);
        assertEquals(url, testPhoto.getOwnerHomePage());


        //test width
        testPhoto.setWidthAndHeight(150, 50);
        assertEquals(150, testPhoto.getWidth());
        assertEquals(50, testPhoto.getHeight());

        //test thumbWidth
        testPhoto.setStatus(PhotoStatus.MODERATED);
        assertEquals(PhotoStatus.MODERATED, testPhoto.getStatus());

        //test tags
        Tags tag = new Tags();
        testPhoto.setTags(tag);
        assertEquals(tag, testPhoto.getTags());

        //test praise
        double praiseSum = testPhoto.praiseSum;
        double noVotes = testPhoto.noVotes;
        assertEquals(praiseSum / noVotes, testPhoto.getPraise(), 0);


        //test summary
        ModelConfig cfg = new EnglishModelConfig();
        assertEquals("10,00", testPhoto.getPraiseAsString(cfg));
        assertEquals("Photo by Tester", testPhoto.getSummary(cfg));
        assertEquals("Photo by Tester", testPhoto.getCaption(cfg));


    }


    @Test
    public void testBooleanMethods() {

        assertTrue(testPhoto.isVisible());

        assertFalse(testPhoto.isWiderThanHigher());
        Tags tags = new Tags("testtag");
        testPhoto.setTags(tags);
        assertTrue(testPhoto.hasTag("testtag"));

        Photo otherPhoto = new Photo();
        otherPhoto.setOwnerName("Tester");
        assertTrue(testPhoto.hasSameOwner(otherPhoto));

        PhotoSize size = PhotoSize.MEDIUM;
        assertTrue(testPhoto.hasPhotoSize(size));

    }



}
