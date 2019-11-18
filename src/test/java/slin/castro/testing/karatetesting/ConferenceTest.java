package slin.castro.testing.karatetesting;

import com.intuit.karate.junit5.Karate;


public class ConferenceTest {

    @Karate.Test
    Karate testSample() {
        return new Karate().feature("sample").relativeTo(getClass());
    }

}
