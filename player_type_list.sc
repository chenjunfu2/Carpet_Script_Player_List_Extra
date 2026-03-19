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

	//获取所有在线玩家
	players = player('all');
	
	//获取玩家数量
	player_count = length(players);

	//构建玩家列表字符串
	map_players = 
	if(
		player_count > 0,
			join(', ', map(players, player_name_cvrt(_))),//有玩家在线，转换每个玩家的名字
		//else
			'' //返回空字符串
	);

	//返回格式化的字符串，模拟原版list输出格式
	return (str('There are %d of a max of players online: %s', player_count, map_players));
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
