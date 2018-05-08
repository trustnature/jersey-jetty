使用jersey+jetty 搭建简单 restful 架构。
并测试 maven 打包方案 ，打包生成可执行jar.

一、使用maven-jar-plugin和maven-dependency-plugin插件打包
运行：mvn package 生成 主类（配置了lib路径）
运行：mvn dependency:copy-dependencies  生成 lib 包
特点：主类和jar分别存放

二、使用maven-assembly-plugin插件打包
运行：mvn clean compile package assembly:single 生成 整包，jar是解压状态（unpack=true）
特点：maven-assemble-plugin 配置比较灵活，不要试图 配置成 jar 不解压情况（unpack=false）,原因是 jar 里面不能再放 jar。
https://stackoverflow.com/questions/40385485/maven-three-jars-in-one-project-trying-to-use-an-assembly-but-not-getting-pom/40391530#40391530

三、对于spring集成的项目 建议使用 maven-shade-plugin 见 shade 分支。