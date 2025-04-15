list() ->
(
	//转换函数
	player_name_cvrt(p) ->
	(
		//通过玩家类型获取玩家信息
		p_type = query(player(p), 'player_type');
		if
		(
			p_type == 'fake',//if
				return (p + '@fake'),//fake player假人返回@fake
			p_type == 'shadow',//elif
				return (p + '@shadow'),//shadow player真玩家变的假人返回@shadow
			//else
			return (p)//其余真玩家返回正常名字
		);
	);

	//运行服务端list命令，取出服务端命令输出
	parts = run('list'):1;
	//输出转换为字符串去掉列表方括号，以冒号分割左右两端，左端是玩家个数信息
	//右端是玩家列表
	parts = split(': ', replace(str(parts), '[\\[\\]]', ''));

	//右端字符串转为列表后通过map将每个名字映射到对应的玩家类型
	map_players =
	if
	(
		has(parts,1),//判断有没有玩家列表
			join(', ', map(split(', ', parts:1), player_name_cvrt(_))),//返回转换后的玩家列表字符串
		//else
			''//没有玩家的情况，直接返回空字符串
	);

	//返回值模拟服务端输出list
	return (str('%s: %s', str(parts:0), map_players));
);

//注册命令
__command() -> {};

//设置为全局调用、调用版本要求和权限要求
__config() -> {
	'scope' -> 'global',
	'requires' -> {
		'carpet' -> '>=1.4.45',
		'minecraft' -> '>=1.18'
	},
	'command_permission' -> 2
};
