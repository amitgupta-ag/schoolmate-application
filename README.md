#schoolmate application

This is a demonstration to understand xss scripting vulnerabilities in PHP applications.

schoolmate is a PHP bases web-application. 
pixy is a static code taint analysis toolkit.

1. I ran Pixy over schoolmate and found the XSS vulnerabilities. 
2. Since sometimes the taint analysis reports unfeasible paths aswell, so I did an analysis on the results from Pixy to find out the False Positives and the True Positives.
3. I wrote JWebUnit Test cases for all the True positives to hack the application with XSS.
4. Then I fixed the PHP code bugs on the tool and re-run the taint analysis and the JWebUnit XSS tests.


 Hope you enjoy the code!