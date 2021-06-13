# QuickApp

- 个人中心

  - 修改个人信息

    ```json
    {
        "username":"",
        "password":"",
        "sex":"",
        "age":21
    }
    ```

  - 查看个人信息

    ```json
    {
        "username":"",
        "password":"",
        "sex":"",
        "age":21
    }
    ```

- 登录注册

  - 登录: 用户名、密码

    ```json
    {
        "username":"",
        "password":"",
    }
    ```

  - 注册：用户名、密码、性别、年龄

    ```json
    {
    	"username":"",
        "password":"",
        "sex":true,
        "age":20
    }
    ```

- 问卷页面

  - 问卷内容:

    ```json
    {
    	"uid":21,
    	"date":"",
    	"answers":[
        	4，3
    	]   
    }
    ```

  - 问卷列表

    ```json
    [
    	{
    		"uid":21,
    		"date":"",
    		"answers":[
        		4,3
    		]   
    	}
    ]
    ```

- 设备界面

  - 设备列表: List<Machine>

    ```json
    [
    	{
        	"mid":1,
        	"state":true,
        	"data":""
    	}
    ]
    ```

  - 设备数据: 

    ```json
    {
        "mid":1,
        "state":true,
        "data":""
    }
    ```

- 个人健康数据页面

  - 健康数值

  - 症状分析

  - 健康建议

    ```json
    {
    	"score":90,
        "symptom":[
            "肺部不好"
        ],
        "advice":[
            "注意饮食"
        ]
    }
    ```

    

  

