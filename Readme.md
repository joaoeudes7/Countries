## Countries Api 
### Android Library | Kotlin

##### How use?
A sample Android Library to query countries and others info's

##### How use?

Add the repository on gradle of project and implements on module
```groovy
    repositories {
        maven {
            name = "JeDevCountries"
            url = uri("https://maven.pkg.github.com/joaoeudes7/Countries")
        }
    }

    implementation("com.jedev:countries-api:<version>")
```

then invoke the client on your code
```kotlin
    private val apiCountries = CountriesClient(application)
```

Enjoy it or hate :)