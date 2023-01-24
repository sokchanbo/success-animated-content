## Installation

Add JitPack repository to your setting file **setting.gradle**

```groovy
dependencyResolutionManagement {
    repositoriesMode.set(RepositoriesMode.FAIL_ON_PROJECT_REPOS)
    repositories {
        ....
        maven("https://jitpack.io")
    }
}
```

after that add the dependency to **app/build.gradle** file

```groovy
 implementation("com.github.sokchanbo:success-animated-content:latest-version")
```

## Usage

```kotlin
YourComposeTheme {
    SuccessAnimatedContent(
        content = {
            Text(
                text = "Upload profile successfully",
                style = MaterialTheme.typography.h5,
                textAlign = TextAlign.Center
            )
        },
        footer = {
            Button(
                onClick = {},
                modifier = Modifier.fillMaxWidth(),
                contentPadding = PaddingValues(16.dp),
                shape = CircleShape
            ) {
                Text(text = "Done")
            }
        }
    )
}
```

For full example, refer
to [here](https://github.com/sokchanbo/success-animated-content/blob/main/app/src/main/java/com/chanbo/successanimatedcontentdemo/MainActivity.kt)
.

## License

```
Copyright 2023 sokchanbo
 
Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    https://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```