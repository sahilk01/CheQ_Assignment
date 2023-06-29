# CheQ_Assignment

CheQ Assignment with interactive animations and transitions.

## Glimpse

<img src="https://github.com/sahilk01/CheQ_Assignment/blob/master/cheq_assignment_glimpse.gif" width="208">

APK: https://drive.google.com/file/d/1KA6Jjlp8JKLRAxR_U7KOWjbV3jvz0Qhm/view?usp=sharing

Note: For meter animation i've created a custom view named: MeterView but i've removed it from the final app because it was causing frame drops because so many animations are running in the main thread. But if someone wants to try this meter animation they can try implementing MeterView with app:meterText="6000" or any other number. It is still there in the codebase with few improvements it can be much better.
