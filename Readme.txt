. Set java complier as 1.8 (project > properties >Compiler>Set checkbox 'Use default complier setting' and set to ver 1.8
. TestCase files are named according to the ID as per Manual test Cases ID
. Less time to track error -As Filename gives where error occured
. Only 1 Excel Sheet , Each sheet name = TC ID = Method Name in Test_Cases Package

//Created using JavE - Text shape editor

                  +--------------------+      +---------+
+--------------+  |Class TestNG_suite  .......|Class GUI|
|Class Driver{}|  |@DataProvider{}     |      +---------+
|IE,chrome,FF  |'''@test{driver,reflect)
+--------------+  |                    |-----+----------+
                  +---------.----------+     |Class Excel
                            |                |(TestData)|
                     +------+-------+        +----------+
                     |Interface     |
                     | (Page Object)|
                     |              |
                  '' |By - locators ''
                     |              |
                     +--------------+   _
                     /           \       ``--..__
                   .'             \              ``--.__
              +---+-----+       +--+------+             ``+---------+
              |         |       |         |               |         |
              |Test1_100|       |Test100_ |               |Test n   |
              |         |       |      200|               |         |
              |         |       |         |               |         |
              +---------+       +---------+               +---------+
              
              
1. User can change the test cases in excel or entering 44,48 in GUI
2. Currently only 3 test cases are created 44,48,52
3. To run right ck on build.gradle >Run as Gradle  in Eclipse
4. To run in Cmd prompt:  refer "http://catchbug.blogspot.in/2016/03/gradle-how-to-set-gradle.html"

How to Run:
1. right ck on build.gradle >Run as Gradle  in Eclipse
2. Files gets downloded
3. GUI will open
4. You can directly check the checkbox and press start  ( use selection already made in excel )
5. Or manually type testcase ID Eg: 44,48 and Press OK

@dataprovider- Loops (@Before-@Test-@AfterTest) in sequencedepeding on the number of test cases or TestID provided in GUI

@Beforemethod -Configures driver ie., IE ,FF etc., but does not open the browser
@Test - User gets the driver arguement here . User needs to specifically enter link or link is fetched from excel(not implemented yet)
@After - closes the driver 