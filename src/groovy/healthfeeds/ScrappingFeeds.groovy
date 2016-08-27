package healthfeeds

import geb.Browser

import java.text.SimpleDateFormat

class ScrappingFeeds {
    static void scrapData() {
        Browser.drive() {
            1.upto(3) { pageNo ->
                go("https://blogs.msdn.microsoft.com/healthblog/page/${pageNo}/")
                int size = $("h2.entry-title").size()
                0.upto(size) { linkNo ->
                    try {
                        $("h2.entry-title", linkNo).click()
                        Thread.sleep(1000)
                        String title = $("h1.entry-title").text()
                        String stringDate = $("time.entry-date.published.updated").text()
                        String description = js."\$(document.getElementsByClassName('entry-content single')).html()"

                        if (title != null) {
                            Date publishDate = dateFormat(stringDate)
                            ScrapFeed scrapFeed = new ScrapFeed(title: title, publishDate: publishDate, description: description)

                            //Code for saving scrap data
                            println(scrapFeed.title)
                            println(scrapFeed.publishDate)
                            println(scrapFeed.description)
                        }
                        go("https://blogs.msdn.microsoft.com/healthblog/page/${pageNo}")
                    }
                    catch (Exception ex) {
                        ex.printStackTrace()
                    }

                }
            }
        }


    }

    static Date dateFormat(String stringDate) {
        try {
            SimpleDateFormat smDaateFormate = new SimpleDateFormat("MMMM dd, yyyy")
            Date date = smDaateFormate.parse(stringDate)
        }
        catch (Exception ex) {
            println(ex)
        }
    }
}
