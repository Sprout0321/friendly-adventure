package tw.com.ecomuniversal.ecomtest5;

import tw.com.ecomuniversal.ecomtest5.method.FavoriteMethod;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class SproutDatabaseAdapter {
	SproutSQLiteOpenHelper sproutSQLiteOpenHelper;
	
	public SproutDatabaseAdapter(Context context, String name, CursorFactory factory, int version) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context, name, factory, version);
	}
	
	public SproutDatabaseAdapter(Context context, String name, int version) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context, name, version);
	}
	
	public SproutDatabaseAdapter(Context context, String name) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context, name);
	}
	
	public SproutDatabaseAdapter(Context context) {
		sproutSQLiteOpenHelper = new SproutSQLiteOpenHelper(context);
	}
	
	public void getWritableDatabase() {
		sproutSQLiteOpenHelper.getWritableDatabase();
	}
	
	public long insertData(Integer group, String color, Boolean check){
		SQLiteDatabase sqlDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		ContentValues contentValues = new ContentValues();
		contentValues.put(SproutSQLiteOpenHelper.GROUP, group);
		contentValues.put(SproutSQLiteOpenHelper.COLOR, color);
		contentValues.put(SproutSQLiteOpenHelper.CHECK, check);
		Long id = sqlDatabase.insert(SproutSQLiteOpenHelper.TABLE_NAME, null, contentValues);
		return id;
	}
	
	public String getAllData(){
		SQLiteDatabase sqlDatabase = sproutSQLiteOpenHelper.getWritableDatabase();
		// select _ID, Group, Color, Check form SproutTable1
		String[] stringArray = {SproutSQLiteOpenHelper.UID,
				SproutSQLiteOpenHelper.GROUP,
				SproutSQLiteOpenHelper.COLOR,
				SproutSQLiteOpenHelper.CHECK,};
		Cursor cursor = sqlDatabase.query(SproutSQLiteOpenHelper.TABLE_NAME, stringArray, null, null, null, null, null);
		StringBuffer stringBuffer = new StringBuffer();
		while (cursor.moveToNext()) {
			String _id = cursor.getString(0);
			String group = cursor.getString(1);
			String color = cursor.getString(2);
			String check = cursor.getString(3);
			stringBuffer.append(_id + " " + group + " " + color + " " + check + "\n");
		}
		return stringBuffer.toString();
	}
	

	static class SproutSQLiteOpenHelper extends SQLiteOpenHelper {
		private Context context;
		// 資料庫名
		private static final String DATABASE_NAME = "SproutDataBase";
		// 表名
		private static final String TABLE_NAME = "SproutTable1";
		// 資料庫版本，關係到App更新時，資料庫是否要調用onUpgrade()
		private static final Integer DATABASE_VERSION = 1;
		// 表格欄位名稱: _ID, Group, Color, Check
		private static final String UID = "_ID";
		private static final String GROUP = "Group";
		private static final String COLOR = "Color";
		private static final String CHECK = "Check";
		// 創建表格字串
		private static final String CREATE_TABLE = "CREATE TABLE " + TABLE_NAME
				+ " (" + UID +"  INTEGER PRIMARY KEY  AUTOINCREMENT  NOT NULL,"
				+ GROUP + "VARCHAR"
				+ COLOR + "VARCHAR"
				+ CHECK + "BOOLEAN" + ")";
		// 刪除表格字串
		private static final String DROP_TABLE = "DROP TABLE IF EXISTS " + TABLE_NAME;
		
		// 建構子
		public SproutSQLiteOpenHelper(Context context, String name, CursorFactory factory, int version) {
			super(context, name, factory, version);
			this.context = context;
			FavoriteMethod.useToast(this.context, "Constructor(4) called");
		}
		
		public SproutSQLiteOpenHelper(Context context, String name, int version) {
			this(context, name, null, version);
			this.context = context;
			FavoriteMethod.useToast(this.context, "Constructor(3) called");
		}

		public SproutSQLiteOpenHelper(Context context, String name) {
			this(context, name, null, DATABASE_VERSION);
			this.context = context;
			FavoriteMethod.useToast(this.context, "Constructor(2) called");
		}
		
		public SproutSQLiteOpenHelper(Context context) {
			this(context, DATABASE_NAME, null, DATABASE_VERSION);
			this.context = context;
			FavoriteMethod.useToast(this.context, "Constructor(1) called");
		}

		// 輔助類建立時運行該方法
		@Override
		public void onCreate(SQLiteDatabase db) {
			try {
				FavoriteMethod.useToast(context, "onCreate() called");
				db.execSQL(CREATE_TABLE);
			} catch (SQLException e) {
				FavoriteMethod.useToast(context, e.toString());
			}
		}

		@Override
		public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
			// oldVersion=舊的資料庫版本；newVersion=新的資料庫版本
			try {
				FavoriteMethod.useToast(context, "onUpgrade() called");
				// 刪除舊有的資料表
				db.execSQL(DROP_TABLE);
				onCreate(db);
			} catch (SQLException e) {
				FavoriteMethod.useToast(context, e.toString());
			}
		}

		@Override
		public void onOpen(SQLiteDatabase db) {
			super.onOpen(db);
			// TODO 每次成功打開數據庫後首先被執行
		}

		@Override
		public synchronized void close() {
			super.close();
		}

	}
}
