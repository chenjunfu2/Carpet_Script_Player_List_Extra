# Carpet_Script_Player_List_Extra
基于carpet脚本的扩展版玩家列表，可显示玩家、假人，把自己变成假人的玩家，可以与MCDR插件联动用于检测假人

请将脚本放在server\world\scripts下，并确保carpet配置里自动加载脚本为true，重启服务器或者手动load script即可

**使用：**

命令：/player_type_list list

响应：与原版命令list相同，但是玩家名有特殊处理
- 如果是假人玩家，则会带上@fake后缀
- 如果是shadow玩家，则会带上@shadow后缀
- 如果是真人玩家，则无后缀

解释：shawod玩家指的是，真人玩家在游戏内使用/carpet 自己名字 shadow离开服务器后留下的自己的假人
