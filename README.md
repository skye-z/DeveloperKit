# 堆栈开发者工具包

项目包名: cc.stacks.developer

开始时间: 2015年11月12日

### 使用方法

目前只有一种使用方法, 那就是直接把Jar包导入项目

未来我会搭建一个私有Maven仓库, 届时就可以使用Maven导入了

### 工具列表

1. [响应构建工具](#响应构建工具)

2. [SQL参数构建工具](#sql参数构建工具)

3. [安全工具](#安全工具)

#### 响应构建工具

**类名:** BulidResponse

**方法:**

> Success()

构建简单的成功响应

> Success(String Message)

构建带文本信息的成功响应

> Success(T Data)

构建带数据的成功响应

> Success(String Message,T Data)

构建带文本和数据的成功响应

> Error()

构建简单的失败响应

> Error(String Message)

构建带文本信息的失败响应

> Error(T Data)

构建带数据的失败响应

> Error(String Message,T Data)

构建带文本和数据的失败响应

**使用方法**

```
请注意!! 使用这个工具构建出来的是一个对象

推荐使用Gson将对象转为JSON数据

BulidResponse类内有两种响应构建, 分别是成功和失败

你可以将需要返回的信息和数据作为参数传入方法

若需要文本信息和数据一起返回则必须将文本信息放在前面传入
```

---

#### SQL参数构建工具

**类名:** BulidSqlParameter

**方法:**

> Bulid(Map<String, String> Parameters, List<String> Connect)

构建SQL参数

> AndConnect()

生成默认And连接符

> OrConnect()

生成默认Or连接符

**使用方法**

```
直接调用BulidSqlParameter类内的Bulid方法

此方法需要两个参数, 分别是参数集合和连接符集合

参数集合使用Map构建, Key为参数名称, Value为参数值

连接符集合可以使用默认构建方法, 也可以自己用List构建
```

---

#### 安全工具

**类名:** Security

**方法:**

> Base64Encode(String Message)

Base64编码

> Base64Decode(String Message)

Base64解码

> MD5Encode(String Message)

MD5加密

> SHAEncode(String Message)

SHA加密

> KeyGenerator(String Type, int Long)

密钥生成器

> SymmetricEncode(String Type, String Message, String Key)

对称算法加密

> SymmetricDecode(String Type, String Message, String Key)

对称算法解密

**使用方法**

```
此工具无法保障百分百安全, 建议多种加密算法混合使用

Base64和MD5编码我就不细讲了, 只需要传入需要编码的数据即可

本工具将加密算法分为对称加密算法和非对称加密算法, 目前只有对称, 后续会一一补上

使用对称加密算法请先使用KeyGenerator生成密钥再加密, 密钥请妥善存储

最后列一下各个算法的性能排行(快到慢): SHA > Base64 > AES > MD5 > DES

上述排行可自行使用Security类中的main方法测试
```

---

### 授权许可

请注意, 由于本项目内含Apache基金会下的Commons项目, 本项目打包后META-INF目录下的许可文件为Commons项目附带与本项目无关

[中文授权许可](https://github.com/skai-zhang/DeveloperKit/raw/master/license/Chinese.txt)

[English License](https://github.com/skai-zhang/DeveloperKit/raw/master/license/English.txt)