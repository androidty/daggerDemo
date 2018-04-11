#### Toolbar CollapsingToolbarLayout
[Toolbar：CollapsingToolbarLayout](https://www.jianshu.com/p/8ce727308f29)

#### Behavior
[Behavior](http://blog.csdn.net/yanzhenjie1003/article/details/51938400)

* MaterialDesign

```java
//判断是不是纯数字，不包含浮点数
public boolean isNum(String str){
    boolean result = str.matches("^-?\\d+$")
    if (result == true) {
        System.out.println("该字符串是纯数字");
        return true;
    } else {
        System.out.println("该字符串不是纯数字");
        return false;
    }
}
```

```java
//判断是不是纯数字，包含浮点数
public boolean isNum(String str){
    String reg = "^-?\\d+(\\.\\d+)?$";
    return str.matches(reg);
}
```

