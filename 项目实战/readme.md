上传项目实战一：
javaweb 书城项目（尚硅谷）

分析如下：

<!--
    JavaEE 

     当前工程的路径代表web的路径，http://localhost:8080/04_book/，已经表示到了web文件夹
    
    |-- 三层架构
        表示层（web层）、业务逻辑层（service层）、数据访问层（dao层）。
        分层的目的是为了解耦。解耦就是为了降低代码的耦合度。方便后期的维护和升级。

        |-- web层：
            与客户端交互，包括获取用户请求，传递数据，封装数据，展示数据。
        |-- service层：
            复杂的业务处理，包括各种实际的逻辑运算。
        |-- dao层：
            与数据库进行交互，与数据库相关的代码在此处实现。

    |-- 项目文件结构
        |-- src：存放java源代码
            web 层          com.myproject.web/servlet/controller
            service 层      com.myproject.service        Service接口包
                            com.myproject.service.impl   Service接口实现类
            dao 持久层       com.myproject.dao            Dao接口包
                            com.myproject.dao.impl       Dao接口实现类
            实体 bean对象    com.myproject.pojo/entity/domain/bean JavaBean 类
            测试包           com.myproject.test/junit
            工具类           com.myproject.utils

        |-- web：存放静态资源
            html
            js
            jsp
            css
            commom:公共静态文件资源（图片）

        |-- web-inf:对外界隐藏的资源文件夹
            lib项目依赖包
            web.xml项目配置文件



    |-- 项目阶段一————实现用户登录、注册功能
        1. 创建存储的项目数据库book和对应的用户表t_user
        2. 创建于数据库对应的 user类 即javabase类

        3. 创建数据库连接池
            lib导包加入模块中
            src下复制jdbc.properties，配置数据库连接
            新建jdbcUtils，提供数据库连接和关闭的方法。
            在test中创建数据库连接工具包是否成功的测试代码 JdbcUtileTest

        4. 编写DAO，实现对数据库的增删查改操作
            ① 抽象基类BaseDAO,里面包含数据库的增山查改操作
                导入工具包:commons-dbutils-1.3.jar

            ② UserDAO接口，里面设计查询用户名、用户名和密码、保存用户数据的几个空壳方法。

            ③ UserDAOImp类，继承 BaseDAO类，实现 UserDAO接口，实现登录过程中对密码的校验和注册时保存用户信息的操作。

            ④ 编写 UserDAOImp 类的测试代码 UserDAOImpTest
            IEDA 自动生成测试类代码：ctrl+shift+t

        5. 编写 service，实现业务：登录、注册
            ① 编写userService 空壳接口，表示要实现的业务逻辑
            ② 编写实现类 userServiceImp
                里面直接调用DAO中实现的根据用户名查询、根据用户名、密码查询的数据库操作
            ③ 编写测试类 userServiceTest

        6.编写 web层
           ① 修改 regist.html 和 regist_success.html 页面
            |--设置base路径，将相对路径固定到当前工程路径，注意，要与tomcat服务器中的名称一致：http://localhost:8080/04_book_war_exploded/

            |-- 修改注册表单的提交地址（要加上项目名称）和请求方式
                action = "/04_book_war_exploded/registerServlet",注意这里的项目名称要与 tomcat 中的 application context一致

            ② 编写 编写 RegistServlet 程序
                分析实现的逻辑
                1、获取请求的参数，username、passward
                2、检查验证码是否正确
                    正确——>检查用户名是否可用
                        |-- 可用
                            调用 service存到数据库
                            跳到注册成功页面 regist_ success.htm
                        |-- 不可用
                            跳回注册页面
                    不正确
                        跳回注册页
            ③ 编辑 web.xml文件，设置servlet及其maping



    项目阶段二————优化阶段
        1. 将所有页面改为jsp 动态化
            去除页面缓存：ctr + shift + delete 删除浏览器缓存
            IDEA查找替换：
                本页面里面按住 ctr + R
                按项目、目录，按住 ctr + shift + R

        2. 抽取多个页面中的重复部分，换成jsp的静态包含方便后期维护
           |-- 将公共部分抽取出来，各自单独创建一个jsp文件，之间复制过来
           |-- 将原来页面中的内容替换成静态包含：
               ① 显示登录成功的信息
               ② 页面页脚显示的版权信息
               ③ 设置base路径、引入css样式的文件
               ④ 图书管理公共部分
            <%@include file="/pages/common/login_succecc_common.jsp" %>
            
        3. base标签中写死了localhost地址，如果外部电脑则访问不了，所以改为动态获取访问地址
        <%
            String basePath = request.getScheme()
                    + "://"
                    + request.getServerName()
                    + ":"
                    + request.getServerPort()
                    + request.getContextPath()
                    + "/";
        %>
        <base href="<%=basePath%>">

        4. 优化代码结构

        |-- 注册登录信息错误，表单回显
            利用 request 的setAttribute() 来设置并传递属性。
            ① 在Servlet程序中设置属性：
                req.setAttribute("msg","用户名或密码错误！");
            ② 在表单中显示属性出来：
                <%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>
            ③ 在输入框中多加一个value属性回显相应的值。
                <input name="username" value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>"/>

        |-- 基于思想：一个模块，使用一个 Servlet 程序。
            将login和regist 两个servlet进行合并
            ① 两个都是post请求，要区分，给提交的表单添加 hidden 的input提交项:<input type="hidden" name="action" value="login"/>

            ② 获取：String action = req.getParameter("action");
                  if("login".equals(action)){...}
        
        |-- 利用反射实现方法的调用，避免繁杂的if、else 判断
           Method method = this.getClass().getDeclaredMethod(action, HttpServletRequest.class, HttpServletResponse.class);
           method.invoke(this,req,resp);

        |-- 每一个servlet模块都会有以下调用的过程，所以进一步抽象出BaseServlet，继承HttpServlet，其他直接继承BaseServlet
            1、获取 action参数值
            2、通过反射获取 action对应的业务方法
            3、通过反射调用业务方法

    3.项目第三阶段————进一步精简代码，用EL表达式替换变量错误信息回显
       |--<%=request.getAttribute("msg")==null?"请输入用户名和密码":request.getAttribute("msg")%>
       替换为：
		${empty requestScope.msg?"请输入用户名和密码":requestScope.msg}
       |-- value="<%=request.getAttribute("username")==null?"":request.getAttribute("username")%>
       替换为：value="${requestScope.username}"

    4.项目第四阶段————实现图书功能，同登录注册功能实现
       |-- 编写数据表t_book
       |-- 编写 book 对应的javaBean类
       |-- 编写 Book 的数据库操作，BookDAO接口、BookDAOImp实现类      
            BookDAOImpTest测试类，实现对数据库的操作，增删改查(数据库端)
       |-- 编写 bookService 接口，bookServiceImp实现类，bookServiceImpTest
            测试类，调用BookDAO实现业务：图书管理，增删改查(用户角度)
       

       如果访问jsp无法直接得到数据，那么可以让程序先访问 Servlet程序，再转发request来实现数据的传送

       |-- 编写 Web 层，主页点击后台管理，进入manager.jsp,点击图书管理，跳转
            到 book_manager.jsp 展示所有的数据，但是本身页面并没有数据，所以需要servlet转发request实现数据库数据的转发

        
        编写 BookServlet 继承 BaseServlet，里面实现增删改查的功能

          |-- 实现列表的功能
            1. <a href="manager/bookServlet?action=list">图书管理</a>，表示这个超链接的请求由 bookServlet处理并且调用的是 bookServlet 中的list方法
            2.bookServlet程序中新建list方法，通过request实现数据库数据的传送显示
            
          |-- 实现新增图书的功能
            1.在图书管理界面点击新增，跳转到book_edit.jsp页面
            2.输入书籍的表单信息，点击提交，到 bookServlet 的 add方法中
                <form action="manager/bookServlet" method="get">
                    <input type="hidden" name="action" var="add">
            3.add方法中
            
            插播：
            java bean拷贝操作工具类 Beanuitls，实现将将Map中的数据注入到Bean对象中
            编写一个 WebUtil 类实现将Book对象封装成javaBean对象

              ① 获取request域中的对象，封装成一个Book的javaBean对象
                    注意：这里需要确保input的name属性与Book的javaBean属性一致，不然在注入的时候会报错，NoSuchMethod
              ② 调用service的add方法将新的Book增加到数据库
              ③ 重定向跳转到book_manager.jsp页面，显示列表信息

              注意：
                重定向针多次请求
                消息转发针对一次请求

         |-- 实现删除图书的功能
           1.点击删除时，链接到servlet的delete功能，并且要传递删除的id
           <a href="manager/bookServlet?action=delete&id=${book.id}">删除
           2.获取id值，转换成int型，调用service的delete方法
           3.重定向刷新列表
           4.增加一个确认提示框
            <script type="text/javascript">
                    $(function(){
                        $("a.deleteclass").click(function(){
                            return confirm("你确定要删除"+$(this).parent().parent().find("td:first").text()+"吗？");
                        });
                    });
            </script>

        |-- 修改图书的功能
          1.book_manager.jsp点击修改之后，需要先调用servlet的query方法获取需修改Book对象。 这里面靠id传递id的属性值，实现按id查找Book
        <a href="manager/bookServlet?action=query&id=${book.id}">修改</a>
       

        2.将查询到的Book记录在request中，消息转发给book_edit.jsp
        Book book = bookService.queryBook(id);
        req.setAttribute("bookinfo",book);
        req.getRequestDispatcher("/pages/manager/book_edit.jsp").forward(req,resp);

          3.book_edit.jsp点击提交按钮，调用servlet方法的update方法,用隐性表单传递参数id
          <form action="manager/bookServlet" method="get">
          <input type="hidden" name="id" value="${requestScope.bookinfo.id}">
                
          3.update调用list，刷新页面

          4.在用一个页面，book_edit中的同一个隐藏input要传递add和update两个参数，用于区分。
           <input type="hidden" name="action" value=${empty param.id?"add":"update"}>

    |-- 分页显示的功能：实际中不会将所有数据一起显示出来，加载费时，效率也低，所以需要考虑分页显示
        分页内容：
        pageNo 需要知道当前页码
        pageTotal 需要计算总页码
        pageTotalCount 需要知道数据库中图书总记录数
        pageSize 需要设置每页显示数量
        Items  需要获取当前页图书数据

        javaBean:Page类

        DAO部分：BookDAO里面新增方法，新增测试
        查询总记录数
            public Integer queryTotalCount() {
                String sql = "SELECT COUNT(*) FROM t_book;";
                Number number = (Number) querySingleValue(sql);
                return number.intValue();
            }
        查询当前页面的图书数据
            public List<Book> queryPageItems(Integer begin,Integer pageSize) {
                String sql = "SELECT id,bookname,author,bookprice,sale,save,img_path FROM t_book LIMIT ?,?;";
                List<Book> books = queryList(Book.class, sql, begin,pageSize);
                return books;
            }

        2)分页模型 Page 的抽取（当前页数，总页数，总记录数，当前页数据，每页记录数）

            Service部分，新增page()方法
            方法体内调用DAO，得到数据库数据，将总记录数、总页码数、当前页面数据打包成page 对象
            这里稍微有点难理解，因为之前的Book都是直接调用DAO，就实现增删查改的操作。
            
            Servlet部分，新增page部分，获取用户交互页面的信息，调用service实现功能
            获取当前页码、页面显示数量pagesize
            传递显示数据

        4)首页、上一页、下一页、末页实现
            通过超链接，跳转到servlet，并且传递pageNo来实现
            <c:if test="${requestScope.page.pageNo>1}">
				<a href="manager/bookServlet?action=page&pageNo=1">首页</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo-1}">上一页</a>
            </c:if>
            
            <c:if test="${requestScope.page.pageNo<requestScope.page.pageTotal}">
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageNo+1}">下一页</a>
				<a href="manager/bookServlet?action=page&pageNo=${requestScope.page.pageTotal}">末页</a>
			</c:if>

        5)分页模块中跳转到指定页数功能实现
            通过绑定单击事件，响应跳转servlet调用page方法并且传递pageNo实现
            $("#inputbtn").click(function(){
				var pageNumber = $("#pn_input").val();
				location.href ="${pageScope.basePath}manager/bookServlet?action=page&pageNo="+pageNumber;
			});

        6)分页模块中，页码 1,2,【3】,4,5 的显示，要显示 5 个页码，并且页码可以点击跳转
        
           如果总页码小于等于 5 的情况，页码的范围是：1-总页码
                <c:when test="${requestScope.page.pageTotal<=5}">
					<%--循环输出这些页码--%>
					<c:forEach begin="1" end="${requestScope.page.pageTotal}" var="i">
						<%--如果是当前页面，则显示【当前页码】--%>
						<c:if test="${i == requestScope.page.pageNo}">
							【${i}】
						</c:if>
						<%--如果不是当前页码则直接显示数字，并加上超链接实现可以跳转的功能--%>
						<c:if test="${i != requestScope.page.pageNo}">
							<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
						</c:if>
					</c:forEach>

				</c:when>

           如果总页码大于5，那么就需要分情况讨论
           |-- 开始前3个，显示1-5
           |-- 最后3个页码，显示(Total-4)-Total
           |-- 之外，始终保持当前页码在中间，，显示（当前页码-2）-（当前页码+2）
                <c:when test="${requestScope.page.pageTotal>5}">
					<c:choose>
						<%--页码在前三，显示1-5--%>
						<c:when test="${requestScope.page.pageNo<=3}">
							<c:forEach begin="1" end="5" var="i">
								<%--如果是当前页面，则显示【当前页码】--%>
								<c:if test="${i == requestScope.page.pageNo}">
									【${i}】
								</c:if>
								<%--如果不是当前页码则直接显示数字，并加上超链接实现可以跳转的功能--%>
								<c:if test="${i != requestScope.page.pageNo}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:when>

						<%--页码在后三，显示(Total-4)-Total--%>
						<c:when test="${requestScope.page.pageNo > requestScope.page.pageTotal-3}">
							<c:forEach begin="${requestScope.page.pageTotal-4}" end="${requestScope.page.pageTotal}" var="i">
								<%--如果是当前页面，则显示【当前页码】--%>
								<c:if test="${i == requestScope.page.pageNo}">
									【${i}】
								</c:if>
								<%--如果不是当前页码则直接显示数字，并加上超链接实现可以跳转的功能--%>
								<c:if test="${i != requestScope.page.pageNo}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>

						</c:when>

						<%--其余其他情况，显示（当前页码-2）-（当前页码+2）--%>
						<c:otherwise>
							<c:forEach begin="${requestScope.page.pageNo-2}" end="${requestScope.page.pageNo+2}" var="i">
								<%--如果是当前页面，则显示【当前页码】--%>
								<c:if test="${i == requestScope.page.pageNo}">
									【${i}】
								</c:if>
								<%--如果不是当前页码则直接显示数字，并加上超链接实现可以跳转的功能--%>
								<c:if test="${i != requestScope.page.pageNo}">
									<a href="manager/bookServlet?action=page&pageNo=${i}">${i}</a>
								</c:if>
							</c:forEach>
						</c:otherwise>
					</c:choose>

				</c:when>


        7) 修改分页后，增加，删除，修改图书信息的回显页面
        要获取页面当前的一些信息，我们需要通过设置页面的属性，比如input，实现将这个值传个服务器
        跳转的时候直接用requestScope.name获取这个属性值

            1、在 book_edit.jsp 页面中使用隐藏域记录下 pageNo 参数，才能实现传递，可以显示当前页面，不然会跑到第一页去
            <input type="hidden" name="pageNo" value="${param.pageNo}">

            2、在修改的请求地址上追加当前页码参数，传递给bookServlet的page方法，设置相应的参数
            <td><a href="manager/bookServlet?action=query&id=${book.id}&pageNo=${requestScope.page.pageNo}">修改</a></td>

    |-- index.jsp首页显示数据库列表信息,增设一个 ClientBookServlet程序，获取数据再页面转发过去。
       (1)web目录下的index.jsp只需要负责把请求转发给 ClientBookServlet，实现page方法就ok
            <jsp:forward page="/client/clientBookServlet"></jsp:forward>
       (2)ClientBookServlet再把数据打包转发给client下的index.jsp，给人一种直接访问的是首页
            req.getRequestDispatcher(("/pages/client/index.jsp")).forward(req,resp);
       (3)首页显示的分页条与后台管理的也一致，抽取出来。成，pagenav_common.jsp

            此时跳转的servlet服务不一样，所以抽取出 url，作为 page 的一分部属性
            每一个servlet的程序中的page方法，另外设置url地址，
            page.setUrl("client/clientBookServlet?action=page");

            pagenav_common.jsp中的地址改为
            <a href="${requestScope.page.url}&pageNo=1">首页</a>


    |-- 实现价格筛选
       
       1.servlet
           在clientBookServlet中对传入的价格区间的数据进行分页显示——>pageByPrice().
           里面调用 service的——>pageByPrice(pageNo,pageSize,min,max)来实现

       2.service
           在page的基础之上，增加pageByPrice(pageNo,pageSize,min,max)
                需要计算价格区间内的数据总数——>DAO增加 queryPriceCount(min,max)
                需要返回价格区间内的数据——>DAO增加 queryPriceItems(min,max)
           
       3.DAO
           在 queryTotalCount 的基础之上增加 queryPriceCount方法，计算在价格区间的个数
           在 queryPageItems 的基础之上增加 queryPriceItems() 方法，返回区间之间的BOOK数据

       4.其他补充：
            |-- 筛选价格的回显
                <input id="min" type="text" name="min" value="${param.min}">
                
地址传递时，有些参数不符合要求，考虑可以通过attribute传递
            |-- 筛选结果分页显示中不带min，max参数，导致跳转的时候没有价格筛选
                思路：用StringBuffer追加上去
                if(req.getParameter("min")!=null){
                    stringBuffer.append("&min=").append(req.getParameter("min"));
                }

            



补充：
一、再次理解四大作用域：

所谓"作用域"就是"信息共享的范围"，也就是说一个信息能够在多大的范围内有效。
Web交互的最基本单位为HTTP请求。每个用户从进入网站到离开网站这段过程称为一个HTTP会话，
    1.application
        此范围的对象被绑定到 ServletContext中。
        在 Web 应用程序运行期间，所有的页面都可以访问这个范围内的对象。

    2.session
    HTTP会话开始到结束这段时间
    此范围的对象被绑定到 HttpSession 对象中。

    3.requset
    HTTP请求开始到结束这段时间。
    一JSP 网页发出请求到另一个JSP 网页之间，可能需要多个Servlet合作
    此范围的对象被绑定到 ServletRequest 对象中。

    4.page
    当前页面从打开到关闭这段时间，它只能在同一个页面中有效。
    此范围的对象被绑定到 PageContext 对象中。

二、parameter 和 attribute 的区别

1. 来源不同：
   参数（parameter）是从客户端（浏览器）中由用户通过get、post方法提供的
   属性（attribute）是服务器端的组件（JSP或者Servlet）利用requst.setAttribute（）设置的
2. 操作不同：
   参数（parameter）的值只能读取不能修改，读取可以使用request.getParameter()读取； 
   属性（attribute）的值既可以读取亦可以修改
3.数据类型不同：
   参数（parameter）不管前台传来的值语义是什么，在服务器获取时都以String类型看待，并且客户端的参数值只能是简单类型的值，不能是复杂类型，比如一个对象。 
   属性（attribute）的值可以是任意一个Object类型。 

4.取数据时
${param.name} 等价于 request.getParamter("name")，用于服务器从页面或者客户端获取的内容。
比如浏览器网址上带的参数，可以直接用param.name进行获取回显到页面中
${requestScope.name} 等价于 request.getAttribute("name") 等价于等价于 ${name}，用于服务器传递结果到页面，在页面中取出服务器保存的值。


|-- 表单重复提交与验证码
    1. 表单重复提交情况：
        用户按下功能键 F5————请求重定向解决
        用户多点了几次提交操作————验证码
        用户回退浏览器。重新提交————验证码

    2. 验证码：谷歌 kaptcha 图片验证码

    kaptcha 是一个验证码生成工具。可配置的。kaptcha工作的原理是调用 com.google.code.kaptcha.servlet.KaptchaServlet，生成一个图片。同时将生成的验证码字符串放到 HttpSession中。

        1、导入谷歌验证码的 jar 包
            kaptcha-2.3.2.jar
        2、在 web.xml 中去配置用于生成验证码的 Servlet 程序
        <servlet-class>com.google.code.kaptcha.servlet.KaptchaServlet</servlet-class>
        3、在表单中使用 img 标签去显示验证码图片并使用它
        <img alt="" src="/kaptchaServlet.jpg">
        4、在服务器获取谷歌生成的验证码和客户端发送过来的验证码比较使用。
        

    3.验证码解决表单重复
    KaptchaServlet
        1、当用户第一次访问表单的时候，kaptcha给表单生成一个随机的验证码字符串
        并把验证码保存到 Session域中的 KAPTCHA_SESSION_KEY 
        2、要把验证码生成为验证码图片显示在表中

    Registservlet
        1、获取Session中验证码，并删除 Session中的验证码
        String token = (String) req.getSession().getAttribute(KAPTCHA_SESSION_KEY);
        req.getSession().removeAttribute(KAPTCHA_SESSION_KEY);

        2、获取表草中的表单项信息，比较一致则下一步，不一致则阻止
         if (codeTrue!=null && codeTrue.equalsIgnoreCase(code)) {}

    4.实现单击图片更新，绑定单击事件
        $(".imgcode").click(function(){
                //后端增加上时间避免浏览器的缓存机制
                this.src="${pageContext.request.contextPath}/kaptchaServlet.jpg?d=" + new Date();
        });

            
六、项目第六阶段：完善购物车的功能
|-- 抽象出javaBean
    1.抽象出购物车Cart的模型
        商品项 items
        总数量 totalCount
        总金额 totalPrice

    2.抽象出商品项CartItems的模型
        商品 id
        商品名称 name
        商品单价 price
        商品数量 count
        商品总价 totalPrice

    3.使用Session来实现数据的存储，所以此时需要Cart提供以下方法
        增加商品 addItem(CartItem item)
        删除商品 deleteItem(Integer id)
        清空商品 clear()
        修改商品数量 updateCount(id,count)

    4.生成测试文件 CartTest

|-- 与表单交互，实现按钮加入购物车的功能
    1. 按钮绑定单击响应，跳转到servlet
        $(function(){
			$("button.addToCart").click(function(){
				var id = $(this).attr("value");
				location.href = "http://localhost:8080/04_book_war_exploded/cartServlet?action=addItem&id=" + id;
			});
		});

    2. CartServlet 里面调用addItem方法。
      通过id获取Book
      int id = WebUtils.parseInt(req.getParameter("id"), 0);
      Book book = bookservice.queryBook(id);

      但是需要实现将 Book 转化成 cartItem
      CartItem item = new CartItem(book.getId(),book.getBookname(),book.getBookprice(),1,book.getBookprice());
        //如果从session中发现还没有创建cart，就新建cart
      Cart cart = (Cart) req.getSession().getAttribute("cart");

      里面的Cart 也不能每次都要新建，通过session获取是否已经创建了Cart
      if(cart==null){
            cart = new Cart();
            req.getSession().setAttribute("cart",cart);
       }
      cart.addItem(item);

      跳转回原页面
      resp.sendRedirect(req.getHeader("Referer"));

    3.靠 session 来传递消息，sessionScope来获取
        <c:if test="${not empty sessionScope.cart.items}">
            <c:forEach items="${sessionScope.cart.items}" var="entry">
                <tr>
                    <td>${entry.value.name}</td>
                    <td>${entry.value.count}</td>
                    <td>${entry.value.price}</td>
                    <td>${entry.value.totalPrice}</td>
                    <td><a href="#">删除</a></td>
                </tr>
            </c:forEach>
        </c:if>

    |-- 购物车功能实现
        1.删除商品，cartServt中增加一个 deleteItem的方法调用Cart.deleteItem
        <td><a class="deleteBook" href="cartServlet?action=deleteItem&id=${entry.value.id}">删除</a></td>

补充：一般这种删除操作都需要增加一个删除确认的操作
        $(function () {
			$(".deleteBook").click(function(){
				return confirm("你确定要删除【" + $(this).parent().parent().find("td:first").text() +"】吗?")
			});
		});
         
        2.清空购物车，cartServt中增加一个 clear的方法调用Cart.clear()

        3.修改商品数量
            增加输入框，并为其绑定 change 事件，传递当前输入框的count与id值
            cartServt中增加一个 updateItem的方法调用Cart.updateItem


七、编写订单模块的功能
    1.分析
    需要订单类Order
        orderId 订单号（唯一）
        creatTime 下单时间
        price 金额
        status 发货状态
        userId 用户编号   
    
    订单信息类 OrderItem
        id 主键编号
        name 商品名称
        count 数量
        price 单价
        totalPrice 总价
        orderId 订单号


    2.创建数据表
    t_order   t_order_item

    3.创建数据库操作 DAO ——> DAOImp

      创建订单 OrderDAO，public interface OrderDAO————>OrderDAOImp
        保存订单  saveOrder(Order order)
        查询全部订单 queryOrders()
        修改订单状态 changeStatus(String OrderId,Integer status)
        查询用户订单 queryOrdersByUserId(Integer userId)

      创建订单项public interface OrderItemDAO————>OrderItemDAOImp
        保存订单项 saveOrderItem(OrderItem orderItem)
        显示详细的订单信息 queryByOrderItemsByUserId(Integer userId)

    4.Service ——> ServiceImp
    创建 OrderService，调用DAO，传入所需的sql参数
    生成订单 creatOrder(Cart cart,Integer userId)
        1.创建订单高、订单项
        2.保存订单项
        3.遍历购物车中的商品项，转化成OrderItem，添加到订单项中
        4.清空购物车
        5.更新库存和销量

    查询所有订单 showAllOrders();
    发货 sendOrder(String orderId)
    查看订单商品详情 showOrderDetail(String orderId)
    签收 checkOrder(String orderId)
        

    5.Web层:OrderServlet
    
        |-- creatorder: 我的购物车结算，生成订单
            1.获取cart对象
            2.获取创建的订单号
            3.如果未登陆，跳转到登陆页面
            4.如果登陆，跳转到结算页面

        |-- queryOrdersByUserId,显示我的所有订单
           1.获取用户Id
           2.调用orderService.showMyOrders(userId)，得到订单列表信息
           3.存到session域中
           4.页面转发到 order.jsp，foreach显示信息
        
        |-- showOrderDetail：订单号查询详情，列出商品项
            1.获取订单号
            2.调用showOrderDetail，返回 List<OrderItem>，存入session
            3.页面转发order_detail.jsp,页面foreach循环显示

        |-- 管理员
        showAllOrders,点击订单管理，显示所有订单 
            1.跳转，调用servlet中的showAllOrders方法
            2.将数据存入session域中，页面转发到order_manager.jsp页面中

        查看详情
            传递订单号，跳转到order_detail.jsp页面

        changeStatus点击发货，修改发货状态，重定向回原界面 order_manager.jsp
            调用changeSatus方法

            问题：订单的有效期是这次登陆，下一次获取订单号就是null

八、用Filter 实现权限检测。
    对于后台管理，必须登录之后才可以访问。
    1.重写doFilter
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            HttpServletRequest httpServletRequest = (HttpServletRequest) servletRequest;
            Object user = httpServletRequest.getSession().getAttribute("loguser");
            if(user==null){
                //用户未登录，跳转到登录界面
                servletRequest.getRequestDispatcher("/pages/user/login.jsp").forward(servletRequest,servletResponse);
            }else{
                //用户已登录，放行
                filterChain.doFilter(servletRequest,servletResponse);
            }
        }
        2.配置xml文件
            1.拦截跳转到manager页面的请求
            2.拦截通过servlet跳转到页面的请求
            <url-pattern>/pages/manager/*</url-pattern>
            <url-pattern>/manager/bookServlet</url-pattern>


九、Filter加上ThreadLocal，结合jdbc的事务，实现数据的操作一致性（线程安全）
    |-- 给jdbcUtil 操作类
        创建数据库连接时：
            1. 将连接存储到ThreadLocal中，使后续调用方法时直接通过ThreadLocal 得到一致的Connect
            private static ThreadLocal<Connection> conn = new ThreadLocal<>();
            2. 取消自动提交

            public static Connection getConnect(){
                Connection con = conn.get();
                if(con==null){
                    try {
                        con = dataSource.getConnection();
                        conn.set(con);
                        con.setAutoCommit(false); // 设置为手动管理事务
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
            }
            return con;
        }

        新增提交事务、回滚事务的操作，代码一致
        public static void commitAndClose(){
            Connection connection = conn.get();
            if(connection!=null){
                try {
                    //提交事务
                    connection.commit();
                } catch (SQLException e) {
                    e.printStackTrace();
                }finally {
                    try {
                        //关闭资源
                        connection.close();
                    } catch (SQLException e) {
                        e.printStackTrace();
                    }
                }
            }
            conn.remove();
        }

    |-- 所有的异常，必须上抛，由 Filter 来捕获，实现事务的回滚
        1.修改BaseDAO中的抛异常，去除finally中的关闭操作
            catch (SQLException e) {
                e.printStackTrace();
                throw new RuntimeException(e);
            }

        2.修改BaseServlet中的抛异常

    |-- 使用 Filter 过滤器统一给所有的 Service 方法都加上 try-catch，实现提交回滚事务，并配置
        @Override
        public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
            try {
                filterChain.doFilter(servletRequest,servletResponse);
                jdbcUtils.commitAndClose();
            } catch (IOException e) {
                e.printStackTrace();
                jdbcUtils.rollAndClose();
            } 
        }

十、错误的友情提示，将所有异常都统一交给 Tomcat，让 Tomcat 展示友好的错误信息页面
    直接配置xml的错误信息
        <error-page>
            错误的代码类型
            <error-code>404</error-code>
            <location>/pages/error/error404.jsp</location>
        </error-page>
