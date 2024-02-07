## Countries Api 
### Android Library | Kotlin

#### Whats is that?
A sample Android Library to query countries and others info's by https://restcountries.com v3.1

#### How use?

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

Thanks https://restcountries.com

Enjoy it or hate :)
