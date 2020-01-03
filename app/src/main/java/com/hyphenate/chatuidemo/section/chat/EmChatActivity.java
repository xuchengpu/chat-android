package com.hyphenate.chatuidemo.section.chat;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.hyphenate.chatuidemo.R;
import com.hyphenate.chatuidemo.section.base.BaseInitActivity;
import com.hyphenate.easeui.constants.EaseConstant;
import com.hyphenate.easeui.ui.EaseChatFragment;

public class EmChatActivity extends BaseInitActivity {
    private String toChatUsername;
    private int chatType;

    public static void actionStart(Context context, String userId, int chatType) {
        Intent intent = new Intent(context, EmChatActivity.class);
        intent.putExtra(EaseConstant.EXTRA_USER_ID, userId);
        intent.putExtra(EaseConstant.EXTRA_CHAT_TYPE, chatType);
        context.startActivity(intent);
    }

    @Override
    protected int getLayoutId() {
        return R.layout.em_activity_chat;
    }

    @Override
    protected void initIntent(Intent intent) {
        super.initIntent(intent);
        toChatUsername = getIntent().getStringExtra(EaseConstant.EXTRA_USER_ID);
        chatType = getIntent().getIntExtra(EaseConstant.EXTRA_CHAT_TYPE, EaseConstant.CHATTYPE_SINGLE);
    }

    @Override
    protected void initView(Bundle savedInstanceState) {
        super.initView(savedInstanceState);
        EaseChatFragment fragment = new EaseChatFragment();
        Bundle bundle = new Bundle();
        bundle.putString(EaseConstant.EXTRA_USER_ID, toChatUsername);
        bundle.putInt(EaseConstant.EXTRA_CHAT_TYPE, chatType);
        fragment.setArguments(bundle);
        getSupportFragmentManager().beginTransaction().replace(R.id.fl_fragment, fragment, "chat").commit();
    }
}
