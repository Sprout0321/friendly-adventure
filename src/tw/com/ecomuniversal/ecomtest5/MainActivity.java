package tw.com.ecomuniversal.ecomtest5;

import android.app.Activity;
import android.content.Context;
import android.content.res.Resources;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.Gravity;
import android.view.Menu;
import android.view.MenuItem;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup.LayoutParams;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.ScrollView;
import android.widget.TextView;

public class MainActivity extends Activity {
	private static final String TAG = "MainActivity";
	private Activity activity = this;
	private Context context = this;
	private RelativeLayout relativeLayout, relativeLayout2;
	private LinearLayout linearLayout3;
    private ScrollView scrollView2;
    private final String[] stringArray = {"設定","b","c","d","e","f","g","h","i","j",
			"k","l","m","n","o","p","q","r","s","t",
			"u","v","w","x","y","z"};
//    private final String[] stringArray2 = {"1","2"};
    private Integer itemNumbers = 0;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        relativeLayout = new RelativeLayout(activity);
        RelativeLayout.LayoutParams layoutparams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		relativeLayout.setLayoutParams(layoutparams);
        setContentView(relativeLayout);
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
    
    private void setupViewComponent() {
//    	scrollView = (ScrollView) activity.findViewById(R.id.activity_main_scroll_view);
    	createRelativeLayout2();
    	createScrollView2();
	}
    
	private void createRelativeLayout2() {
		relativeLayout2 = new RelativeLayout(activity);
		relativeLayout2.setId(1001);
		relativeLayout2.setBackgroundColor(0xFF010203);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.MATCH_PARENT, convertDpToPixel(65, context));
		relativeLayout2.setLayoutParams(layoutParams);
		relativeLayout.addView(relativeLayout2);
		
		RelativeLayout.LayoutParams relativeLayoutLayoutParams = (RelativeLayout.LayoutParams)relativeLayout2.getLayoutParams();
		relativeLayoutLayoutParams.addRule(RelativeLayout.ALIGN_PARENT_TOP);
		relativeLayout2.setLayoutParams(relativeLayoutLayoutParams);
		
		createTextView3();
		createImageView3();
	}

	private void createTextView3() {
		// TODO Auto-generated method stub
		
	}

	private void createImageView3() {
		// TODO Auto-generated method stub
		
	}

	private void createScrollView2() {
		scrollView2 = new ScrollView(activity);
		scrollView2.setBackgroundResource(R.drawable.background_logo);
		ScrollView.LayoutParams scrollViewLayoutParams = new ScrollView.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.MATCH_PARENT);
		scrollView2.setLayoutParams(scrollViewLayoutParams);
		relativeLayout.addView(scrollView2);
		
		RelativeLayout.LayoutParams relativeLayoutLayoutParams = (RelativeLayout.LayoutParams)scrollView2.getLayoutParams();
		relativeLayoutLayoutParams.addRule(RelativeLayout.BELOW, 1001);
		scrollView2.setLayoutParams(relativeLayoutLayoutParams);
		
		createLinearLayout3();
	}
	
	private void createLinearLayout3() {
		linearLayout3 = new LinearLayout(activity);
		linearLayout3.setOrientation(LinearLayout.VERTICAL);
		linearLayout3.setBackgroundColor(0xFFFA5858);
		LinearLayout.LayoutParams linearLayoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, LayoutParams.WRAP_CONTENT);
		linearLayoutParams.setMargins(50, 0, 50, 0);
		linearLayout3.setLayoutParams(linearLayoutParams);
		scrollView2.addView(linearLayout3);
		
		Integer linearLayout4_1Number = stringArray.length/3;
    	Integer lastImageViewNumber = stringArray.length%3;
		
		for (int i = 0; i < linearLayout4_1Number; i++) {
			createLinearLayout4(3);
		}						
		if (lastImageViewNumber != 0) {
			createLinearLayout4(lastImageViewNumber);
		} else {
			//Do Nothing
		}
	}
	
	private void createLinearLayout4(Integer imageViewNumber) {
		LinearLayout linearLayout4 = new LinearLayout(activity);
		linearLayout4.setBackgroundResource(R.drawable.shape_g);
		LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LayoutParams.MATCH_PARENT, 300);
		linearLayout4.setOrientation(LinearLayout.HORIZONTAL);
		linearLayout4.setLayoutParams(layoutParams);
		linearLayout3.addView(linearLayout4);
		
		for (int i = 0; i < imageViewNumber; i++) {
			createImageView(linearLayout4, i);
		}
	}
	
	private void createImageView(LinearLayout linearLayout1_1, Integer position) {
		RelativeLayout relativeLayout = new RelativeLayout(activity);
		relativeLayout.setBackgroundResource(R.drawable.shape_b);
		RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(LayoutParams.WRAP_CONTENT, LayoutParams.WRAP_CONTENT);
		layoutParams.width = getImageViewWidth(getScreenWidth());
		layoutParams.height = getImageViewWidth(getScreenWidth());
		layoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, RelativeLayout.TRUE);
		relativeLayout.setLayoutParams(layoutParams);
		ImageView imageView = new ImageView(activity);
		switch (position) {
		case 0:
			imageView.setBackgroundResource(R.drawable.shape_r);
			break;
		case 1:
			imageView.setBackgroundResource(R.drawable.shape_r);
			break;
		case 2:
			imageView.setBackgroundResource(R.drawable.shape_r);
			break;
		default:
			break;
		}
		relativeLayout.addView(imageView);
		RelativeLayout.LayoutParams imageViewLayoutParams = (RelativeLayout.LayoutParams) imageView.getLayoutParams();
    	imageViewLayoutParams.width = 150;
    	imageViewLayoutParams.height = 150;
    	imageViewLayoutParams.setMargins(10, 10, 10, 10);
    	imageView.setLayoutParams(imageViewLayoutParams);
//    	imageView.setOnClickListener(getImageViewOnClickListener(itemNumbers));
    	imageView.setOnTouchListener(getImageViewOnTouchListener(itemNumbers, imageView));
    	
    	TextView textView = new TextView(activity);
    	textView.setText(stringArray[itemNumbers]);
    	itemNumbers++;
    	textView.setTextSize(30f);
    	textView.setTextColor(0xFF9FA0FF);
    	textView.setGravity(Gravity.CENTER);
    	relativeLayout.addView(textView);
    	RelativeLayout.LayoutParams textViewLayoutParams = (RelativeLayout.LayoutParams)textView.getLayoutParams();
    	textViewLayoutParams.addRule(RelativeLayout.CENTER_IN_PARENT, 1);
    	textView.setLayoutParams(textViewLayoutParams);
    	linearLayout1_1.addView(relativeLayout);
	}
	
	private ImageView.OnClickListener getImageViewOnClickListener(final Integer itemNumbers) {
		ImageView.OnClickListener imageViewOnClickListener = new ImageView.OnClickListener() {
			public void onClick(View v) {
				FavoriteMethod.useToast(context, stringArray[itemNumbers]);
			}
		};
		return imageViewOnClickListener;
	}
	
	private ImageView.OnTouchListener getImageViewOnTouchListener(final Integer itemNumbers,final ImageView imageView) {
		ImageView.OnTouchListener imageViewOnTouchListener = new ImageView.OnTouchListener() {
			@Override
			public boolean onTouch(View v, MotionEvent event) {
				int action = event.getAction();
				switch (action) {
				case MotionEvent.ACTION_DOWN:
					imageView.setBackgroundResource(R.drawable.shape_g);
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_DOWN");
					break;
				case MotionEvent.ACTION_MOVE:
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_MOVE");
					break;
				case MotionEvent.ACTION_UP:
					imageView.setBackgroundResource(R.drawable.shape_b);
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_UP");
					FavoriteMethod.useToast(context, stringArray[itemNumbers]);
					setImageViewListener(itemNumbers);
					break;
				case MotionEvent.ACTION_CANCEL:
					imageView.setBackgroundResource(R.drawable.shape_b);
					Log.d(TAG + " > getImageViewOnTouchListener()", "action 是 ACTION_CANCEL");
					break;
				default:
					break;
				}
				return true;
			}
		};
		return imageViewOnTouchListener;
	}
	
	private void setImageViewListener(Integer itemNumbers) {
		switch (itemNumbers) {
		case 0:
			FavoriteMethod.changeView(activity, SettingActivity.class);
			break;
		default:
			break;
		}
	}
	
	
	
	private int getScreenWidth() {
		DisplayMetrics displaymetrics = new DisplayMetrics();
		activity.getWindowManager().getDefaultDisplay().getMetrics(displaymetrics);
		int screenWidth = displaymetrics.widthPixels;
		return screenWidth;
	}
	
	private Integer getImageViewWidth(Integer screenWidth) {
		Integer imageViewWidth = (screenWidth - 80)/3; 
		return imageViewWidth;
	}
	
	private static Integer convertDpToPixel(Integer dp, Context context){
	    Resources resources = context.getResources();
	    DisplayMetrics metrics = resources.getDisplayMetrics();
	    Integer px = dp * (metrics.densityDpi / 160);
	    return px;
	}
    
}
