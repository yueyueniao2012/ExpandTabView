ExpandTabView
=============
今天给大家带了一个好用的控件，大众点评的下拉菜单，当然是仿照显示效果实现的。实现下拉菜单我第一个想到的就是popupwindow。是的，我这里确实使用popupwindow实现的。
因为不同的菜单里面的头部tabbar的个数不一样而且样式也可能不一样，有些里面是listview，有些里面是按钮和一些其他的控件，所以我的思路就渐渐清晰了。

首先，我想构造一个基于LinearLayout的控件，里面动态生成下拉菜单的tab的个数，并控制作为下拉菜单的popupwindow显示隐藏动画效果，即ExpandTabView.java（在源码中）这个类。

然后根据每个菜单子项显示的内容不同，构造不同的组件，传入ExpandTabView中，让其接受ExpandTabView的控制。这样可以保证每个菜单子项的独立性，可以进行各自的风格化，达到高内聚低耦合的效果。同时为了每个菜单子项有一些通用的行为，我在这里构造了一个基类ViewBaseAction.java。

再有就是listview在popupwindow中有个奇怪的现象当popupwindow设置为popupWindow.setFocusable(false)的时候，里面的listview的监听事件失效了，我们只能通过自己构造的监听事件来监听listview的onitemclick事件。具体实现方式详见TextAdapter.java这个类。

License
=================
Copyright (C) 2013 yueyueniao

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at
 
       http://www.apache.org/licenses/LICENSE-2.0
 
Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
