shade分支：测试 maven-shade-plugin 
该插件的作用与 maven-assemble-plugin 效果一致，一般用在与Spring项目集成项目中。
使用命令：mvn clean compile package shade:shade 即可生成混合可执行整包。
与 maven-assemble-plugin 不同之处在于 该插件需要配合 maven-jar-plugin 使用，未测试 unpack=false 情况。