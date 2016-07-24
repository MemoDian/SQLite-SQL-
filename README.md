# SQLite-SQL-
试用SQL语句控制SQLite数据库
<br>
 Cursor:游标接口,提供了遍历查询结果的方法,如移动指针方法move(),获得列值方法getString()等.<br>
		 * 常用方法:<br>
		 * 		getCount()	总记录条数<br>
		 * 		isFirst()	判断是否第一条记录<br>
		 * 		isLast()	判断是否最后一条记录<br>
		 * 		moveToFirst()	移动到第一条记录<br>
		 * 		moveToLast()	移动到最后一条记录<br>
		 * 		move(int offset)	移动到指定记录<br>
		 * 		moveTONext()	移动到下一条记录<br>
		 * 		moveToPrevious()	移动到上一条记录<br>
		 * 		getColumnIndexOrThrow(String columnName)	据列名称获得列索引<br>
		 * 		getInt(int columnIndex)		获得指定列索引的int类型值<br>
		 * 		getString(int columnIndex)	获得指定列索引的String类型值<br>
