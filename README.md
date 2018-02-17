# 堆栈开发者工具包

项目包名: cc.stacks.developer

开始时间: 2015年11月12日

### 使用方法

目前只有一种使用方法, 那就是直接把Jar包导入项目

未来我会搭建一个私有Maven仓库, 届时就可以使用Maven导入了

### 工具列表

1. [响应构建工具](#响应构建工具)

2. [安全工具](#安全工具)

#### 响应构建工具

**类名:** BulidResponseTools

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



#### 安全工具

**类名:** SecurityTools

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


