package com.example.management;

import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.view.LayoutInflater;

import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.PopupWindow;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class MainActivity extends AppCompatActivity {

    //버튼액션정의
    private FButton btnStart;
    private FButton btnSafetyCheck;
    private FButton btnLearning;
    private FButton btnLearningSave;
    private FButton btnDrive;
    private FButton btnAnalysis;
    private FButton btnReport;
    private FButton btnStop;
    private FButton btnEmergencyStop;
    private TextView textView;
    private  int count = 0;

    //ip통신정의
    EditText editTextAddress, editTextPort;
    Button buttonConnect,buttonInitial,buttonDisconnect;
    TextView textViewState, textViewRx;
    ClientHandler clientHandler;
    ClientThread clientThread;

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
        getSupportActionBar().hide();
        //int flags = View.SYSTEM_UI_FLAG_HIDE_NAVIGATION | View.SYSTEM_UI_FLAG_FULLSCREEN | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY;
        //getWindow().getDecorView().setSystemUiVisibility(flags);
        //requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_main);


        //버튼동작
        btnStart = (com.example.management.FButton) findViewById(R.id.btnstart);
        btnSafetyCheck = (com.example.management.FButton) findViewById(R.id.btnsafetycheck);
        btnLearning = (com.example.management.FButton) findViewById(R.id.btnlearning);
        btnLearningSave = (com.example.management.FButton) findViewById(R.id.btnlearningsave);
        btnDrive = (com.example.management.FButton) findViewById(R.id.btndrive);
        btnAnalysis = (com.example.management.FButton) findViewById(R.id.btnanalysis);
        btnReport = (com.example.management.FButton) findViewById(R.id.btnreport);
        btnStop = (com.example.management.FButton) findViewById(R.id.btnstop);
        btnEmergencyStop = (com.example.management.FButton) findViewById(R.id.btnEmergencyStop);
        textView = findViewById(R.id.number);
        //ip통신
        editTextAddress = (EditText) findViewById(R.id.address);
        editTextPort = (EditText) findViewById(R.id.port);
        textViewState = (TextView)findViewById(R.id.state);
        textViewRx = (TextView)findViewById(R.id.received);
        buttonInitial = (Button)findViewById(R.id.initial);
        buttonConnect = (Button) findViewById(R.id.connect);
        buttonDisconnect = (Button) findViewById(R.id.disconnect);

        buttonDisconnect.setEnabled(false);
        buttonInitial.setEnabled(false);

        buttonConnect.setOnClickListener(buttonConnectOnClickListener);
        buttonDisconnect.setOnClickListener(buttonDisConnectOnClickListener);
        buttonInitial.setOnClickListener(buttonInitialOnClickListener);

        clientHandler = new ClientHandler(this);

        //버튼액션
        btnStart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(clientThread != null){
                    String msgToSend = "start";
                    clientThread.txMsg(msgToSend);

                }

                //showCustomPopupMenu(btnStart);
                //showOptionDialog_start();

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
                showCustomPopupMenu(btnLearning);
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

    //ip통신
    View.OnClickListener buttonConnectOnClickListener = new View.OnClickListener() {

        @Override
        public void onClick(View arg0) {

            clientThread = new ClientThread(
                    editTextAddress.getText().toString(),
                    Integer.parseInt(editTextPort.getText().toString()),
                    new ClientHandler(MainActivity.this));
            clientThread.setParent(MainActivity.this);
            clientThread.start();

            buttonConnect.setEnabled(false);
            buttonDisconnect.setEnabled(true);
            buttonInitial.setEnabled(true);
        }
    };

    View.OnClickListener buttonInitialOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(clientThread != null){
                String msgToSend = "initial";
                clientThread.txMsg(msgToSend);

            }
        }
    };

    View.OnClickListener buttonDisConnectOnClickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            if(clientThread != null){
                clientThread.setRunning(false);
            }
        }
    };

    //ip통신
    private void updateState(String state){
        textViewState.setText(state);
    }

    public void updateRxMsg(String rxmsg){
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                textViewRx.append(rxmsg + "\n");
            }
        });
    }

    private void clientEnd(){
        clientThread = null;
        textViewState.setText("clientEnd()");
        buttonConnect.setEnabled(true);
        buttonInitial.setEnabled(false);

    }

    public static class ClientHandler extends Handler {
        public static final int UPDATE_STATE = 0;
        public static final int UPDATE_MSG = 1;
        public static final int UPDATE_END = 2;
        private MainActivity parent;

        public ClientHandler(MainActivity parent) {
            super(Looper.getMainLooper());
            this.parent = parent;
        }

        @Override
        public void handleMessage(Message msg) {

            switch (msg.what){
                case UPDATE_STATE:
                    parent.updateState((String)msg.obj);
                    break;
                case UPDATE_MSG:
                    parent.updateRxMsg((String)msg.obj);
                    break;
                case UPDATE_END:
                    parent.clientEnd();
                    break;
                default:
                    super.handleMessage(msg);
            }

        }

    }
    /*
    //버튼액션
    private void showOptionDialog_start() {
        //Context context = new ContextThemeWrapper(this, R.style.PopupMenuFontStyle);
        PopupMenu popupMenu = new PopupMenu(getApplicationContext(), btnStart);
        getMenuInflater().inflate(R.menu.popup,popupMenu.getMenu());
        //popupMenu.getMenu().add("Option 1");
        //popupMenu.getMenu().add("Option 2");
        // 원하는 만큼의 옵션 추가

        popupMenu.setOnMenuItemClickListener(new PopupMenu.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                if (item.getItemId() == R.id.action_menu1){
                    // Option 1 선택 시 동작
                }else if (item.getItemId() == R.id.action_menu2){
                    // Option 2 선택 시 동작
                }else {
                    // ... Toast.makeText(MainActivity.this, "메뉴 3 클릭", Toast.LENGTH_SHORT).show();
                }

                return false;


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
    */

    private void showCustomPopupMenu(View view) {
        LayoutInflater inflater = (LayoutInflater) getSystemService(LAYOUT_INFLATER_SERVICE);
        View popupView = inflater.inflate(R.layout.popup, null);

        // 팝업 윈도우 생성
        PopupWindow popupWindow = new PopupWindow(
                popupView,
                WindowManager.LayoutParams.WRAP_CONTENT,
                WindowManager.LayoutParams.WRAP_CONTENT
        );
        // 팝업 외부를 터치하면 닫히도록 설정
        popupWindow.setOutsideTouchable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable());
        // 팝업 내부의 TextView 등의 요소에 대한 조작 가능
        TextView option1 = popupView.findViewById(R.id.option1);
        TextView option2 = popupView.findViewById(R.id.option2);
        // 여기서 TextView 등을 찾고 setTextSize 등을 통해 크기를 조절 가능

        // 팝업 표시 위치 설정
        popupWindow.showAsDropDown(view, 10, 0); // 원하는 위치로 조정 *dp기준임

        // 팝업 윈도우 내의 요소에 대한 클릭 리스너 등록
        option1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Option 1 선택 시 동작
            }
        });

        option2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // Option 2 선택 시 동작
            }
        });
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