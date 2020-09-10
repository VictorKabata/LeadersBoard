# LeadersBoard
 LeadersBoard is an android app for end of phase two project assesment for the ALC 5 program that consumes an API to display learners with highest number of hours engaged in the program and learners with highest skill iq in the program.

 The app is developed in **Kotlin** and uses **MVVM Architecture**.

Libraries used for the whole project are:

- [Hilt](https://github.com/google/hilt) - Dependency Injection library.
- [Jetpack](https://developer.android.com/jetpack)
  - [Viewmodel](https://developer.android.com/topic/libraries/architecture/viewmodel) - Manage UI related data in a lifecycle conscious way .
  - [Data Binding](https://developer.android.com/topic/libraries/data-binding) - Support library that allows binding of UI components in  layouts to data sources.

- [Room]() - Provides an abstraction layer over SQLite used for offline data caching.
- [Retrofit](https://square.github.io/retrofit/) - Type-safe http client 
and supports coroutines out of the box.  
- [GSON](https://github.com/square/gson) - JSON Parser,used to parse 
requests on the data layer for Entities and understands Kotlin non-nullable 
and default parameters.
- [OkHttp-Logging-Interceptor](https://github.com/square/okhttp/blob/master/okhttp-logging-interceptor/README.md) - Hogs HTTP request and response data.
- [kotlinx.coroutines](https://github.com/Kotlin/kotlinx.coroutines) - Library Support for coroutines.
- [Material Design](https://material.io/develop/android/docs/getting-started/) - Build awesome beautiful UIs.

## Screenshots.
<img src="screenshots/splash_screen.png" width="280"/>   <img src="screenshots/fragment1.png" width="280"/>  <img src="screenshots/fragment2.png" width="280"/>   <img src="screenshots/submission_blank.png" width="280"/>  <img src="screenshots/submission_filled.png" width="280"/>   <img src="screenshots/submission_confirmation.png" width="280"/>  <img src="screenshots/submission_successful.png" width="280"/>   <img src="screenshots/submission_failed.png" width="280"/>

