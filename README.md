使用jersey+jetty 方案
更多的是测试 maven 打包方案 
master 分支 测试 maven assemble 插件。
unpack=true时 没问题，false时 meta-inf 缺少 maven 信息描述
maven 命令：mvn clean compile package  assembly:single
或者：使用 maven-jar + maven-dependency-plugin 配合打包
