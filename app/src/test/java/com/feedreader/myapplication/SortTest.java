package com.feedreader.myapplication;

import com.feedreader.myapplication.data.RSSElement;
import com.feedreader.myapplication.tools.DateTimeAdapter;
import com.feedreader.myapplication.tools.SortAndFilterAdapter;

import org.joda.time.DateTime;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

public class SortTest {
    DateTimeAdapter dta = new DateTimeAdapter();
    SortAndFilterAdapter sfa = new SortAndFilterAdapter();

    @Test
    public void testSortOldestFirst() {
        DateTime[] testInput = new DateTime[]{
                new DateTime(),
                new DateTime().minusMinutes(1), //current time
                new DateTime().minusHours(1),
                new DateTime().minusDays(2),
                new DateTime().minusDays(6),
                new DateTime().minusDays(8),
        };
        RSSElement re = new RSSElement();
        RSSElement re1 = new RSSElement();
        RSSElement re2 = new RSSElement();
        RSSElement re3 = new RSSElement();
        RSSElement re4 = new RSSElement();
        RSSElement re5 = new RSSElement();

        re.setPubDate(dta.formatDateTime(testInput[0]));
        re1.setPubDate(dta.formatDateTime(testInput[1]));
        re2.setPubDate(dta.formatDateTime(testInput[2]));
        re3.setPubDate(dta.formatDateTime(testInput[3]));
        re4.setPubDate(dta.formatDateTime(testInput[4]));
        re5.setPubDate(dta.formatDateTime(testInput[5]));

        ArrayList<RSSElement> rssInput = new ArrayList<>();
        rssInput.add(re);
        rssInput.add(re1);
        rssInput.add(re2);
        rssInput.add(re3);
        rssInput.add(re4);
        rssInput.add(re5);

        ArrayList<RSSElement> expectedOutput = new ArrayList<>();
        expectedOutput.add(re5);
        expectedOutput.add(re4);
        expectedOutput.add(re3);
        expectedOutput.add(re2);
        expectedOutput.add(re1);
        expectedOutput.add(re);

        for (int i = 0; i < testInput.length; i++) {
            assertTrue(sfa.sortOldestFirst(rssInput).equals(expectedOutput));
        }
    }

    @Test
    public void testSortNewestFirst() {
        DateTime[] testInput = new DateTime[]{
                new DateTime(),
                new DateTime().minusMinutes(1), //current time
                new DateTime().minusHours(1),
                new DateTime().minusDays(2),
                new DateTime().minusDays(6),
                new DateTime().minusDays(8),
        };
        RSSElement re = new RSSElement();
        RSSElement re1 = new RSSElement();
        RSSElement re2 = new RSSElement();
        RSSElement re3 = new RSSElement();
        RSSElement re4 = new RSSElement();
        RSSElement re5 = new RSSElement();

        re.setPubDate(dta.formatDateTime(testInput[0]));
        re1.setPubDate(dta.formatDateTime(testInput[1]));
        re2.setPubDate(dta.formatDateTime(testInput[2]));
        re3.setPubDate(dta.formatDateTime(testInput[3]));
        re4.setPubDate(dta.formatDateTime(testInput[4]));
        re5.setPubDate(dta.formatDateTime(testInput[5]));

        ArrayList<RSSElement> rssInput = new ArrayList<>();
        rssInput.add(re5);
        rssInput.add(re4);
        rssInput.add(re3);
        rssInput.add(re2);
        rssInput.add(re1);
        rssInput.add(re);

        ArrayList<RSSElement> expectedOutput = new ArrayList<>();
        expectedOutput.add(re);
        expectedOutput.add(re1);
        expectedOutput.add(re2);
        expectedOutput.add(re3);
        expectedOutput.add(re4);
        expectedOutput.add(re5);

        for (int i=0; i<testInput.length; i++) {
            assertTrue(sfa.sortNewestFirst(rssInput).equals(expectedOutput));
        }
    }
}
