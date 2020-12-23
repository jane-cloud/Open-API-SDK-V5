环境要求：
php版本：7.2及以上   
composer：需要进行安装，后续进行依赖包的更新  
系统要求：Windows、Linux或者Mac

第一步：进入到项目根目录，安装依赖
   
    1.1 安装依赖composer包
    
        composer update
    
第二步：配置自己的API key

    2.1 先去OKEx官网申请API Key
    2.2 将各项参数在Config文件中进行替换

第三步：调用Rest，在项目根目录下，运行如下命令
    
    3.1 调用Rest公共接口
        
        php rapiDemo.php
        
    3.2 调用websocket
    
        php wsDemo.php start
