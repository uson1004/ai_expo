package com.example.ai_expo;

import static com.google.gson.internal.$Gson$Types.arrayOf;
import static java.time.LocalDateTime.now;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;
import androidx.core.content.ContextCompat;

import android.Manifest;
import android.annotation.SuppressLint;
import android.content.Context;
import android.content.Intent;
import android.content.pm.PackageManager;
import android.database.Cursor;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;

import com.example.ai_expo.Dtos.PlantInfoDto;

import java.io.File;
import java.time.LocalTime;
import java.util.HashMap;
import java.util.Map;

import okhttp3.MediaType;
import okhttp3.MultipartBody;
import okhttp3.RequestBody;
import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class diary_3_activity extends AppCompatActivity {
    private static final int PICK_IMAGE_REQUEST = 1;
    ImageButton gotodiary;
    EditText editTextText2;
    EditText editTextText3;
    Button button2;
    Button button679;
    ImageView imageView222;

    private static final int GET_GALLERY_IMAGE = 200;
    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {


        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_diary3);
        Intent intent = new Intent(getApplicationContext(), diary_2_activity.class);
        Intent intent_management = new Intent(getApplicationContext(), plant_management.class);

        gotodiary = findViewById(R.id.gotodiary);
        editTextText2 = (EditText) findViewById(R.id.editTextText2);
        editTextText3 = (EditText) findViewById(R.id.editTextText3);
        button2 = (Button) findViewById(R.id.button67);
        button679 = (Button) findViewById(R.id.button679);
        imageView222 = (ImageView) findViewById(R.id.imageView18);


        int readPromess = ContextCompat.checkSelfPermission(this, Manifest.permission.READ_EXTERNAL_STORAGE);



        gotodiary.setOnClickListener(new View.OnClickListener() {
            public void onClick(View view) {
                startActivity(intent);
            }
        });

        //JournalDto journalDto = new JournalDto("", "", "");
        //JournalDtoResponse journalDtoResponse = new JournalDtoResponse(0, "", "", "", now(), new ArrayList<String>(), null);

        button679.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_PICK);
                intent.setDataAndType(MediaStore.Images.Media.EXTERNAL_CONTENT_URI, "image/*");
                intent.setAction(Intent.ACTION_GET_CONTENT);
                startActivityForResult(intent, GET_GALLERY_IMAGE);
            }
        });




        LocalTime time = LocalTime.from(now());
        //일기 API
        button2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ServerApi serverApi = ApiProvider.getInstance().create(ServerApi.class);
                Call<PlantInfoDto> call = serverApi.PickPhoto();


                String token = getSharedPreferences("prefs", Context.MODE_PRIVATE).getAll().get("Access_Token").toString();


                String title = editTextText2.getText().toString();
                String content = editTextText3.getText().toString();


                Log.e("fdf",title);
                Log.e("dfdf",content);

                Map<String, RequestBody> map = new HashMap<>();
                RequestBody titles = RequestBody.create(MediaType.parse("text/plain"),title);
                RequestBody contents = RequestBody.create(MediaType.parse("text/plain"),content);


                map.put("title",titles);
                map.put("content",contents);

                //MultipartBody.Part fbody = MultipartBody.create(MediaType.parse("image/jpeg"),) ;

                //일기 작성
                serverApi.JournalWrite(token,map).enqueue(new Callback<ResponseBody>() {
                    @Override
                    public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {
                        Log.d("result", String.valueOf(response.headers()));
                    }

                    @Override
                    public void onFailure(Call<ResponseBody> call, Throwable t) {
                        Log.d("err", t.getMessage());
//                        Log.d("title",title);
//                        Log.d("content",content);
                        Log.d("test",editTextText2.getText().toString());
                    }
                });

//                serverApi.GetAiSensor(token,).enqueue(new Callback<PlantInfoDto>() {
//                    @Override
//                    public void onResponse(Call<PlantInfoDto> call, Response<PlantInfoDto> response) {
//
//                    }
//
//                    @Override
//                    public void onFailure(Call<PlantInfoDto> call, Throwable t) {
//
//                    }
//                });
            }
        });

        // 일기 삭제
//        serverApi.JournalDelete().enqueue(new Callback<JournalDto>() {
//            @Override
//            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<JournalDto> call, Throwable t) {
//
//            }
//        });

        // 일기 선택
//        serverApi.JournalUpdate().enqueue(new Callback<JournalDto>() {
//            @Override
//            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<JournalDto> call, Throwable t) {
//
//            }
//        });

//        // 일기 조회
//        ServerApi.().enqueue(new Callback<JournalDto>() {
//            @Override
//            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<JournalDto> call, Throwable t) {
//
//            }
//        });
//
//        // 일기 전체 조회
//        serverApi.JournalSearchALL().enqueue(new Callback<JournalDto>() {
//            @Override
//            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<JournalDto> call, Throwable t) {
//
//            }
//        });
//
//        // 일기 수정하기
////        serverApi.JournalUpdate().enqueue(new Callback<JournalDto>() {
////            @Override
////            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
////
////            }
////
////            @Override
////            public void onFailure(Call<JournalDto> call, Throwable t) {
////
////            }
////        });
//
//        // 전체 일기 검색
//        serverApi.JournalSearchALL().enqueue(new Callback<JournalDto>() {
//            @Override
//            public void onResponse(Call<JournalDto> call, Response<JournalDto> response) {
//
//            }
//
//            @Override
//            public void onFailure(Call<JournalDto> call, Throwable t) {
//
//            }
//        });
//
//    }

    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if (requestCode == PICK_IMAGE_REQUEST && resultCode == RESULT_OK && data != null && data.getData() != null) {
            // 선택한 이미지의 Uri 가져오기
            Uri selectedImageUri = data.getData();

            Log.d("result",selectedImageUri.toString());

            // 선택한 이미지의 실제 경로 가져오기
            String imagePath = getPath(selectedImageUri);

            File imageFile = new File(imagePath);
            // 이미지 경로를 사용하여 필요한 작업 수행
            // imagePath를 사용하여 이미지를 업로드하거나 이미지 미리보기를 표시할 수 있습니다.
        }
    }

    private String getPath(Uri uri) {
        String[] projection = { MediaStore.Images.Media.DATA };
        Cursor cursor = getContentResolver().query(uri, projection, null, null, null);
        if (cursor == null) {
            return null;
        }
        int columnIndex = cursor.getColumnIndexOrThrow(MediaStore.Images.Media.DATA);
        cursor.moveToFirst();
        String path = cursor.getString(columnIndex);
        cursor.close();
        return path;
    }

    private void displayImage(File imageFile) {
        // 이미지 파일을 Bitmap 객체로 변환
        Bitmap bitmap = BitmapFactory.decodeFile(imageFile.getAbsolutePath());

        // ImageView에 Bitmap 설정
        imageView222.setImageBitmap(bitmap);
    }
}