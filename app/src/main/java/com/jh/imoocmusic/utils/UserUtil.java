package com.jh.imoocmusic.utils;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.text.TextUtils;
import android.widget.Toast;

import com.blankj.utilcode.util.RegexUtils;
import com.blankj.utilcode.util.ToastUtils;
import com.jh.imoocmusic.R;
import com.jh.imoocmusic.ui.activity.LoginActivity;

public class UserUtil {

    /**
     * 验证登录用户输入合法性
     * @param context
     * @return
     */
    public static boolean validateLogin(Context context, String phone, String password){
//        简单的
        RegexUtils.isMobileSimple(phone);
//        精确的
        if (!RegexUtils.isMobileExact(phone)){
//            ToastUtils.showShort("无效手机号");
            Toast.makeText(context, "无效手机号", Toast.LENGTH_SHORT).show();
            return false;
        }

        if (TextUtils.isEmpty(password)){
//            ToastUtils.showShort("无效手机号");
            Toast.makeText(context, "请输入密码", Toast.LENGTH_SHORT).show();
            return false;
        }
        return true;
    }

    /**
     * 退出登录
     * @param context
     */
    public static void logout(Context context){
        Intent intent = new Intent(context, LoginActivity.class);
        // 添加intent标志符，清理task栈，并且新生成一个task栈
        intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TASK | Intent.FLAG_ACTIVITY_NEW_TASK);
        context.startActivity(intent);

        // 由于加了上面task的处理导致动画出现问题，所有需要加上下面这行代码, 定义Activity跳转动画
        ((Activity)context).overridePendingTransition(R.anim.open_enter, R.anim.open_exit);
    }
}
