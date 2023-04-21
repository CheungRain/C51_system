# 基于C51单片机的智能温湿度检测系统设计

#### 技术栈
java springboot,mybatis-plus,thymeleaf + mysql + javascript jQuery,ajax + html + css 

#### 软件架构
整体使用springboot框架

1. 项目启动类:Test1Application.java
2. 实体层(model)entity:存放了页面需要传递数据对应字段的实体类，它和数据库中对应表字段的属性值保持一致，实现该类的set/get方法。
3. 数据访问层(持久层)mapper:主要是做数据持久层的工作，同时提供增删改查(CRUD)工作，直接操作数据库。
4. 数据服务层service:主要负责业务模块的逻辑应用设计，同时有一些是关于数据库处理的操作，但是不是直接和底层数据库关联，而是首先设计接口，再设计其实现的类，在接口实现方法中需要导入Mapper层，接着再Spring的配置文件中配置其实现的关联。这样就可以在应用中调用Service接口来进行业务处理。
5. 前端控制器controller:负责具体的业务模块流程的控制，响应用户的请求，调用Service层的接口来控制业务流程，决定使用何种视图并准备响应数据。并把接收到的参数传给Mapper，调用Mapper的方法接口。
6. 工具类util
7. 配置信息类config
8. 拦截器interceptor:实现登录拦截，如果session中没有用户信息，则重定向登录页面

底层结构图
<img height="600" src="src\main\resources\static\img\2.png" width="650"/>



#### 系统使用说明

1.  第一次使用要先进行用户登录，如果服务器没有在session中检测到用户信息，会使用springboot拦截器，对用户请求进行拦截，重定位到登录页面
2.  登录成功后会跳转到温湿度显示页面，服务器会通过http协议和C51单片机中的esp8266wifi模块建立连接，将数据发给页面，页面可以实时显示C51单片机传过来的温湿度信息
3.  在温湿度显示页面可以设置温湿度相应的阈值，由服务器将阈值信息发送给C51单片机

#### GIT使用教程

1.  初始化:git init 初次创建
2.  git status
3.  git add . 向本地仓库添加文件
4.  git commit -m "提交内容介绍"
5.  git remote add origin 远程仓库地址
6.  git pull --rebase origin master 从远程仓库拉取
7.  git push -u origin master/main 向远程仓库推送
