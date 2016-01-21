package tw.com.ecomuniversal.ecomtest5;

import tw.com.ecomuniversal.ecomtest5.method.FavoriteMethod;
import android.content.Context;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteDatabase.CursorFactory;
import android.database.sqlite.SQLiteOpenHelper;

public class NewListDataSQL extends SQLiteOpenHelper {
	
	private Context context;
	// 資料庫名
	private static final String DB_NAME = "SproutDataBase";
	// 表名
	private static final String TABLE_NAME = "SproutTable1";
	// 資料庫版本，關係到App更新時，資料庫是否要調用onUpgrade()
	private static final Integer VERSION = 1;
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
	public NewListDataSQL(Context context, String name, CursorFactory factory, int version) {
		super(context, name, factory, version);
		this.context = context;
		FavoriteMethod.useToast(this.context, "Constructor called");
	}

	public NewListDataSQL(Context context, String name) {
		this(context, name, null, VERSION);
		this.context = context;
		FavoriteMethod.useToast(this.context, "Constructor called");
	}

	public NewListDataSQL(Context context, String name, int version) {
		this(context, name, null, version);
		this.context = context;
		FavoriteMethod.useToast(this.context, "Constructor called");
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
