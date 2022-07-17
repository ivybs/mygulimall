mysql:10061错误码
产生错误的操作：docker安装mysql 8镜像后启动，发现无法连接原因是因为
密码不正确

然后设置跳过密码验证登录 登录后，将 root@localhost的authenrication_string字符串
设置为空，设置为空后update了新密码，但是 root@% 没有设置为空

然后回去将跳过密码验证登录关掉，再进容器里面，发现生效了，输密码的时候直接回车就可以了
然后用navicate远程连接报错 10061

解决：将root @ % 的 authenrication_string 也设置为空，然后update密码即可

设置authenrication_string:
update user set authentication_string="" where user=“root”;
update user set authentication_string="" where user=“root” and host="%";
为什么 执行上面那个语句的时候，不会更新下面这个数据。明明也是满足了where语句的。
---> 又在mysql8的环境下执行了查询语句，where user="root"是可以查询到两个数据的
update密码：
ALTER USER ‘root’@’%’ IDENTIFIED WITH mysql_native_password BY ‘密码’;
ALTER USER ‘root’@’localhost’ IDENTIFIED WITH mysql_native_password BY ‘密码’;
