# ijkplayer
基于BiliBili开源播放器编译好的so包项目，可直接通过lib的方式进行引用。

新版本支持了https，使用者可以考虑下提升一下代码。

请注意优化.

升级到版本0.7.8.1

## Usage
Add this line to your `build.gradle` file under your module directory. 

```
    compile 'com.github.leifzhang:IjkLib:0.4.0'
```
# 简介
更新了一下ijk的版本号以及升级了一下so包.

正常情况下可以考虑参考以下代码,可以简单的过滤项目的so包.

```
  defaultConfig {
        ndk {
            abiFilters 'armeabi-v7a'
        }
    }
```

升级了ijkplayer的so包以及java代码，同时更好的对lib代码迁移，方便直接关联项目的方式引入。
同时感谢bilibili大神们开源。