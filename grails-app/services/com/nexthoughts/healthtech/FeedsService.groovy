package com.nexthoughts.healthtech

import com.sun.syndication.feed.synd.SyndEntry
import com.sun.syndication.feed.synd.SyndFeed
import com.sun.syndication.io.SyndFeedInput
import geb.Browser
import grails.transaction.Transactional
import healthfeeds.FeedRecord
import org.xml.sax.InputSource

@Transactional
class FeedsService {

     List<FeedRecord> getfeed(String url) {
        SyndFeed feed = null;
        InputStream is = null;
        List<SyndEntry> syndEntryList
        String title
        String link
        Date datePublish
        String description
        List<FeedRecord> feedList =[]
        try {
            is = new URL(url).openConnection().getInputStream()
            InputSource source = new InputSource(is)
            SyndFeedInput input = new SyndFeedInput()
            feed = input.build(source)
            syndEntryList = feed.getEntries()
            syndEntryList.each { synd ->
                title = synd.getTitle()
                datePublish = synd.getPublishedDate()
                link = synd.getLink()
                description = descriptionByGeb(link)
                FeedRecord feedRecord = new FeedRecord(title: title,datePublish: datePublish,link: link,description: description)
                feedList.add(feedRecord)
            }

        } catch (Exception e) {
            println("Exception occured ${e}")
        } finally {
            if (is != null) is.close()
        }
        return feedList
    }

    //Geb Method for feed description
     String descriptionByGeb(String url) {
        String description
        Browser.drive() {
            setBaseUrl(url)
            go()
            description = js."\$(document.getElementsByClassName('entry-content')).html()"
        }
        return description
    }

}
