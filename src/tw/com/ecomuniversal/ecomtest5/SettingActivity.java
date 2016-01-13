package tw.com.ecomuniversal.ecomtest5;

import android.annotation.SuppressLint;
import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
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
//	private static final String TAG = "SettingActivity";
	private Activity activity = this;
	private Context context = this;
	private ScrollView scrollView1_2;
	private RelativeLayout relativeLayout1, relativeLayout1_1, relativeLayout1_2_1_n_1;
	private LinearLayout linearLayout1_2_1, linearLayout1_2_1_n, linearLayout4_4;
	private ImageView imageView1_1_2, imageView6;
	private TextView textView1_1_1, textView4_1, textView4_3, textView6;
	
	private final String[] stringArray = {"1","2","3","4","5"};
    private final String[] stringArray2 = {"一", "二", "三", "四"};
    private Integer itemNumbers4_2 = 0, itemNumbers4_4 = 0;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
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
	
	private void createImageView1_1_2() {
		imageView1_1_2 = new ImageView(activity);
		imageView1_1_2.setBackgroundResource(R.drawable.shape_b);
		imageView1_1_2.setId(1002);
		relativeLayout1_1.addView(imageView1_1_2);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams)imageView1_1_2.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		imageViewLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_RIGHT, 1);
		imageViewLayoutParams.setMargins(0, 0, 50, 0);
    	imageViewLayoutParams.width = 80;
    	imageViewLayoutParams.height = 80;
    	imageView1_1_2.setLayoutParams(imageViewLayoutParams);
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
//		createLinearLayout1_2_1X();
	}
	
	private void createLinearLayout1_2_1() {
		linearLayout1_2_1 = new LinearLayout(activity);
		linearLayout1_2_1.setOrientation(LinearLayout.VERTICAL);
//		linearLayout1_2_1.setBackgroundColor(0xFFFA5858);
		LinearLayout.LayoutParams newLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout1_2_1.setLayoutParams(newLayoutParams);
		scrollView1_2.addView(linearLayout1_2_1);
		
		createTextView1_2_1_n("Function1");
		
		Integer linearLayout4_2_1Number = stringArray.length/3;
    	Integer lastImageViewNumber = stringArray.length%3;
		for (int i = 0; i < linearLayout4_2_1Number; i++) {
			createLinearLayout1_2_1_n(3);
		}						
		if (lastImageViewNumber != 0) {
			createLinearLayout1_2_1_n(lastImageViewNumber);
		} else {
			//Do Nothing
		}
		createTextView1_2_1_n("Function2");
		
		Integer linearLayout4_4_1Number = stringArray2.length/3;
    	Integer lastImageViewNumber2 = stringArray2.length%3;
		for (int i = 0; i < linearLayout4_4_1Number; i++) {
			createLinearLayout4_4(3);
		}						
		if (lastImageViewNumber2 != 0) {
			createLinearLayout4_4(lastImageViewNumber2);
		} else {
			//Do Nothing
		}
	}
	
	private void createTextView1_2_1_n(String text) {
		textView4_1 = new TextView(activity);
		LayoutParams newLayoutParams = new LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		textView4_1.setLayoutParams(newLayoutParams);
		textView4_1.setText(text);
		textView4_1.setTextSize(30f);
		textView4_1.setTextColor(0xFFF1F2F3);
//		textView4_1.setBackgroundColor(0xFFFA5858);
		linearLayout1_2_1.addView(textView4_1);
    	LinearLayout.LayoutParams textViewLayoutParams = (LinearLayout.LayoutParams)textView4_1.getLayoutParams();
    	textViewLayoutParams.setMargins(20, 20, 0, 20);
    	textView4_1.setLayoutParams(textViewLayoutParams);
	}
	
	private void createLinearLayout1_2_1_n(Integer imageViewNumber) {
		linearLayout1_2_1_n = new LinearLayout(activity);
		linearLayout1_2_1_n.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams newLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout1_2_1_n.setLayoutParams(newLayoutParams);
		linearLayout1_2_1.addView(linearLayout1_2_1_n);
		
		for (int i = 0; i < imageViewNumber; i++) {
			createRelativeLayout1_2_1_n_1(i, 1);
		}
	}
	
	private void createLinearLayout4_4(Integer imageViewNumber) {
		linearLayout4_4 = new LinearLayout(activity);
		linearLayout4_4.setOrientation(LinearLayout.HORIZONTAL);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayout4_4.setLayoutParams(layoutParams);
		linearLayout1_2_1.addView(linearLayout4_4);
		
		for (int i = 0; i < imageViewNumber; i++) {
			createRelativeLayout1_2_1_n_1(i, 2);
		}
	}
	
	private void createRelativeLayout1_2_1_n_1(Integer position, Integer group) {
		relativeLayout1_2_1_n_1 = new RelativeLayout(activity);
//		relativeLayout5.setBackgroundResource(R.drawable.shape_g);
		Integer width = getRelativeLayout5Width(getScreenWidth());
		Integer height = width * 4/3;
		RelativeLayout.LayoutParams newLayoutParams = new RelativeLayout.LayoutParams(width, height);
		relativeLayout1_2_1_n_1.setLayoutParams(newLayoutParams);
		
		createImageView6(position);
		createTextView6(position, group);
		createCheckBox6();
		if (group == 1) {
			linearLayout1_2_1_n.addView(relativeLayout1_2_1_n_1);			
		} else {
			linearLayout4_4.addView(relativeLayout1_2_1_n_1);
		}
	}

	private void createImageView6(Integer position) {
		imageView6 = new ImageView(activity);
		switch (position) {
		case 0:
			imageView6.setBackgroundResource(R.drawable.shape_r);
			break;
		case 1:
			imageView6.setBackgroundResource(R.drawable.shape_g);
			break;
		case 2:
			imageView6.setBackgroundResource(R.drawable.shape_b);
			break;
		default:
			break;
		}
		relativeLayout1_2_1_n_1.addView(imageView6);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView6.getLayoutParams();
		imageViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
		imageViewLayoutParams.setMargins(0, 0, 0, 0);
    	imageViewLayoutParams.width = getImageView6Width(getScreenWidth());
    	imageViewLayoutParams.height = getImageView6Width(getScreenWidth());
    	imageView6.setLayoutParams(imageViewLayoutParams);
    	imageView6.setOnTouchListener(getImageViewOnTouchListener(itemNumbers4_2, imageView6));
	}
	
	private void createTextView6(Integer position, Integer group) {
		textView6 = new TextView(activity);
		textView6.setId(1003);
		if (group == 1) {
			textView6.setText(stringArray[itemNumbers4_2]);			
			itemNumbers4_2++;
		} else {
			textView6.setText(stringArray2[itemNumbers4_4]);
			itemNumbers4_4++;
		}
    	textView6.setTextSize(30f);
    	textView6.setTextColor(0xFF9FA0FF);
    	textView6.setGravity(Gravity.CENTER);
    	relativeLayout1_2_1_n_1.addView(textView6);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView6.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textViewLayoutParams.setMargins(0, 0, 0, 0);
    	textView6.setLayoutParams(textViewLayoutParams);	
	}
	
	private void createCheckBox6() {
		CheckBox checkBox = new CheckBox(activity);
		relativeLayout1_2_1_n_1.addView(checkBox);
		RelativeLayout.LayoutParams checkBoxLayoutParams = (RelativeLayout.LayoutParams) checkBox.getLayoutParams();
		checkBoxLayoutParams.addRule(RelativeLayout.CENTER_VERTICAL, 1);
		checkBoxLayoutParams.addRule(RelativeLayout.LEFT_OF, 1003);
		
		checkBox.setLayoutParams(checkBoxLayoutParams);
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
		Integer imageViewWidth = (screenWidth)/3;
		return imageViewWidth;
	}
	
	private Integer getImageView6Width(Integer screenWidth) {
		Integer imageViewWidth = ((screenWidth)/5) + 40;
		return imageViewWidth;
	}
	
	private static Integer convertDpToPixel(Integer dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    Integer px = dp * (metrics.densityDpi / 160);
	    return px;
	}
    
}
