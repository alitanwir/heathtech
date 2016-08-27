package healthfeeds

import com.sun.syndication.feed.synd.SyndEntry
import com.sun.syndication.feed.synd.SyndFeed
import com.sun.syndication.io.SyndFeedInput
import geb.Browser
import geb.navigator.Navigator
import org.xml.sax.InputSource

import java.text.SimpleDateFormat


class FeedRetrieve {

    static List<FeedRecord> getfeed() {
        SyndFeed feed = null;
        InputStream is = null;
        List<SyndEntry> syndEntryList
        String url = "http://feeds.feedburner.com/HealthcareTechnology"
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
                datePublish = synd.publishedDate()
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
    static String descriptionByGeb(String url) {
        String description
        Browser.drive() {
            setBaseUrl(url)
            go()
            description = js."\$(document.getElementsByClassName('entry-content')).html()"
        }
        return description
    }

    //Geb method for scrap news

    static void scrapGeb(){
        println("In geb Scrap")
        Browser.drive(){
            go("https://blogs.msdn.microsoft.com/healthblog/")
            int size = $("h2.entry-title").size()

            0.upto(size){linkNo->
                try{
                    $("h2.entry-title",linkNo).click()
                    Thread.sleep(1000)
                    println("Title:${$("h1.entry-title").text()}")
                    println("Time: ${$("time.entry-date.published.updated").text()}")
                    println("description: ${js."\$(document.getElementsByClassName('entry-content single')).html()"}")
                    go("https://blogs.msdn.microsoft.com/healthblog/")
                }
                catch (Exception ex){

                }

            }
        }

    }
}

