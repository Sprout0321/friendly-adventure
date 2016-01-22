package tw.com.ecomuniversal.ecomtest5;

import tw.com.ecomuniversal.ecomtest5.method.SharedPreferencesManager;
import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.database.Cursor;
import android.graphics.drawable.GradientDrawable;
import android.os.Build;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.CheckBox;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;


public class SettingActivity extends Activity {
	private static final String TAG = "SettingActivity";
	private Activity activity = this;
	private Context context = this;
	private ScrollView scrollView1_2;
	private RelativeLayout relativeLayout1, relativeLayout1_1, relativeLayout1_2_1_n_1, relativeLayout1_2_1_n_1_1;
	private LinearLayout linearLayout1_2_1, linearLayout1_2_1_n;
	private ImageView imageView1_1_2, imageView1_2_1_n_1_1_2;
	private TextView textView1_1_1, textView1_1_3, textView1_2_1_n, textView1_2_1_n_1_1_3;
	
	//資料元件
	private SproutDatabaseAdapter sproutDatabaseAdapter;
	private Cursor sproutTable1Cursor;
	
	private final String[] stringArray = {"1","2","3","4","5"};
    private final String[] stringArray2 = {"一", "二", "三", "四"};
    private Integer itemNumbers;

	// 表格欄位名稱: _ID, titleName, groupNumber, colorName, checkTrue
    private static final String UID = "_ID";
	private static final String TITLE = "titleName";
	private static final String COLOR = "colorName";
	private static final String CHECK = "checkTrue";
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
		// 以輔助類獲得資料庫對象
		sproutDatabaseAdapter = new SproutDatabaseAdapter(context);
		
        SharedPreferencesManager.saveFirstTime(context, "false");
        relativeLayout1 = new RelativeLayout(activity);
		RelativeLayout.LayoutParams newLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		relativeLayout1.setLayoutParams(newLayoutParams);
		setContentView(relativeLayout1);
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		setupViewComponent();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
    
    @Override
	public void onBackPressed() {
	    super.onBackPressed();
	    overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
    
    private void setupViewComponent() {
    	createRelativeLayout1_1();
    	createScrollView1_2();
	}
    
    private void createRelativeLayout1_1() {
		relativeLayout1_1 = new RelativeLayout(activity);
		relativeLayout1_1.setId(1001);
		relativeLayout1_1.setBackgroundColor(0xFF010203);
        RelativeLayout.LayoutParams newLayoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, convertDpToPixel(65, context));
        newLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		relativeLayout1_1.setLayoutParams(newLayoutParams);
		relativeLayout1.addView(relativeLayout1_1);
		createTextView1_1_1();
		createImageView1_1_2();
		createTextView1_1_3();
	}

	private void createTextView1_1_1() {
		textView1_1_1 = new TextView(activity);
    	textView1_1_1.setText("設定");
    	textView1_1_1.setTextSize(30f);
    	textView1_1_1.setTextColor(0xFFF1F2F3);
    	textView1_1_1.setGravity(Gravity.CENTER);
    	relativeLayout1_1.addView(textView1_1_1);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView1_1_1.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textViewLayoutParams.setMargins(0, 0, 0, 0);
    	textView1_1_1.setLayoutParams(textViewLayoutParams);
	}
	
	@SuppressLint("ClickableViewAccessibility")
	private void createImageView1_1_2() {
		imageView1_1_2 = new ImageView(activity);
		imageView1_1_2.setBackgroundResource(R.drawable.shape_b);
		imageView1_1_2.setId(1002);
		relativeLayout1_1.addView(imageView1_1_2);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams)imageView1_1_2.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		imageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
		imageViewLayoutParams.setMargins(0, 0, 20, 0);
		imageViewLayoutParams.width = 120;
    	imageViewLayoutParams.height = 80;
    	imageView1_1_2.setLayoutParams(imageViewLayoutParams);
    	imageView1_1_2.setOnTouchListener(new ImageView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					imageView1_1_2.setBackgroundResource(R.drawable.shape_g);
				case MotionEvent.ACTION_MOVE:
					imageView1_1_2.setBackgroundResource(R.drawable.shape_g);
					break;
				case MotionEvent.ACTION_UP:
					imageView1_1_2.setBackgroundResource(R.drawable.shape_b);
					onBackPressed();
					break;
				case MotionEvent.ACTION_CANCEL:
					break;
				default:
					break;
				}
				return true;
			}
    	});
	}
	
	private void createTextView1_1_3() {
		textView1_1_3 = new TextView(activity);
		textView1_1_3.setText("確定");
		textView1_1_3.setTextSize(20f);
		textView1_1_3.setTextColor(0xFFF1F2F3);
		textView1_1_3.setGravity(Gravity.CENTER);
		relativeLayout1_1.addView(textView1_1_3);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView1_1_3.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
    	textViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
    	textViewLayoutParams.setMargins(0, 0, 20, 0);
    	textViewLayoutParams.width = 120;
    	textViewLayoutParams.height = 80;
    	textView1_1_3.setLayoutParams(textViewLayoutParams);
	}
	
	private void createScrollView1_2() {
		scrollView1_2 = new ScrollView(activity);
		scrollView1_2.setBackgroundResource(R.drawable.background_logo);
		ScrollView.LayoutParams newLayoutParams = new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		scrollView1_2.setLayoutParams(newLayoutParams);
		relativeLayout1.addView(scrollView1_2);
		
		RelativeLayout.LayoutParams scrollViewLayoutParams = (RelativeLayout.LayoutParams)scrollView1_2.getLayoutParams();
		scrollViewLayoutParams.addRule(RelativeLayout.BELOW, 1001);
		scrollView1_2.setLayoutParams(scrollViewLayoutParams);
		
		createLinearLayout1_2_1();
	}
	
	private void createLinearLayout1_2_1() {
		// 垂直的LinearLayout, 裡面放了四個元件
		linearLayout1_2_1 = new LinearLayout(activity);
		linearLayout1_2_1.setOrientation(LinearLayout.VERTICAL);
		LinearLayout.LayoutParams newLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout1_2_1.setLayoutParams(newLayoutParams);
		scrollView1_2.addView(linearLayout1_2_1);
		
		// Group1
		itemNumbers = 0;
		createTextView1_2_1_n("Function1");
		sproutTable1Cursor = sproutDatabaseAdapter.getGroupData(1);
		Integer tableRowNumber = sproutTable1Cursor.getCount();
		Integer linearLayout1_2_1_nNumber = tableRowNumber/3;
    	Integer lastImageViewNumber = tableRowNumber%3;
		for (int i = 0; i < linearLayout1_2_1_nNumber; i++) {
			createLinearLayout1_2_1_n(3);
		}						
		if (lastImageViewNumber != 0) {
			createLinearLayout1_2_1_n(lastImageViewNumber);
		} else {
			//Do Nothing
		}
		
		// Group2
		itemNumbers = 0;
		createTextView1_2_1_n("Function2");
		sproutTable1Cursor = sproutDatabaseAdapter.getGroupData(2);
		tableRowNumber = sproutTable1Cursor.getCount();
		linearLayout1_2_1_nNumber = tableRowNumber/3;
    	lastImageViewNumber = tableRowNumber%3;
		for (int i = 0; i < linearLayout1_2_1_nNumber; i++) {
			createLinearLayout1_2_1_n(3);
		}
		if (lastImageViewNumber != 0) {
			createLinearLayout1_2_1_n(lastImageViewNumber);
		} else {
			//Do Nothing
		}
	}
	
	private void createTextView1_2_1_n(String text) {
		// 放"Function1"標題用
		textView1_2_1_n = new TextView(activity);
		LayoutParams newLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		textView1_2_1_n.setLayoutParams(newLayoutParams);
		textView1_2_1_n.setText(text);
		textView1_2_1_n.setTextSize(30f);
		textView1_2_1_n.setTextColor(0xFFF1F2F3);
		linearLayout1_2_1.addView(textView1_2_1_n);
    	LinearLayout.LayoutParams textViewLayoutParams = (LinearLayout.LayoutParams)textView1_2_1_n.getLayoutParams();
    	textViewLayoutParams.setMargins(20, 20, 0, 20);
    	textView1_2_1_n.setLayoutParams(textViewLayoutParams);
	}
	
	private void createLinearLayout1_2_1_n(Integer imageViewNumber) {
		//這個水平LinearLayout裡面會放3個RelativeLayout(最後1排會不滿3個)
		linearLayout1_2_1_n = new LinearLayout(activity);
		linearLayout1_2_1_n.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams newLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout1_2_1_n.setLayoutParams(newLayoutParams);
		linearLayout1_2_1.addView(linearLayout1_2_1_n);
		
		for (int i = 0; i < imageViewNumber; i++) {
			createRelativeLayout1_2_1_n_1();
		}
	}
	
	private void createRelativeLayout1_2_1_n_1() {
		// 寬度維持在螢幕寬度1/3的RelativeLayout
		relativeLayout1_2_1_n_1 = new RelativeLayout(activity);
		Integer width = getRelativeLayout5Width(getScreenWidth());
		Integer height = width * 4/3;
		RelativeLayout.LayoutParams newLayoutParams = new RelativeLayout.LayoutParams(width, height);
		relativeLayout1_2_1_n_1.setLayoutParams(newLayoutParams);
		createRelativeLayout1_2_1_n_1_1();
		linearLayout1_2_1_n.addView(relativeLayout1_2_1_n_1);
	}

	@SuppressWarnings("deprecation")
	@SuppressLint("NewApi")
	private void createRelativeLayout1_2_1_n_1_1() {
		// 外圍黑色框框
		relativeLayout1_2_1_n_1_1 = new RelativeLayout(activity);
		GradientDrawable border = new GradientDrawable();
		border.setColor(0x00FFFFFF); // white background
		border.setStroke(4, 0xFF000000); // black border with full opacity
		if (Build.VERSION.SDK_INT < Build.VERSION_CODES.JELLY_BEAN) {
			relativeLayout1_2_1_n_1_1.setBackgroundDrawable(border);
		} else {
			relativeLayout1_2_1_n_1_1.setBackground(border);
		}
		Integer width = getRelativeLayout1_2_1_n_1_1Width(getScreenWidth());
		Integer height = getRelativeLayout1_2_1_n_1_1Width(getScreenWidth());
		RelativeLayout.LayoutParams newLayoutParams = new RelativeLayout.LayoutParams(width, height);
		newLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
		relativeLayout1_2_1_n_1_1.setLayoutParams(newLayoutParams);
		relativeLayout1_2_1_n_1.addView(relativeLayout1_2_1_n_1_1);
		
		createCheckBox1_2_1_n_1_1_1();
		createImageView1_2_1_n_1_1_2();
		createTextView1_2_1_n_1_1_3();
		itemNumbers++;
	}
	
	private void createCheckBox1_2_1_n_1_1_1() {
		CheckBox checkBox = new CheckBox(activity);
		checkBox.setId(1210111);
		checkBox.setScaleX(0.8f);
		checkBox.setScaleY(0.8f);
		sproutTable1Cursor.moveToPosition(itemNumbers);
		Integer index_id = sproutTable1Cursor.getColumnIndex(UID);
		Integer index_checkTrue = sproutTable1Cursor.getColumnIndex(CHECK);
		Integer _id = sproutTable1Cursor.getInt(index_id);
		Boolean checkTrue = sproutTable1Cursor.getInt(index_checkTrue) > 0;
		checkBox.setChecked(checkTrue);
		checkBox.setTag(_id);	
		relativeLayout1_2_1_n_1_1.addView(checkBox);
		RelativeLayout.LayoutParams checkBoxLayoutParams = (RelativeLayout.LayoutParams) checkBox.getLayoutParams();
		checkBoxLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_LEFT, 1);
		checkBoxLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		Integer marginWidth = getCheckBoxMarginWidth(getScreenWidth());
		checkBoxLayoutParams.setMargins(marginWidth, 0, marginWidth, 0);
		checkBox.setLayoutParams(checkBoxLayoutParams);
	}

	private void createImageView1_2_1_n_1_1_2() {
		imageView1_2_1_n_1_1_2 = new ImageView(activity);
		sproutTable1Cursor.moveToPosition(itemNumbers);
		Integer index_colorName = sproutTable1Cursor.getColumnIndex(COLOR);
		String colorName = sproutTable1Cursor.getString(index_colorName);
		switch (colorName) {
		case "R":
			imageView1_2_1_n_1_1_2.setBackgroundResource(R.drawable.shape_r);
			break;
		case "G":
			imageView1_2_1_n_1_1_2.setBackgroundResource(R.drawable.shape_g);
			break;
		case "B":
			imageView1_2_1_n_1_1_2.setBackgroundResource(R.drawable.shape_b);
			break;
		default:
			break;
		}
		relativeLayout1_2_1_n_1_1.addView(imageView1_2_1_n_1_1_2);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView1_2_1_n_1_1_2.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
		imageViewLayoutParams.addRule(RelativeLayout.RIGHT_OF, 1210111);
		imageViewLayoutParams.setMargins(0, 0, 0, 0);
    	imageViewLayoutParams.width = getImageView6Width(getScreenWidth());
    	imageViewLayoutParams.height = getImageView6Width(getScreenWidth());
    	imageView1_2_1_n_1_1_2.setLayoutParams(imageViewLayoutParams);
//    	imageView1_2_1_n_1_1_2.setOnTouchListener(getImageViewOnTouchListener(position, imageView1_2_1_n_1_1_2));
	}
	
	private void createTextView1_2_1_n_1_1_3() {
		textView1_2_1_n_1_1_3 = new TextView(activity);
		textView1_2_1_n_1_1_3.setId(1003);
		sproutTable1Cursor.moveToPosition(itemNumbers);
		Integer index_titleName = sproutTable1Cursor.getColumnIndex(TITLE);
		String titleName = sproutTable1Cursor.getString(index_titleName);
		textView1_2_1_n_1_1_3.setText(titleName);
    	textView1_2_1_n_1_1_3.setTextSize(30f);
    	textView1_2_1_n_1_1_3.setTextColor(0xFF9FA0FF);
    	textView1_2_1_n_1_1_3.setGravity(Gravity.CENTER);
    	relativeLayout1_2_1_n_1_1.addView(textView1_2_1_n_1_1_3);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView1_2_1_n_1_1_3.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textViewLayoutParams.addRule(RelativeLayout.RIGHT_OF, 1210111);
    	textViewLayoutParams.width = getImageView6Width(getScreenWidth());
    	textViewLayoutParams.height = getImageView6Width(getScreenWidth());
    	textViewLayoutParams.setMargins(0, 0, 0, 0);
    	textView1_2_1_n_1_1_3.setLayoutParams(textViewLayoutParams);	
	}
	
	@SuppressLint("ClickableViewAccessibility")
	private ImageView.OnTouchListener getImageViewOnTouchListener(final Integer itemNumbers,final ImageView imageView) {
		ImageView.OnTouchListener imageViewOnTouchListener = new ImageView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					switch (itemNumbers%3) {
					case 0:
						imageView.setBackgroundResource(R.drawable.shape_g);
						break;
					case 1:
						imageView.setBackgroundResource(R.drawable.shape_b);
						break;
					case 2:
						imageView.setBackgroundResource(R.drawable.shape_r);
						break;
					default:
						break;
					}
					break;
				case MotionEvent.ACTION_MOVE:
					break;
				case MotionEvent.ACTION_UP:
					switch (itemNumbers%3) {
					case 0:
						imageView.setBackgroundResource(R.drawable.shape_r);
						break;
					case 1:
						imageView.setBackgroundResource(R.drawable.shape_g);
						break;
					case 2:
						imageView.setBackgroundResource(R.drawable.shape_b);
						break;
					default:
						break;
					}
					break;
				case MotionEvent.ACTION_CANCEL:
					switch (itemNumbers%3) {
					case 0:
						imageView.setBackgroundResource(R.drawable.shape_r);
						break;
					case 1:
						imageView.setBackgroundResource(R.drawable.shape_g);
						break;
					case 2:
						imageView.setBackgroundResource(R.drawable.shape_b);
						break;
					default:
						break;
					}
					break;
				default:
					break;
				}
				return true;
			}
		};
		return imageViewOnTouchListener;
	}
	
	
	private int getScreenWidth() {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int screenWidth = displaymetrics.widthPixels;
		return screenWidth;
	}
	
	private Integer getRelativeLayout5Width(Integer screenWidth) {
		Integer imageViewWidth = ((screenWidth)/3);
		return imageViewWidth;
	}
	
	private Integer getRelativeLayout1_2_1_n_1_1Width(Integer screenWidth) {
		Integer imageViewWidth = ((screenWidth)/3) - 20;
		return imageViewWidth;
	}
	
	private Integer getImageView6Width(Integer screenWidth) {
		Integer imageViewWidth = (((screenWidth)/5) - 20);
		return imageViewWidth;
	}
	
	private Integer getCheckBoxMarginWidth(Integer screenWidth) {
		Integer imageViewWidth = ((screenWidth)/300);
		return imageViewWidth;
	}
	
	private static Integer convertDpToPixel(Integer dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    Integer px = dp * (metrics.densityDpi / 160);
	    return px;
	}
    
}
