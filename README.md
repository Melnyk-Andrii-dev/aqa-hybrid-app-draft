# aqa-hybrid-app-draft



## Overview

Current project represents a draft made to speed up creation of a working cross-platform AQA solution for native 
and hybrid applications.

## Stack

- [ ]  Java
- [ ]  Appium + TestNG
- [ ]  Google Guice
- [ ] BrowserStack integration
- [ ] Maven

## Flow and structure

Tests are started with "Test" Maven goal, based on devices / configs defined in "testng.xml".

Separation for platforms, if any is needed (e.g. app looks a bit different on iOS)
is done based on "guice' package classes. If there are more drastic differences, an intermediate layer , 
e.g. IosRobot.class instead of page (screen) object to be used in Tests, can be implemented without
major updates in architecture. Page objects are by default for Android, overriding is needed for Ios (e.g BsTestScreen 
intended to be for Android platform and BsTestScreenIos, which extands BsTestScreen, is for iOS)

Project is devided into 2 logical parts. The first (under "main" folder) - static, which consists of
 app page (screen) objects, elements on that pages, methods to work with those elements and additional utils.
And the second part - (under "test" folder) - dynamic, where all necessary setups and page inreractions themselves
are done, test scenarios are defined in this part.

Suite parameter *isBrowserstackRun* defines the run as a local 
(Android/iOS emulator is needed along with Appium server connection is needed in that case) or as a 
BrowserStack run - configs are in *CapabilityUtils*, this option is preferable.

The "application" folder contains sample applications, current Draft solution has been tested on.