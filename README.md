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
app:motionDebug="SHOW_ALL" 
```

## Examples

1. Stick view under the toolbar while dragging recyclerview up

<img src="https://i.imgur.com/0IggcmD.gif" width="200">

```xml
<!-- UI XML -->
<?xml version="1.0" encoding="utf-8"?>
<androidx.constraintlayout.motion.widget.MotionLayout xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:app="http://schemas.android.com/apk/res-auto"
    xmlns:tools="http://schemas.android.com/tools"
    android:layout_width="match_parent"
    android:layout_height="match_parent"
    app:layoutDescription="@xml/scene_stick_view_below_toolbar"
    tools:context=".MainActivity">

    <androidx.appcompat.widget.Toolbar
        android:id="@+id/toolbar"
        android:layout_width="match_parent"
        android:layout_height="?actionBarSize"
        android:background="@color/colorPrimaryDark"
        android:elevation="4dp"
        app:title="Stick item below toolbar"
        app:titleTextColor="@android:color/black" />

    <FrameLayout
        android:id="@+id/view_pager_mock"
        android:layout_width="0dp"
        android:layout_height="150dp"
        android:background="@android:color/holo_orange_dark"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@id/toolbar">

        <ImageView
            android:layout_width="match_parent"
            android:layout_height="match_parent"
            android:src="@drawable/ic_launcher_foreground" />
    </FrameLayout>

    <View
        android:id="@+id/view_stick_top_mock"
        android:layout_width="0dp"
        android:layout_height="80dp"
        android:background="@android:color/holo_green_light"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/view_pager_mock" />

    <androidx.recyclerview.widget.RecyclerView
        android:id="@+id/rv"
        android:layout_width="0dp"
        android:layout_height="0dp"
        app:layout_constraintBottom_toBottomOf="parent"
        app:layout_constraintEnd_toEndOf="parent"
        app:layout_constraintStart_toStartOf="parent"
        app:layout_constraintTop_toBottomOf="@+id/view_stick_top_mock" />

</androidx.constraintlayout.motion.widget.MotionLayout>
```

```xml
<!-- MotionScene -->
<?xml version="1.0" encoding="utf-8"?>
<MotionScene xmlns:android="http://schemas.android.com/apk/res/android"
    xmlns:motion="http://schemas.android.com/apk/res-auto">

    <Transition
        motion:constraintSetEnd="@id/end"
        motion:constraintSetStart="@id/start"
        motion:motionInterpolator="easeInOut">

        <OnSwipe
            motion:dragDirection="dragUp"
            motion:touchAnchorId="@id/rv" />

    </Transition>

    <ConstraintSet android:id="@+id/start">

        <Constraint
            android:id="@+id/view_pager_mock"
            android:layout_width="0dp"
            android:layout_height="150dp"
            motion:layout_constraintEnd_toEndOf="parent"
            motion:layout_constraintStart_toStartOf="parent"
            motion:layout_constraintTop_toBottomOf="@+id/toolbar" />

        <Constraint
            android:id="@+id/view_stick_top_mock"
            android:layout_width="0dp"
            android:layout_height="80dp"
            motion:layout_constraintEnd_toEndOf="parent"
            motion:layout_constraintStart_toStartOf="parent"
            motion:layout_constraintTop_toBottomOf="@+id/view_pager_mock" />

        <Constraint android:id="@+id/toolbar">
            <CustomAttribute
                motion:attributeName="titleTextColor"
                motion:customColorValue="@android:color/black" />

        </Constraint>

    </ConstraintSet>

    <ConstraintSet android:id="@+id/end">

        <Constraint
            android:id="@+id/view_pager_mock"
            android:layout_width="0dp"
            android:layout_height="150dp"
            motion:layout_constraintEnd_toEndOf="parent"
            motion:layout_constraintStart_toStartOf="parent"
            motion:layout_constraintBottom_toBottomOf="@id/toolbar"/>

        <Constraint
            android:id="@+id/view_stick_top_mock"
            android:layout_width="0dp"
            android:layout_height="80dp"
            motion:layout_constraintEnd_toEndOf="parent"
            motion:layout_constraintStart_toStartOf="parent"
            motion:layout_constraintTop_toBottomOf="@+id/toolbar" />

        <Constraint android:id="@+id/toolbar">
            <CustomAttribute
                motion:attributeName="titleTextColor"
                motion:customColorValue="@android:color/white" />
        </Constraint>

    </ConstraintSet>

</MotionScene>
```

2. Float action button menu

<img src="https://i.imgur.com/AYTzVqh.gif" width="200">

## Reference
* [how-to-perfect-android-animations-using-motionlayout](https://medium.com/@gilgoldzweig/how-to-perfect-android-animations-using-motionlayout-286cfa0f4f13)* [how-to-perfect-android-animations-using-motionlayout](https://medium.com/@gilgoldzweig/how-to-perfect-android-animations-using-motionlayout-286cfa0f4f13)
* [official document](https://developer.android.com/reference/androidx/constraintlayout/motion/widget/MotionLayout)