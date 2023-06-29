<img src="https://www.multiplyventures.com/web/wp-content/uploads/2022/07/cheq-logo.png" width="208">

# CheQ Assignment

### CheQ Assignment UI with interactive animations, custom views and transitions. Created in a way that these UI is highly customizable and re-usable throughout the app. Just Like a Library.

Note: For meter animation i've created a custom view named: MeterView and I have created 2 seperate apks because meter animation was causing frame drops because so many animations are running in the main thread. For now i am not using MeterView in the final codebase but MeterView is already there in the codebase so if someone want to try implementing MeterView. They can try by applying app:meterText="6000" or any other number.

## Glimpse With Meter (Might have frame drops)

<img src="https://github.com/sahilk01/CheQ_Assignment/blob/master/glimpse_with_meter.gif" width="208">

APK: https://drive.google.com/file/d/1rN3eU73OYeWgiEqZSr8kP6RV2Y_Ap4tw/view?usp=sharing

## Glimpse (Without Meter)

<img src="https://github.com/sahilk01/CheQ_Assignment/blob/master/cheq_assignment_glimpse.gif" width="208">

APK: https://drive.google.com/file/d/1KA6Jjlp8JKLRAxR_U7KOWjbV3jvz0Qhm/view?usp=sharing


## Features

- HomeFragment with Multiple Smooth Transitions Using Motion Layout.
- UI Translations.
- Apply Push Down Animation to any kind of view.
- Re-usable theming throughout the app.


## Flow

MainActivity -> HomeFragment -> RewardsFragment


## Possible improvements

- Use lifecycleScope in MeterView instead of CoroutinesScope.
- MeterView and BalanceView can be created in a way that they can change fields programatically.
- Use higher res views for demo.
- Expect Integer instead of String in MeterView.



## Author

- [@sahilk01](https://www.github.com/sahilk01)

## 🔗 Links
[![linkedin](https://img.shields.io/badge/linkedin-0A66C2?style=for-the-badge&logo=linkedin&logoColor=white)](https://in.linkedin.com/in/sahil-khan-63841a16a)

