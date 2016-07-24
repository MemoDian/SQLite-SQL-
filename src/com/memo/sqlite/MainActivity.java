package com.memo.sqlite;

import android.app.Activity;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		// 每一个程序都有自己的数据库,默认情况下是各自互不干扰
		// 创建一个数据库,并且打开(如果有了,直接打开)
		SQLiteDatabase db = openOrCreateDatabase("Dota.db", MODE_PRIVATE, null);
		db.execSQL("create table if not exists Dotatb(_id integer primary key autoincrement, name text not null,age integer not null,sex text not null)");
		db.execSQL("insert into Dotatb(name,sex,age) values('张三','女',18)");
		db.execSQL("insert into Dotatb(name,sex,age) values('李四','男',19)");
		db.execSQL("insert into Dotatb(name,sex,age) values('王五','女',20)");
		/**
		 * 查询
		 * Cursor 是一个管理数据集合的类,系统最后会自动释放
		 * 如果数据非常大,应该手动释放
		 * 谷歌推存手动释放
		 * 
		 * Cursor:游标接口,提供了遍历查询结果的方法,如移动指针方法move(),获得列值方法getString()等.
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
		 */
		Cursor c = db.rawQuery("select * from Dotatb", null);
		if(c!= null){
			while(c.moveToNext()){
				Log.i("info", "_id:"+c.getInt(c.getColumnIndex("_id")));
				Log.i("info", "name:"+c.getShort(c.getColumnIndex("name")));
				Log.i("info", "age:"+c.getInt(c.getColumnIndex("age")));
				Log.i("info", "sex:"+c.getString(c.getColumnIndex("sex")));
			}
			c.close();
		}
		db.close();
	}
}
