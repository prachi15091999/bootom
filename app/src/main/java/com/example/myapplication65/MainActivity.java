package com.example.myapplication65;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.animation.ValueAnimator;
import android.graphics.Color;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.google.android.material.bottomnavigation.BottomNavigationView;
import com.sdsmdg.harjot.vectormaster.VectorMasterView;
import com.sdsmdg.harjot.vectormaster.models.PathModel;

public class MainActivity extends AppCompatActivity implements BottomNavigationView.OnNavigationItemReselectedListener {
    CurvedNavigationBottomView bottomView;
    VectorMasterView fab1,fab2,fab3;
    RelativeLayout l1;
    PathModel outline;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        bottomView=findViewById(R.id.ggdoi);
        fab1=findViewById(R.id.fab1);
        fab2=findViewById(R.id.fab2);
        fab3=findViewById(R.id.fab3);
        l1=findViewById(R.id.line);
        bottomView.inflateMenu(R.menu.menuex);
        bottomView.setOnNavigationItemReselectedListener(this);

    }

    @Override
    public void onNavigationItemReselected(@NonNull MenuItem menuItem) {
        switch (menuItem.getItemId())
        {
            case R.id.item1:
                Toast.makeText(this,"gudgcue",Toast.LENGTH_SHORT).show();
                draw(6);
                l1.setX(bottomView.mfirstcurvedcontrolpoint1.x);
                fab1.setVisibility(View.VISIBLE);
                fab2.setVisibility(View.GONE);
                fab3.setVisibility(View.GONE);
drawAnimation(fab1);
                break;
            case R.id.item2:
                Toast.makeText(this,"gudtdgcue",Toast.LENGTH_SHORT).show();
                draw(2);
                l1.setX(bottomView.mfirstcurvedcontrolpoint1.x);
                fab1.setVisibility(View.GONE);
                fab3.setVisibility(View.GONE);
                fab2.setVisibility(View.VISIBLE);
                drawAnimation(fab2);

                break;
            case R.id.item3:
                Toast.makeText(this,"gudtdgfificue",Toast.LENGTH_SHORT).show();
                draw();
                l1.setX(bottomView.mfirstcurvedcontrolpoint1.x);
                fab1.setVisibility(View.GONE);
                fab2.setVisibility(View.GONE);
                fab3.setVisibility(View.VISIBLE);

                break;

        }
    }

    private void draw() {
        bottomView.mfirstcurvedstrtingpoint.set((bottomView.mNavigationBarWidth*10/12)-(bottomView.Curve_Circle_Radius*2)-(bottomView.Curve_Circle_Radius/3),0);
        bottomView.mfirstcurvedendpoint.set(bottomView.mNavigationBarWidth*10/12,bottomView.Curve_Circle_Radius+(bottomView.Curve_Circle_Radius/4));
        bottomView.msecondcurvedstrtingpoint=bottomView.mfirstcurvedendpoint;
        bottomView.msecondcurvedendpoint.set((bottomView.mNavigationBarWidth *10/12)+(bottomView.Curve_Circle_Radius*2)+(bottomView.Curve_Circle_Radius/3),0);
        bottomView.mfirstcurvedcontrolpoint1.set(bottomView.mfirstcurvedstrtingpoint.x+bottomView.Curve_Circle_Radius+(bottomView.Curve_Circle_Radius/4),
                bottomView.mfirstcurvedstrtingpoint.y);
        bottomView.mfirstcurvedcontrolpoint2.set(bottomView.mfirstcurvedendpoint.x-(bottomView.Curve_Circle_Radius*2)+bottomView.Curve_Circle_Radius,bottomView.mfirstcurvedendpoint.y);
        bottomView.msecondcurvedcontrolpoint1.set(bottomView.msecondcurvedstrtingpoint.x+(bottomView.Curve_Circle_Radius*2)-bottomView.Curve_Circle_Radius,
                bottomView.msecondcurvedstrtingpoint.y);
        bottomView.msecondcurvedcontrolpoint2.set(bottomView.msecondcurvedendpoint.x-(bottomView.Curve_Circle_Radius)+(bottomView.Curve_Circle_Radius/4),bottomView.msecondcurvedendpoint.y);
    }

    private void drawAnimation(final VectorMasterView fab1) {
        outline=fab1.getPathModelByName("outline");
        outline.setStrokeColor(Color.WHITE);
        outline.setTrimPathEnd(0.0f);
        final ValueAnimator valueAnimator=ValueAnimator.ofFloat(0.0f,1.0f);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                outline.setTrimPathEnd((Float)valueAnimator.getAnimatedValue());
                fab1.update();
            }
        });
        valueAnimator.start();


    }

    private void draw(int i) {
        bottomView.mfirstcurvedstrtingpoint.set((bottomView.mNavigationBarWidth/i)-(bottomView.Curve_Circle_Radius*2)-(bottomView.Curve_Circle_Radius/3),0);
        bottomView.mfirstcurvedendpoint.set(bottomView.mNavigationBarWidth/i,bottomView.Curve_Circle_Radius+(bottomView.Curve_Circle_Radius/4));
        bottomView.msecondcurvedstrtingpoint=bottomView.mfirstcurvedendpoint;
        bottomView.msecondcurvedendpoint.set((bottomView.mNavigationBarWidth/i)+(bottomView.Curve_Circle_Radius*2)+(bottomView.Curve_Circle_Radius/3),0);
        bottomView.mfirstcurvedcontrolpoint1.set(bottomView.mfirstcurvedstrtingpoint.x+bottomView.Curve_Circle_Radius+(bottomView.Curve_Circle_Radius/4),
                bottomView.mfirstcurvedstrtingpoint.y);
        bottomView.mfirstcurvedcontrolpoint2.set(bottomView.mfirstcurvedendpoint.x-(bottomView.Curve_Circle_Radius*2)+bottomView.Curve_Circle_Radius,bottomView.mfirstcurvedendpoint.y);
        bottomView.msecondcurvedcontrolpoint1.set(bottomView.msecondcurvedstrtingpoint.x+(bottomView.Curve_Circle_Radius*2)-bottomView.Curve_Circle_Radius,
                bottomView.msecondcurvedstrtingpoint.y);
        bottomView.msecondcurvedcontrolpoint2.set(bottomView.msecondcurvedendpoint.x-(bottomView.Curve_Circle_Radius)+(bottomView.Curve_Circle_Radius/4),bottomView.msecondcurvedendpoint.y);
    }
}
