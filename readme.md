#Readme

---

##1.快速访问

##2.配置问题
resource>application.yaml
### 2.1 数据库(服务器上需要有建好表)
version:5.7

（8.0需要修改serverTimezone=Asia/Shanghai)

database: question

username=root password=123456

建表的sql在——下
### 2.2 server
port: 8080

##3.前端常见测试错误总结
    
500：服务器内部问题，原因可能是：
    
    1.可能后端没写好(mapping文件有错)

    2.插入值不符合要求（如：id重复了）

400：url没写对，找不对对应的方法

405：get或者post等一些方法没有被后端允许（不过目前所有方法都被允许了）

请求不了：没带端口号或者端口号（默认端口号8080）