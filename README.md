# FilterEmojis
Android Library to filter emojis from a string.

get the library

Step 1. Add the JitPack repository to your build file

Add it in your root build.gradle at the end of repositories:

```
allprojects {
		repositories {
			...
			maven { url 'https://jitpack.io' }
		}
	}
  
  ```
  Step 2. Add the dependency
  ```
  dependencies {
	        implementation 'com.github.AhmMhd:FilterEmojis:1.0.0'
	}
  ```
 **************************************************************************************************************************************
  # USAGE
```
val containsEmoji : Emojis.containsEmojis(edittext.text.toString)
```



