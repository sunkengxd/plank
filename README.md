  <p align=center>
 [![License: MIT](https://img.shields.io/badge/License-MIT-yellow.svg)](https://opensource.org/licenses/MIT) [![](https://jitpack.io/v/sunkengxd/plank.svg)](https://jitpack.io/#sunkengxd/plank)
# Plank
</p>

Plank is an Android library for easy logging using context receivers.

## Flavours

There are 3 flavours to choose from:

1. Seal:
```kotlin
"Logging using the «seal» flavour" log debug
```

2. Func:
```kotlin
log("Logging using the «func» flavour")
```

3. Classic:
```kotlin
Plank.d("Logging using the «classic» flavour")
```

All of the above yield the same results and the tag is inferred based on the class from which the message is logged. In this case, **the only difference is syntax**.

## Installation
1. Choose one flavour:
    - Seal
    ```kotlin
    implementation("com.github.sunkengxd.plank:seal:1.1.4")
    ```
    - Func
    ```kotlin
    implementation("com.github.sunkengxd.plank:func:1.1.4")
    ```
    - Classic
    ```kotlin
    implementation("com.github.sunkengxd.plank:classic:1.1.4")
    ```

2. Add kotlin compiler options:
```kotlin
// module-level build.gradle.kts
kotlinOptions {
    // ...
    freeCompilerArgs = listOf("-Xcontext-receivers")
}
```

## Usage
Apart from logging, the library supports muting the messages. All of the below can only be called from the *Application* class.

1. Seal:
```kotlin
Plank.muteAll() // prevents any logging
verbose.mute() // mutes all verbose type messages
```

2. Func:
```kotlin
PlankConfig.mute() // the same as muteAll() from seal
```

3. Classic:
```kotlin
Plank.mute() // the same as mute() from func or muteAll() from seal
```

### Additional parameters
- *tag* – functions from the **func** and **seal** flavours can receive a parameter *tag*, in case you want messages from different classes to have the same name or just want a custom tag.
- *type* – log() from the **func** flavour also accepts this optional parameter denoting whether it is a debug, info, warn or some other type of message. Defaults to debug.

## Limitations
Due to the *Any* context receiver of these functions, they cannot be used inside top-level functions.

## Feedback

Any feedback is welcome!
