package com.example.ai_expo.todoMainActivity;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.ai_expo.R;

import java.util.ArrayList;


    /*
     * Adapter 는 main 사이 중간자 역할을 한다.
     * item(Todo 객체) 과 연결해주는 하나의 포맷이다.
     * */

    public class TodoAdapter extends RecyclerView.Adapter<TodoAdapter.ViewHolder> { //alt+enter > 새로운 대안 도구

        private ArrayList<TodoDto> mData = null; //Todo라는 객체를 가진 ArrayList 생성

        // item View 를 저장하는 뷰홀더 클래스.
        public class ViewHolder extends RecyclerView.ViewHolder {

            protected EditText editTextText2;
            EditText editTextText3;
            Button button2;

            public ViewHolder(View itemView) { //itemView와 연결했기 때문에 findViewById 앞에 itemView를 명시한다.
                super(itemView);

                this.editTextText2 = itemView.findViewById(R.id.editTextText2);
                this.editTextText3 = itemView.findViewById(R.id.editTextText3);
                //this.deleteBt = itemView.findViewById(R.id.);


                //ArrayList 삭제 버튼
//                deleteBt.setOnClickListener(new View.OnClickListener() {
//                    @Override
//                    public void onClick(View v) {
//                        int position = getAdapterPosition(); //현재 어뎁터가 다루고 있는 리스트의 포지션을 가져온다.
//
//                        if(position != RecyclerView.NO_POSITION){ //삭제된 포지션이 아닌 경우
//                            mData.remove(position); //ArrayList<Todo> 타입의 리스트에서 해당 포지션의 item을 제거한다.
//                            notifyDataSetChanged(); //어뎁터에게 데이터 셋이 변경되었음을 알린다.
//                        }
//                    }
//                });
            }
        }

        // 생성자에서 데이터 리스트 객체를 전달받음.
        TodoAdapter(ArrayList<TodoDto> list){
            mData = list;
        }

        // onCreateViewHolder() - 아이템 뷰를 위한 뷰홀더 객체 생성하여 리턴. 이해하기 제일 어려운 부분!!!!!!!!!!!!
        @Override
        public TodoAdapter.ViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
            Context context = parent.getContext() ;
            LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE) ;

            View view = inflater.inflate(R.layout.recycler_item, parent, false) ;
            TodoAdapter.ViewHolder vh = new TodoAdapter.ViewHolder(view) ;

            return vh ;
        }

        // onBindViewHolder() - position에 해당하는 데이터를 뷰홀더의 아이템뷰에 표시.
        @Override
        public void onBindViewHolder(TodoAdapter.ViewHolder holder, int position) {
            holder.editTextText2.setText(mData.get(position).getTodoTitle()); //직접적으로 binding 해주는 것
            holder.editTextText3.setText(mData.get(position).getTodoBody());
            //textview_todo_item.setText("할 일"); 동일
        }

        // getItemCount() - 전체 데이터 갯수 리턴.
        @Override
        public int getItemCount() {
            return mData.size();
        }
    }
