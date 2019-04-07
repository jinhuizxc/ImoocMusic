package com.jh.imoocmusic.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.os.Build;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.annotation.RequiresApi;
import android.text.InputType;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.EditText;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.jh.imoocmusic.R;

/**
 * 输入控件
 * 1. input_icon: 输入框前面图标
 * 2. input_hint： 输入框提示内容
 * 3. input_password: 输入内容是否需要以密文形式展示
 */
public class InputView extends FrameLayout {

    private int inputIcon;
    private String inputHint;
    private boolean isPassword;

    private View mView;
    private ImageView mIvIcon;
    private EditText mEtInput;


    public InputView(@NonNull Context context) {
        super(context);
        initView(context, null);
    }

    public InputView(@NonNull Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    public InputView(@NonNull Context context, @Nullable AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context, attrs);
    }


    @RequiresApi(api = Build.VERSION_CODES.LOLLIPOP)
    public InputView(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs){
        if (attrs == null) return;
        // 获取自定义属性
        TypedArray typedArray = context.obtainStyledAttributes(attrs, R.styleable.inputView);
        inputIcon = typedArray.getResourceId(R.styleable.inputView_input_icon, R.drawable.logo);
        inputHint = typedArray.getString(R.styleable.inputView_input_hint);
        isPassword = typedArray.getBoolean(R.styleable.inputView_is_password, false);
        typedArray.recycle();

        // 解析布局
        mView = LayoutInflater.from(context).inflate(R.layout.input_view, this, false);
        mIvIcon = mView.findViewById(R.id.iv_icon);
        mEtInput = mView.findViewById(R.id.et_input);

        // 布局关联属性
        mIvIcon.setImageResource(inputIcon);
        mEtInput.setHint(
                inputHint);
        mEtInput.setInputType(isPassword ? InputType.TYPE_CLASS_TEXT
                | InputType.TYPE_TEXT_VARIATION_PASSWORD : InputType.TYPE_CLASS_PHONE);

        addView(mView);
    }

    /**
     * 返回输入的内容
     * @return
     */
    public String getInputStr(){
        return mEtInput.getText().toString().trim();
    }
}
