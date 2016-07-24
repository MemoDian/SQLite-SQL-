# SQLite-SQL-
试用SQL语句控制SQLite数据库

Cursor:游标接口,提供了遍历查询结果的方法,如移动指针方法move(),获得列值方法getString()等.
		 * 常用方法:
		 * 		getCount()	总记录条数
		 * 		isFirst()	判断是否第一条记录
		 * 		isLast()	判断是否最后一条记录
		 * 		moveToFirst()	移动到第一条记录
		 * 		moveToLast()	移动到最后一条记录
		 * 		move(int offset)	移动到指定记录
		 * 		moveTONext()	移动到下一条记录
		 * 		moveToPrevious()	移动到上一条记录
		 * 		getColumnIndexOrThrow(String columnName)	据列名称获得列索引
		 * 		getInt(int columnIndex)		获得指定列索引的int类型值
		 * 		getString(int columnIndex)	获得指定列索引的String类型值
