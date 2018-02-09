####Toolbar CollapsingToolbarLayout
[Toolbar：CollapsingToolbarLayout](https://www.jianshu.com/p/8ce727308f29)

####Behavior
[Behavior](http://blog.csdn.net/yanzhenjie1003/article/details/51938400)

```java
//判断是不是纯数字，不包含浮点数
public boolean isNum(String str){
     Pattern pattern = Pattern.compile("[0-9]{1,}");
            Matcher matcher = pattern.matcher((CharSequence) str);
    
            boolean result = matcher.matches();
    
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
    String reg = "^[0-9]+(.[0-9]+)?$";
    return str.matches(reg);
}
```

