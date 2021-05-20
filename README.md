# School_Guider_Updated
A mobile application for personal school usage.

Programmed in Android Studio, using Java and XML. 

Content and Sections: 
Grades, Schedule, Meditation

Grades Subsections: 
School, Achievements, Goals

Schedule Subsections:
Morning, Afternoon, Evening

Meditation Subsections:
Meditation, Music, Reading

Here is an overview of the app:

Navigation Graph 

![Screen Shot 2021-05-17 at 4 54 24 PM](https://user-images.githubusercontent.com/74578068/118555094-3fb3e700-b730-11eb-9e35-02aac76f4f33.png)

This is an overview of how the user can travel from different places from the Main Activity (see next). 

Main Activity

![Screen Shot 2021-05-17 at 4 56 10 PM](https://user-images.githubusercontent.com/74578068/118555231-712cb280-b730-11eb-9126-4da8206c6ab2.png)

When the user first opens the app, this will be the beginning screen. Although the design view does not show this, the user can open the following menu to quickly travel to a particular section. 


School Schedule
The user can select one of three options: Morning, Afternoon, and Evening. Each of these buttons will bring the user to a new fragment with their respectie activities. In addition, the spinners at the bottom are controlled using Java (ArrayList, ArrayAdapter). They can set the text of the button to the different courses that they may be taking. 

![Screen Shot 2021-05-17 at 4 57 10 PM](https://user-images.githubusercontent.com/74578068/118555323-8efa1780-b730-11eb-9789-7fcc77671d10.png)

School Activity 

Similar to the schedule, this is a simplified activity, mainly with the purpose of bringing the user to a particular section within the school guider. 

![Screen Shot 2021-05-17 at 4 57 51 PM](https://user-images.githubusercontent.com/74578068/118555409-a933f580-b730-11eb-8792-8080bff818bf.png)

Notification for School Schedule

This code was inspired by and modified from (https://www.youtube.com/watch?v=yrpimdBRk5Q&t=658s). The user will set a notification by setting a particular time. With the help of Java, the app can trigger the alarm at the time specified. 

![Screen Shot 2021-05-17 at 4 59 00 PM](https://user-images.githubusercontent.com/74578068/118555609-dc768480-b730-11eb-8351-4f219515c663.png)

Meditation

This is an activity that serves as a facilitator for its child fragments.

![Screen Shot 2021-05-17 at 5 00 37 PM](https://user-images.githubusercontent.com/74578068/118555767-0def5000-b731-11eb-8595-f5ee25ad47dd.png)

Notification for Meditation

This triggers a notification at a certain time to remind the user to practice mindfulness. 

![Screen Shot 2021-05-17 at 5 01 10 PM](https://user-images.githubusercontent.com/74578068/118555815-1e072f80-b731-11eb-8535-662507a5f503.png)
