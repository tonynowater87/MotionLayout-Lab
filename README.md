# Android MotionLayout Simple Use Case

### 1. Gradle Setup 
```groovy
ext.constraint_layout_version = '2.0.0-beta7'

dependencies {
    implementation "androidx.constraintlayout:constraintlayout:$constraint_layout_version"
}
```

### 2. Add MotionLayout
  Use MotionLayout to replace the original ConstraintLayout
  
### 3. Create MotionScene.xml for setting Transition, ConstraintSet

### 4. Add the MotionScene.xml path to the tag
 ```xml
 <androidx.constraintlayout.motion.widget.MotionLayout 
    app:layoutDescription="@xml/MotionScene.xml">
    ...
</androidx.constraintlayout.motion.widget.MotionLayout>
 ```
 
## Tips

* 在Code裡啟動MotionLayout
```kotlin
    ml_main.progress = 0f
    ml_main.transitionToEnd() // start -> end
    ml_main.transitionToStart() // end -> start
```

* 啟動Debug Mode 

  ###### 可看目前的FPS, Progress, State, Path

```xml
<androidx.constraintlayout.motion.widget.MotionLayout 
    app:motionDebug="SHOW_ALL">
...
</androidx.constraintlayout.motion.widget.MotionLayout>
```

## Examples

1. Stick view under the toolbar while dragging recyclerview up

<img src="https://i.imgur.com/0IggcmD.gif" width="200">

2. Float action button menu

<img src="https://i.imgur.com/AYTzVqh.gif" width="200">

## Reference
* [how-to-perfect-android-animations-using-motionlayout](https://medium.com/@gilgoldzweig/how-to-perfect-android-animations-using-motionlayout-286cfa0f4f13)
* [official document](https://developer.android.com/reference/androidx/constraintlayout/motion/widget/MotionLayout)