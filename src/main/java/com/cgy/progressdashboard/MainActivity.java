package com.cgy.progressdashboard;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {
    LinearLayout mItemsContainer;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mItemsContainer= (LinearLayout) findViewById(R.id.main_container);

        for (int i = 0; i <3 ; i++) {
            createItemView(i*30,"血压",""+i*30,"mmHg", Color.RED);
        }
    }
    /**
     * 根据传入数据构建一个展示数据的view
     *
     * @param progress     进度条进度
     * @param itemName     名称
     * @param progressText 中间值
     * @param unitText     中间显示单位
     */
    private void createItemView(int progress, String itemName, String progressText,
                                String unitText, int color) {
        mItemsContainer.setWeightSum(mItemsContainer.getWeightSum() + 1);
        System.out.println(mItemsContainer.getWeightSum());
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, 0, 1);


        View view = View.inflate(getApplicationContext(), R.layout.measure_progress_item, null);
        MProgressView progressView = (MProgressView) view.findViewById(R.id.measure_progress);
        TextView textView = (TextView) view.findViewById(R.id.measure_item_tx);

        textView.setText(itemName);
        progressView.setProgress(progress);
        progressView.setProgressText(progressText);

        progressView.setProgressColor(color);
        progressView.setProgressTextColor(color);

        progressView.setUnitText(unitText);
        view.setTag(progressView);

        mItemsContainer.addView(view, params);
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }
}
