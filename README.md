> **Said ahead**
>  **The predecessor of this AnoSing framework is Simplified and Upgraded Spring AS I wrote three months ago.**<br/>
>  **Because a lot of people talk to me about the problems in the previous version of the code, so I absorbed your opinions and developed Spring AnoSing, which is now in front of you on the basis of AS.I promise you, this edition will never disappoint you.**
> **First of all, thank you for choosing the Spring AnoSing framework as your development tool.**<br/>
> **Then, I think you're full of curiosity about this little fellow who was born not long ago.** <br/>
> **Okay,Get to the point,What is Spring AnoSing?**
  
### 说在前面
   这套AnoSing框架是我三个月开发的Spring AS简化及升级版。<br/>
   由于很多人私聊我说上一版本的代码有诸多问题，所以我吸收了大家的意见在AS的基础上开发出了现在出现在您眼前的——Spring AnoSing，我保证，这一版绝对不会让您失望的 :) <br/>
   首先，非常感谢您选择了Spring AnoSing框架作为您的开发工具。<br/>
   接着，我想您对Spring AnoSing这个刚诞生没多久的小家伙充满了好奇。<br/>
   好的，接下来就让我们一点点的揭开Spring AnoSing的神秘面纱吧~

> **Introduce:**
>  1. **Spring AnoSing  Based on the Spring Boot Framework (Ver 1.5.10.RELEASE)**
>  2. **Extremely LightWeight in the Project**
>  3. **3.Agile development, more focused on core business logic**
>  4. **4.Front and back end separation:AnoSing + Vue**
>  5. **5.Have what you want，Give you what you want.**

### 初识Spring AnoSing
1. Spring AnoSing 是一款基于Spring Boot开发的轻量级集成框架。
2. 极·轻量级
3. 敏捷开发，上手简单，提升开发效率
4. 趋势：前后台分离:AnoSing + Vue
5. 有你想有，给你想要！

> **Environmental needs：**
> 1. **Please check your JDK Version Is it greater than 1.8+**
> 2. **Please ensure that your computer has installed NPM environment**
> 3. **Make sure that nginx and mysql is downloaded and installed on your computer**

### 环境基本需求
1. 请检查您的JDK版本是否为1.8+及其以上
2. 请确认您的电脑已经安装了npm运行环境
3. 请确保您电脑已经下载并安装了nginx及mysql

 
> **Start using:**
>  **If you have confirmed that your environment configuration is okay，Please click on the link below to download or git pull  the front and back end project packages for Spring AnoSing**

[·Down Load  : Spring AnoSing JavaWeb in GitLab](https://github.com/HaoNanYanToMe/SpringAnoSing)
[·Down Load  : Spring AnoSing Vue in GitLab](https://github.com/HaoNanYanToMe/SpringAnoSingWeb)

### 开始使用：
如果您已经确定您本地环境已经符合要求，您就可以点击下方连接将Spring AnoSing相配套的前后台源码包下载或通过git工具pull到您本地了。

> **Initialize and run Spring AnoSing:**
> 1. **Find AnoSingInit.sql files in the (SpringAnoSing) project root directory,And Execute in MySQL**
> 2. **Modify the src/resouce/application.yml configuration parameters（Such as the database connection, port, exit jump page connection, etc.）**
> 3. **Run the Java Project**
> 4. **Open the Vue(SpringAnoSingWeb) Project Folder**
> 5. **Using the cmd**
> 6. **Execute [ npm install ] Initialization the project**
> 7. **Execute [ npm install gojs --save ]**
> 8. **Execute [ npm install vue-echarts --save ]**
> 9.  **Open Vue(SpringAnoSingWeb) Projects with Editor(IDEA or HBuilder)**
> 10. **Open VueAdmin/src/Global.js Modify your configuration**
> 11. **Open VueAdmin/build/webpack.prod.config.js Serch and Modify  the publicPath in your service Address or Domain Name**
> 12. **In cmd : Execute [ npm run dev ] run the Project (For local testing)**
> 13. **In cmd : Execute [ npm run build ] run the Project (For official deployment,need using the nginx)**
>
>>**Matters needing attention：**
> 
> 1.**if you need to start the Test，you need to modify two files**
> 	 1. **In SpringAnoSing/src/main/java/com/prsim/springas/aop/AccessCheck Find and Annotate  the [ ~~*@Around("recordController()")*~~ ]**
>   2. **In SpringAnoSingWeb//src/http.js  Find and Modify the [ ~~const TYPE_ONLY = 0;~~  ]to[ const TYPE_ONLY = 1; ]**
>   
> 2.**if you need to start the Formal，you need to modify two files**
> 	 1. **In SpringAnoSing/src/main/java/com/prsim/springas/aop/AccessCheck Find and Annotate Cancel the [*@Around("recordController()")* ]**
>   2. **In SpringAnoSingWeb//src/http.js  Find and Modify the [ ~~const TYPE_ONLY = 1;~~  ]to[ const TYPE_ONLY = 0; ]**
 
### 初始化并运行您的Spring AnoSing项目
1. 在（SpringAnoSing）后台项目根目录下查找[**AnoSingInit.sql**]打开，并在mysql中执行初始化数据库。
2. 修改 **SpringAnoSing/src/resouce/application.yml**配置文件（如数据库连接，端口，退出跳转连接等）
3. 启动**SpringAnoSing**后台服务
4. 打开您刚下载或pull的（**SpringAnoSingWeb**）文件夹
5. 在地址栏键入命令**cmd**打开系统命令行工具
6. 运行[**npm install**]以初始化构建前端vue项目
7. 运行[**npm install gojs --save**]安装额外项目支持组件
8. 运行[**npm install vue-echarts --save**]安装额外项目支持组件
9. 在编译器中打开**SpringAnoSingWeb**项目
10. 打开**VueAdmin/src/Global.js**修改基本项目参数
11. 打开[**VueAdmin/build/webpack.prod.config.js**]检索[**publicPath**]将连接替换为您的IP或真实域名（建议使用真实域名）
12. 在命令行工具中键入[npm run dev]以运行测试环境
13. 在命令行工具中键入[npm run build]以打包正式环境（**需要nginx**）

### 注意事项
1. 如果您想要运行测试环境，建议您检查以下两个文件
	1. 在（**SpringAnoSing/src/main/java/com/prsim/springas/aop/AccessCheck**）文件中检索 [ **~~*@Around("recordController()")*~~** ]将其注释
	2. 在（**SpringAnoSingWeb//src/http.js**）文件中检索并将[ **~~const TYPE_ONLY = 0;~~** ]替换为 [ **const TYPE_ONLY = 1;** ]
2. 如果您想要运行正式并打包环境，建议您检查以下两个文件
	1. 在（**SpringAnoSing/src/main/java/com/prsim/springas/aop/AccessCheck**）文件中检索 [ **@Around("recordController()")** ]并去掉其注释
	2. 在（**SpringAnoSingWeb//src/http.js**）文件中检索并将[ **~~const TYPE_ONLY = 1;~~** ]替换为 [ **const TYPE_ONLY = 0;** ]

> **Mission accomplished**
> **Congratulations, you have successfully started and run the Spring AnoSing.**<br/>
> **Please open it in browser (npm run dev will automatically open :) ）: 127.0.0.1:8080 (default port) Start Spring AnoSing's experience officially~**<br/>
> **System default account :admin /1**<br/>
> **If you have any questions or functions you want, you are welcome to submit issue and let me know. I will reply to you in the first time.**<br/>
> **If you are interested in working together to improve Spring AnoSing, you are also welcome to submit your code in the branch. Thank you for your support:)**

### 结束   
恭喜您，至此为止，您已经成功的在您本地启动并运行了Spring AnoSing项目。<br/>
请您打开您的浏览器（执行npm run dev后页面会自动弹出 :) ）：127.0.0.1:8080（这是默认npm启动端口，您可以自行配置）就可以开始体验属于您的Spring AnoSing了<br/>
PS：系统默认用户： admin/1<br/>
如您有使用上的问题或想要的功能，欢迎您提交issue告知我，我会在第一时间回复您。<br/>
如您有兴趣一起来完善Spring AnoSing，也欢迎您在分支提交您的代码，感谢您的支持 ：）

> **Future version plan**
> 1. **Existing SqlEngine upgrades:Complex grouping query optimization**
> 2. **Add @prsimEngine annotations to optimize project structure and improve usability**
> 3. **Adding Redis cache springboard to support SqlEngine at the bottom level and support online dynamic configuration.**
> 4. **Added privilege groups to support single-user multi-role.**
> 5. **And more……**

### 未来版本更新计划
1. 升级现有的SQL引擎：未来SQL引擎将可以更好的支持分组语句了
2. 新增@prsimEngine注解以优化代码，去除重复性的配置，增加可读性及易用性
3. 新增Redis缓存跳板以支持sqlEngine的底层功能，并启用线上配置，更为直观且易用。
4. 新增用户权限组功能，以支持单用户多角色的需求。
5. 更多其他……
