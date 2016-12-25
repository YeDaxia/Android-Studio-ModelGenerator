# Android-Studio-ModelGenerator

用于生成Api接口的数据模型类，你可以根据需要修改template模板，如果需要修改数据源的话，则可以修改`ProviderFactory`里面返回的对象，默认数据源是JsonEntryProvider。

# 数据源定义:

1. 表格数据[TableEntryProvider]:

| 字段        | 类型           | 描述  |
| ------------|:-------------:| -----:|
| pkgFile      | String | 包链接 |
| gameId     | long      |   游戏id |
| channelName | String     |    渠道名 |

复制到文本输入框之后:
```
pkgFile	String	包链接
gameId	long	游戏id
channelName	String	渠道名
```
生成代码:
```java
public class Package implements Serializable{

    private String pkgFile;
    private String gameId;
    private String channelName;

    @JSONField(name="pkgFile")
    public String getPkgFile(){
        return pkgFile;
    }

    @JSONField(name="pkgFile")
    public void setPkgFile(String pkgFile){
        this.pkgFile = pkgFile;
    }

    @JSONField(name="gameId")
    public String getGameId(){
        return gameId;
    }

    @JSONField(name="gameId")
    public void setGameId(String gameId){
        this.gameId = gameId;
    }

    @JSONField(name="channelName")
    public String getChannelName(){
        return channelName;
    }

    @JSONField(name="channelName")
    public void setChannelName(String channelName){
        this.channelName = channelName;
    }
}
```

2. Json Api[JsonEntryProvider]:

```json
{
	pkgFile:'file',
	gameId: 1000,
	channelName: 'google'
}
```
生成代码和上面一致。

3. 自定义数据源:

实现`IEntryProvider`接口，然后在`ProviderFactory`中返回即可。

# todo

1. 修改模板可配置。
2. 修改数据源可配置。