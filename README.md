# AsmCost
Aop之asm切面编程，计算方法耗时插件。

# Gradle

（1）根项目下依赖

    repositories {
        jcenter()
    }
    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.0'
        classpath 'com.xyzlf.asm:method-cost:0.0.2'//依赖方法耗时插件
    }

（2）依赖插件及基本库

    apply plugin: 'com.android.application'
    apply plugin: 'method-cost' //依赖方法耗时插件

    android {
        //...
    }

    dependencies {
        implementation fileTree(include: ['*.jar'], dir: 'libs')
        implementation 'com.android.support:appcompat-v7:26.1.0'

        compile 'com.xyzlf.asm:common-lib:0.0.2'//依赖方法耗时注解
    }

# 使用方式

在方法上方，使用注解@Cost即可。

（1）计算show方法耗时：

    @Cost
    private void show() {
        int count = 0;
        for (int i = 0; i < 100000; i++) {
            count++;
        }
    }

（2）当执行show方法时，会打印耗时日志，过滤关键字 **cost**：

    11-16 00:34:53.066 9619-9619/com.xyzlf.demo I/System.out: [cost] ======== onCreate start ========
    11-16 00:34:53.091 9619-9619/com.xyzlf.demo I/System.out: [cost] onCreate cost 24418 microsecond
    11-16 00:34:53.091 9619-9619/com.xyzlf.demo I/System.out: [cost] ======== onCreate end ========

    11-16 00:34:53.066 9619-9619/com.xyzlf.demo I/System.out: [cost] ======== show start ========
    11-16 00:34:53.091 9619-9619/com.xyzlf.demo I/System.out: [cost] onCreate cost 2145 microsecond
    11-16 00:34:53.091 9619-9619/com.xyzlf.demo I/System.out: [cost] ======== show end ========

# 参考资料

Asm的学习及实践，参考这篇文章：<https://www.diycode.cc/topics/786>，感谢大神的无私分享。

# 关于我

有任何使用问题，可以给我发邮件：

Author：张利峰

E-mail：519578280@qq.com

# License

    Copyright(c)2017 xyzlf Open Source Project

    Licensed under the Apache License, Version 2.0 (the "License");
    you may not use this file except in compliance with the License.
    You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

    Unless required by applicable law or agreed to in writing, software
    distributed under the License is distributed on an "AS IS" BASIS,
    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
    See the License for the specific language governing permissions and
    limitations under the License.