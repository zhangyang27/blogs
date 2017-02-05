#### 总结:PHP和MYSQL Web开发(第四版) 
从部门书柜借得此书， 利用课余时间读完了， 下面总结几个生疏之处。

*  参数引用的方式： 主要是区别按参数传递和按引用传递, 按参数传递时可认为是创建了一个副本， 按引用传递即是直接将同一个对象传递过去。
*  array_walk 与 array_walk_recursive ：像极了python的map
*  正则表达式匹配特殊字符时，最好使用单引号，双引号将带来不必要的复杂性。比如，匹配一个反斜杠，单引号中则需要两个反斜杠，双引号中则需要四个反斜杠。因为php会将双引号内的四个反斜杠翻译成两个，正则表达式再翻译成一个。
*  [单双引号的区别](http://php.net/manual/en/language.types.string.php) ：主要是双引号会做一次解释或者解析，比如\t转变为制表符。此外，在双引号中可以直接使用变量。
*  函数的可变参数 ：func_get_arg(),func_get_args()和func_num_args()比较有意思。可以让函数不声明参数列表，然后直接传给函数参数，再使用这个三个函数来获得参数。
*  递归比for循环费内存：可以使用 memory_get_usage 来随时查看内存。
*  HTML有一个Metatags标签，这个标签的内容将会搜索引擎收录。
*  可以从 $_SERVER 里获得一系列参数。例子如下：
```
PHP_SELF    /server_indices.php 
argv    - 
argc    - 
GATEWAY_INTERFACE    CGI/1.1 
SERVER_ADDR    127.0.0.1 
SERVER_NAME    localhost 
SERVER_SOFTWARE    Apache/2.2.22 (Win64) PHP/5.3.13 
SERVER_PROTOCOL    HTTP/1.1 
REQUEST_METHOD    GET 
REQUEST_TIME    1361542579 
REQUEST_TIME_FLOAT    - 
QUERY_STRING    
DOCUMENT_ROOT    E:/web/ 
HTTP_ACCEPT    text/html,application/xhtml+xml,application/xml;q=0.9,*/*;q=0.8 
HTTP_ACCEPT_CHARSET    ISO-8859-1,utf-8;q=0.7,*;q=0.3 
HTTP_ACCEPT_ENCODING    gzip,deflate,sdch 
HTTP_ACCEPT_LANGUAGE    fr-FR,fr;q=0.8,en-US;q=0.6,en;q=0.4 
HTTP_CONNECTION    keep-alive 
HTTP_HOST    localhost 
HTTP_REFERER    http://localhost/ 
HTTP_USER_AGENT    Mozilla/5.0 (Windows NT 6.1; WOW64) AppleWebKit/537.17 (KHTML, like Gecko) Chrome/24.0.1312.57 Safari/537.17 
HTTPS    - 
REMOTE_ADDR    127.0.0.1 
REMOTE_HOST    - 
REMOTE_PORT    65037 
REMOTE_USER    - 
REDIRECT_REMOTE_USER    - 
SCRIPT_FILENAME    E:/web/server_indices.php 
SERVER_ADMIN    myemail@personal.us 
SERVER_PORT    80 
SERVER_SIGNATURE    
PATH_TRANSLATED    - 
SCRIPT_NAME    /server_indices.php 
REQUEST_URI    /server_indices.php 
PHP_AUTH_DIGEST    - 
PHP_AUTH_USER    - 
PHP_AUTH_PW    - 
AUTH_TYPE    - 
PATH_INFO    - 
ORIG_PATH_INFO    - 
```

* MySQL的count函数：
	* count(*):　返回行数，无论是否为空（null）
	* count(列名):　返回非空的行数
	* count(distinct 列名): 不同列的行数、个数
*  如果用户输入的密码和机密数据将会需要保存在数据库中，请注意，如果不使用SSL(Secure Sockets Layer，加密套接字)，这些数据将以纯文本的方式从浏览器传递到数据库。
* 不要信任用户的输入，下面几个技巧可以防止屏蔽用户不安全的输入。
	* addslashes(string $str)可以过滤数据，在单引号、双引号、反斜杠、Null前面再加上反斜杠，避免不便和威胁。最近在项目中在php中写JS代码有许多单引号，应该就用这个函数解决。然而，对于插入数据库的函数应该使用专用的过滤函数，详见[PHP手册](http://php.net/manual/en/function.addslashes.php)。 另外用stripcslashes()可以还原。
	* 当用户的输入将会被system()或exec()执行时，使用escapeshellcmd()过滤掉不安全的输入。
	* htmlspecialchars() 将特殊字符转化为html实体。比如将：< 转化为&.lt;，而&.lt;在html语言中就代表<，而实际编写html代码时，<是一个标签的开始符号。这样就可以将任何标记转为无害的字符了。
	* strip_tags()去掉HTML和PHP的标记符号。比如，如果当用户输入有PHP代码，那么执行该函数即可阻止PHP代码的执行。但可能会使代码显示在屏幕上。
*  PHP的 cURL 函数库支持多种网络行为以及协议：http, https, ftp, gopher, telnet, dict, file, ldap。行为包括：HTTPS验证，HTTP POST、HTTP PUT、FTP上传、HTTP形式的上传、代理、cookie和用户密码验证。
*  exit() 函数执行后脚本会停止，但停止会调用一系列函数。
	* 可以通过void register_shutdown_function ( callable $callback [, mixed 2.  $parameter [, mixed $... ]] )来注册关闭前执行的函数。	 
	* 如果exit()的参数是字符串，字符串将会显示在浏览器上；
	* 如果是函数，那么将只执行这一个函数。 
	* die()是exit()函数的重名。 	
```php
	$filename = '/path/to/data-file';
	$file = fopen($filename, 'r')
	    or exit("unable to open file ($filename)");
	//这个用法看起来很屌。
```

* 可以序列化一个类，但是在实例化之前必须知道其类的结构，主要通过包含类的定义文件。
* 通过ini_get()和ini_set()来暂时改变php.ini的参数，比如php脚本最长运行时间。

（完）
