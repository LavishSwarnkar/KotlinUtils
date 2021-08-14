#[YouTube TimeStamp Links Generator](src/TimeStampLinksGenerator.kt)
##The problem
I have an Android course on YouTube (NAAD2.0) consisting of 15 videos. Each of 90 mins average length and having 15-20 YouTube chapters / timestamps.

To use these video timestamps as references to a topic, I needed search functionality. This common search across all videos will also help the viewers easily find the course reference video for a topic.

##Naive Solution
I had already written the timestamps for adding on YouTube. I could simple copy paste all these timestamps into a doc. And then I could search easily. But in this solution, I had to manually adjust the seek to navigate to that chapter or look for it in the description.

##My solution
I wrote a Kotlin program that generates timestamp links - HTML file, given a YouTube video link, title and timestamps string. Then opening that HTML file, I copy all the text (with anchors) and paste it in a doc file.

So, in the end I have a doc file with the timestamp links of all the videos of my course. Using which viewers as well as me can search for video reference of any topic.

**End result - [Index Doc](https://docs.google.com/document/d/1MmZGhEihYh6Hs_t1oiqDd5-jMaXPrwbbE8uYp178MhM/edit?usp=sharing)**
