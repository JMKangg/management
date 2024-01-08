package com.example.management;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.Environment;
import android.os.Handler;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    private FButton btnStart;
    private Button btnSafetyCheck;
    private Button btnLearning;
    private Button btnLearningSave;
    private Button btnDrive;
    private Button btnAnalysis;
    private Button btnReport;
    private Button btnStop;
    private Button btnEmergencyStop;
    private TextView textView;
    private  int count = 0;

    private void navigateToButtonDelayed(final Button button, int delayInMillis) {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                button.performClick();
            }
        }, delayInMillis);
    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnStart = (FButton) findViewById(R.id.btnstart);
        btnSafetyCheck = findViewById(R.id.btnsafetycheck);
        btnLearning = findViewById(R.id.btnlearning);
        btnLearningSave = findViewById(R.id.btnlearningsave);
        btnDrive = findViewById(R.id.btndrive);
        btnAnalysis = findViewById(R.id.btnanalysis);
        btnReport = findViewById(R.id.btnreport);
        btnStop = findViewById(R.id.btnstop);
        btnEmergencyStop = findViewById(R.id.btnEmergencyStop);
        textView = findViewById(R.id.number);


        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showOptionDialog_start();
                /*
                //button 액션
                setButtonsEnabled(true,false,false,false,false,false,false,false);

                // START 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_one(2023-12-18)
                readCountFromFile(R.raw.count_one);
                textView.setText(String.valueOf(count));
                navigateToButtonDelayed(btnSafetyCheck, 2000);
                //navigateToButton(btnSafetyCheck);

                 */
            }
        });

        btnSafetyCheck.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                //button 액션
                setButtonsEnabled(false,true,false,false,false,false,false,false);

                // SAFETY CHECK 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_two(2023-12-18)
                readCountFromFile(R.raw.count_two);
                textView.setText(String.valueOf(count));
                navigateToButtonDelayed(btnLearning, 2000);
                //navigateToButton(btnLearning);

                 */
            }
        });

        btnLearning.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                //button 액션
                setButtonsEnabled(false,false,true,false,false,false,false,false);

                // LEARNING 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_three(2023-12-18)
                readCountFromFile(R.raw.count_three);
                textView.setText(String.valueOf(count));
                navigateToButtonDelayed(btnLearningSave, 2000);
                //navigateToButton(btnLearningSave);

                 */
            }
        });

        btnLearningSave.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                //button 액션
                setButtonsEnabled(false,false,false,true,false,false,false,false);

                // LEARNING SAVE 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_four(2023-12-18)
                readCountFromFile(R.raw.count_four);
                textView.setText(String.valueOf(count));
                navigateToButtonDelayed(btnDrive, 2000);
                //navigateToButton(btnDrive);

                 */
            }
        });

        btnDrive.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                //button 액션
                setButtonsEnabled(false,false,false,false,true,false,false,false);

                // DRIVE 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_five(2023-12-18)
                readCountFromFile(R.raw.count_five);
                textView.setText(String.valueOf(count));
                navigateToButtonDelayed(btnAnalysis, 2000);
                //navigateToButton(btnAnalysis);

                 */
            }
        });

        btnAnalysis.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                //button 액션
                setButtonsEnabled(false,false,false,false,false,true,false,false);

                // ANALYSIS 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_six(2023-12-18)
                readCountFromFile(R.raw.count_six);
                textView.setText(String.valueOf(count));
                navigateToButtonDelayed(btnReport, 2000);
                //navigateToButton(btnReport);

                 */
            }
        });

        btnReport.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                /*
                //button 액션
                setButtonsEnabled(false,false,false,false,false,false,true,false);

                // DRIVE 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_seven(2023-12-18)
                readCountFromFile(R.raw.count_seven);
                textView.setText(String.valueOf(count));
                navigateToButtonDelayed(btnStop, 2000);
                //navigateToButton(btnStop);

                 */
            }
        });

        btnStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                //button 액션
                setButtonsEnabled(false,false,false,false,false,false,false,true);

                // STOP 버튼 기능 수행
                // 파일(txt) 읽어 오기-count_zero(2023-12-18)
                readCountFromFile(R.raw.count_zero);
                textView.setText(String.valueOf(count));

                 //button 액션 초기화
                new Handler().postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        // 2초 후 버튼 활성화
                        setButtonsEnabled(true, true, true, true, true, true, true, true);
                    }
                }, 2000);
            }
        });

        btnEmergencyStop.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // app 중단(2023-12-18)
                finish();
            }
        });
    }

    private void showOptionDialog_start() {
        PopupMenu popupMenu = new PopupMenu(this, btnStart);
        popupMenu.getMenu().add("Option 1");
        popupMenu.getMenu().add("Option 2");
        // 원하는 만큼의 옵션 추가

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                String option = item.getTitle().toString();
                // 각 옵션을 클릭했을 때의 동작을 여기에 정의
                switch (option) {
                    case "Option 1":
                        // Option 1 선택 시 동작
                        return true;
                    case "Option 2":
                        // Option 2 선택 시 동작
                        return true;
                    // 추가적인 옵션에 대한 처리 추가
                    default:
                        return false;
                }
            }
        });

        popupMenu.show();
    }

    //button 초기화함수
    private void setButtonsEnabled(boolean startEnabled, boolean safetyCheckEnabled,
                                   boolean learningEnabled, boolean learningSaveEnabled,
                                   boolean driveEnabled, boolean analysisEnabled,
                                   boolean reportEnabled, boolean stopEnabled) {
        btnStart.setEnabled(startEnabled);
        btnSafetyCheck.setEnabled(safetyCheckEnabled);
        btnLearning.setEnabled(learningEnabled);
        btnLearningSave.setEnabled(learningSaveEnabled);
        btnDrive.setEnabled(driveEnabled);
        btnAnalysis.setEnabled(analysisEnabled);
        btnReport.setEnabled(reportEnabled);
        btnStop.setEnabled(stopEnabled);
    }

    private void readCountFromFile(int resourceId) {
        try {
            InputStream inputStream = getResources().openRawResource(resourceId);
            BufferedReader br = new BufferedReader(new InputStreamReader(inputStream));
            String line;

            if ((line = br.readLine()) != null) {
                // 파일에서 읽은 값을 count 변수에 할당
                count = Integer.parseInt(line);
            }

            br.close();
            inputStream.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }


}
