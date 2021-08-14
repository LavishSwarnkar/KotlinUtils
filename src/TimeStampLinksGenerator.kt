import java.io.BufferedWriter
import java.io.File
import java.io.FileWriter
import java.io.IOException

val videoLink = "https://www.youtube.com/watch?v=ULZcww1AHYI&t=%ds"
val videoTitle = "8.2 Developing the Gallery App"
val timeStampsStr =
    """0:00 1 - Item Card Layout
3:36 include
3:55 Wrapping root inside ScrollView
4:56 2 - #AddImageDialog Layout
6:03 2.1 - #InputDimensions Root
11:45 Creating a group
13:11 2.2 - #ProgressIndicator Root
16:13 2.3 - main ItemInput Root
17:24 Shrinking all views
18:35 2.3.1 Color ChipGroup
21:34 singleSelection = true
21:44 Extracting Layout
22:32 2.3.2 Label ChipGroup
25:17 Custom Label Input
30:56 Delaying using Handler.postDelayed()
32:07 Wrapping Dialog layout inside ScrollView
32:40 Modifying all titles
34:05 indeterminate = true
34:30 3 - Testing Color & Label ChipGroup
36:07 Drawable to Bitmap
38:53 Passing color as ColorStateList
39:49 #HashSet & getColorsFromPalette()
41:54 Multi cursor
43:13 Label ChipGroup
45:58 4 - ItemHelper Class
47:07 #Asynchronous tasks can't return
47:31 And now Listeners
48:06 Your own Listener
49:27 Using Helper class
50:26 Defining ItemHelper
52:43 String.format()
53:11 Adding context to ItemHelper
54:23 Sequential &! Parallel
1:03:00 Using our ItemHelper
1:05:38 Think before you pass Context
1:06:41 5 - AddImageDialog class
1:07:22 Why listener in Dialog?
1:09:09 LayoutInflater not accessible from context
1:09:45 Casting context to Activity
1:10:37 //TODO : 
1:19:49 Passing this as listener
1:22:26 Global LayoutInflater
1:24:34 Adding AddImage Action
1:27:47 Bug#1 : Forgot Custom Label Input
1:28:01 Bug#2 : Default selection
1:31:11 AddImage event
1:31:46 getCheckedChipId()
1:34:26 findViewById() ?
1:35:58 ImageAddedListener
1:38:45 Item class
1:41:57 Inflating ItemCard & adding item to the list
1:45:00 Bug#3 : Keyboard still visible after input
1:45:12 Bug#4 : Label EditText visible initially
1:46:33 getCurrentFocus() not accessible from context
1:47:23 Calling Activity method from other classes
1:49:03 Why Label EditText became visible?
1:49:47 Bug#3 : Keyboard still visible
1:50:06 Bug#5 : LabelET.inputType = number
1:50:20 Solving keyboard problem
1:51:56 Bug#6 : 2 ocean chips
1:52:18 Test, Test & Test
1:53:28 Bug#7 : Custom label shown as Custom
1:55:05 #Debugging in Android Studio
1:55:34 setValue() in Debugger
1:56:07 Here is the 🐛
1:57:17 Still not resolved 🤦🏻‍♂️😆
1:57:21 Hitting it then & there
1:58:00 Koshish karne walo ki kabhi haar nahi hoti
1:58:17 Bug#8 : used padding instead of margin
1:59:30 Enhancement : Ripple Click effect
2:00:10 We did it!
2:00:34 It's Gallery &! Demo"""

val htmlFormat = "<!DOCTYPE html><html><body><h1>%s</h1><ul>%s</ul></body></html>"

fun main() {
    val timeStamps = timeStampsStr.split("\n")

    val sb = StringBuilder()    //To save link items

    for(timeStamp in timeStamps){

        //Extract time
        val time = timeStamp.substring(0, timeStamp.indexOf(" "))
        val parts = time.split(":")
        val secs = when (parts.size) {
            2 -> parts[0].toInt() * 60 + parts[1].toInt()
            3 -> (parts[0].toInt() * 60 + parts[1].toInt()) * 60 + parts[2].toInt()
            else -> 0
        }

        //Generate link
        val link = videoLink.format(secs)

        //Generate list item
        sb.append("<li>")
            .append("<a href=\"%s\">%s</a>".format(link, timeStamp))
            .append("</li>")
    }

    //Generate final HTML
    val html = htmlFormat.format(videoTitle, sb.toString())

    //Write to file
    print(html)
}

fun write(s: String?) {
    val filePath = "C:\\Users\\HP\\IdeaProjects\\Lose_If_First-Game\\src\\main\\resources\\8.2.html"

    try {
        val file = File(filePath)
        if(!file.exists())
            file.createNewFile()
        BufferedWriter(FileWriter(filePath)).append(s).close()
    } catch (e: IOException) {
        e.printStackTrace()
    }
}