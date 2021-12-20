package com.example.newsforyou.Fragments;

import android.content.Intent;
import android.os.Bundle;
import android.provider.ContactsContract;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.newsforyou.ProfileActivity;
import com.example.newsforyou.R;

public class SettingFragment extends Fragment {

    private View mView;
    private TextView tvOption;
    private ImageView ivAvatar;
    private TextView tvName;
    private ImageView ivView;
    private ImageView ivDownload;
    private ImageView ivSave;
    private ImageView ivReport;
    private TextView tvView;
    private TextView tvDownload;
    private TextView tvSave;
    private TextView tvReport;
    private TextView tvSetting;
    private ImageView ivNotification;
    private ImageView ivTextSize;
    private TextView tvNotification;
    private TextView tvTextSize;
    private TextView tvLogout;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_setting, container, false);

        initUI();
        initListener();

        return  mView;
    }

    public void initUI() {
        ivAvatar = (ImageView) mView.findViewById(R.id.iv_avatar_setting);
        tvOption = (TextView) mView.findViewById(R.id.tv_option);
        tvName = (TextView) mView.findViewById(R.id.tv_name_setting);

        tvView = (TextView) mView.findViewById(R.id.tv_view_setting);
        tvDownload = (TextView) mView.findViewById(R.id.tv_download_setting);
        tvSave = (TextView) mView.findViewById(R.id.tv_save_setting);
        tvReport = (TextView) mView.findViewById(R.id.tv_report_setting);
        ivSave = (ImageView) mView.findViewById(R.id.iv_save_setting);
        ivView = (ImageView) mView.findViewById(R.id.iv_view_setting);
        ivDownload = (ImageView) mView.findViewById(R.id.iv_download_setting);
        ivReport = (ImageView) mView.findViewById(R.id.iv_report_setting);

        tvSetting = (TextView) mView.findViewById(R.id.tv_setting_setting);
        tvNotification = (TextView) mView.findViewById(R.id.tv_notification_setting);
        tvTextSize = (TextView) mView.findViewById(R.id.tv_text_size_setting);
        tvLogout = (TextView) mView.findViewById(R.id.tv_logout_setting);
        ivNotification = (ImageView) mView.findViewById(R.id.iv_notification_setting);
        ivTextSize = (ImageView) mView.findViewById(R.id.iv_text_size_setting);

    }

    public void initListener() {
        ivAvatar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity(), ProfileActivity.class);
                startActivity(intent);
            }
        });
    }
}
