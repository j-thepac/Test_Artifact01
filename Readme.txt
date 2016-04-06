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