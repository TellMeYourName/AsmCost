# AsmCost
Aop之asm切面编程，计算方法耗时插件。

# Gradle

（1）根项目下依赖

    dependencies {
        classpath 'com.android.tools.build:gradle:3.0.0'
        classpath 'com.xyzlf.asm:method-cost:0.0.1'//依赖方法耗时插件
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

        classpath 'com.xyzlf.asm:common-lib:0.0.1'//依赖方法耗时注解
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

（2）当执行show方法时，会打印耗时日志：

    11-15 03:06:57.523 2084-2084/com.xyzlf.asm I/System.out: ======== show start ========
    11-15 03:06:57.531 2084-2084/com.xyzlf.asm I/System.out: show cost 8085 microsecond
    11-15 03:06:57.532 2084-2084/com.xyzlf.asm I/System.out: ======== show end ========

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